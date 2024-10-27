package saarland.cispa.sopra.saarmeisen;

import org.slf4j.LoggerFactory;
import saarland.cispa.sopra.saarmeisen.antlr.ProgramParser;
import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.instruction.Instruction;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import javax.json.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements GameInfo {

    private static final char ANT_LION_SYMBOL = '=';
    private static final char THIS_IS_WORLD_WAR_Z = 'Z';
    private static final int ENEMYANT_THRESHHOLD = 5;

    private JsonBuilderFactory factory;
    private JsonArrayBuilder stepsBuilder;
    private JsonObject initObject;
    private World world;

    private boolean writeLog;

    public void setWriteLog(boolean writeLog) {
        this.writeLog = writeLog;
    }

    private String readWholeFile(File file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(Files.newBufferedReader(Paths.get(file.toURI())));

            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while(line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            String everything = stringBuilder.toString();
            bufferedReader.close();
            return everything;
        } catch(IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Override
    public WorldInfo simulate(int rounds, long seed, File world, File... brains) {
        String worldString = readWholeFile(world);
        String[] readBrains = Arrays.stream(brains).map(this::readWholeFile).toArray(String[]::new);
        return simulate(rounds, seed, worldString, readBrains);
    }

    @Override
    public WorldInfo simulate(int rounds, long seed, String map, String... brains) {
        factory = Json.createBuilderFactory(null);
        stepsBuilder = factory.createArrayBuilder();

        isRoundsTooSmall(rounds);
        Random random = new Random(seed);
        ProgramParser programParser = new ProgramParser();

        char team = 'A';
        Map<Character, Program> teamToProgram = new HashMap<>(brains.length);
        for(String brain : brains) {
            Logger.getLogger("log").log(Level.FINEST, "parsing " + brain);
            Program program = programParser.parseProgram(brain, random, team);
            teamToProgram.put(team, program);
            if(team > THIS_IS_WORLD_WAR_Z) {
                throw new IllegalArgumentException("too much brains. char > 'Z'");
            }
            team++;
        }
        WorldParser worldParser = new WorldParser();
        world = worldParser.parseWorld(map, teamToProgram);

        if(world.getSwarms().size() != brains.length) {
            throw new IllegalArgumentException("brain num does not match");
        }

        if(writeLog){
            initObject = world.serializeInit(factory);

        }

        reallyRun(rounds);

        return world;
    }

    private void reallyRun(int rounds) {
        for(int currentRound = 0; currentRound < rounds; currentRound++) {
            for(Ant toSimulate : world.getAntObjects()) {
                if(toSimulate.isAlive()) {
                    Instruction current = toSimulate.getNextInstruction();
                    current.run(world, toSimulate);
                    if(current.checkSideEffectKill()) {
                        for(Ant toCheck : world.getAntObjects()) {
                            if(!toCheck.isAlive()) {
                                continue;
                            }
                            if(toCheck.equals(current.getAffectedAnt())) {
                                checkForAntLion(toCheck);
                            }
                            if(!toCheck.isAlive()) {
                                continue;
                            }
                            checkForAntDeaths(toCheck);
                        }

                    }

                }

            }

            if(writeLog) {
                JsonObjectBuilder currentStep = factory.createObjectBuilder();
                JsonArrayBuilder standingsArray = factory.createArrayBuilder();
                world.getSwarms().stream().map(swarm -> swarm.serialize(factory)).forEach(standingsArray::add);
                currentStep.add("standings", standingsArray);
                currentStep.add("fields", world.serializeChanges(factory));
                stepsBuilder.add(currentStep);
            }
            // TODO write log after this state. reset wasChanged.
        }
    }

    public void printResults() {
        org.slf4j.Logger logger = LoggerFactory.getLogger("results");
        Map<Character, Swarm> swarmMap = world.getSwarmMap();
        ArrayList<Swarm> winners = new ArrayList<>();
        Swarm swarm;
        for(char c = 'A'; c < 'A' + swarmMap.size(); c++) {
            swarm = swarmMap.get(c);
            logger.info(String.format("%c: %d/%d", c, swarm.getScore(), swarm.getAnts()));
            if(winners.isEmpty()) {
                winners.add(swarm);
            } else if(winners.get(0).getScore() < swarm.getScore()) {
                winners.clear();
                winners.add(swarm);
            } else if(winners.get(0).getScore() == swarm.getScore()) {
                if(winners.get(0).getAnts() < swarm.getAnts()) {
                    winners.clear();
                    winners.add(swarm);
                } else if(winners.get(0).getAnts() == swarm.getAnts()) {
                    winners.add(swarm);
                }
            }
        }

        if(winners.size() == 1) {
            logger.info(String.format("Winner: %c", winners.get(0).getName()));
        } else {
            StringBuilder builder = new StringBuilder("Draw:");
            for(Swarm drawSwarm : winners) {
                builder.append(' ');
                builder.append(new String(new char[] {drawSwarm.getName()}));
            }
            logger.info(builder.toString());
        }
    }

    private void isRoundsTooSmall(int rounds) {
        if(rounds < 0) {
            throw new IllegalArgumentException("rounds darf nicht kleiner als 0 sein");
        }
    }

    public void checkForAntDeaths(Ant toCheck) {
        if(!toCheck.isAlive()) {
            return;
        }
        List<Ant> hostileAnts = world.getHostileNeighborAnts(toCheck);
        if(hostileAnts.size() >= ENEMYANT_THRESHHOLD) {
            world.killAnt(toCheck);
        }
    }

    public void checkForAntLion(Ant toCheck) {
        if(!toCheck.isAlive()) {
            return;
        }
        //Field the ant sits on
        Field field = toCheck.getField();
        if(field.getType() == ANT_LION_SYMBOL) {
            world.eatAnt(toCheck);
            return;
        }
        //neighbouring fields of ant
        List<Field> neighbourFields = world.getNeighborFields(field);
        for(Field currentField : neighbourFields) {
            if(currentField.getType() == ANT_LION_SYMBOL) {
                world.eatAnt(toCheck);
                break;
            }
        }
    }

    public void setWorld(World world) {

        this.world = world;

    }

    public String serialize() {

        if(!writeLog){
            throw new IllegalArgumentException("cannot write log, since it was explicitly disabled!");
        }

        JsonObjectBuilder builder = factory.createObjectBuilder();

        builder.add("init", initObject);
        builder.add("steps", stepsBuilder);

        return builder.build().toString();

    }
}
