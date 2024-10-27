package saarland.cispa.sopra.saarmeisen;

import saarland.cispa.sopra.saarmeisen.field.*;

import java.util.*;

public class WorldParser {

    public static final char ROCK_CHAR = '#';
    public static final char ANTLION_CHAR = '=';

    public World parseWorld(String map, Map<Character, Program> programs) {
        checkNotNull(map);

        if(map.contains("\r")) {
            throw new IllegalArgumentException("\\r is evil");
        }
        // TODO what if map is null?
        int numTeams = map.chars().filter(testChar -> testChar >= 'A' && testChar <= 'Z').max().orElse('A') - 'A' + 1;
        if(numTeams < 2) {
            throw new IllegalArgumentException("too less teams");
        }

        checkStringSanity(map);

        Scanner scanner = new Scanner(map);

        int width;
        int height;

        try {
            width = scanner.nextInt();
            height = scanner.nextInt();
        } catch(InputMismatchException e) {
            throw new IllegalArgumentException("parser w&h wrong", e);
        }
        checkDimensions(width, height);

        // consume newline
        scanner.nextLine();

        int runningId = 0;
        Field[][] fields = new Field[width][height];
        HashMap<Character, Swarm> swarms = new HashMap<>();
        List<Ant> antsOnField = new ArrayList<>();

        for(int hCounter = 0; hCounter < height; hCounter++) {
            checkScannerLeft(scanner);
            char[] currentLine = scanner.nextLine().toCharArray();

            checkMapWidth(width, currentLine);

            for(int wCounter = 0; wCounter < width; wCounter++) {

                char descChar = currentLine[wCounter];
                Field field;

                if(descChar >= 'A' && descChar <= 'Z') {

                    Swarm swarm = getSwarm(programs, swarms, descChar);

                    swarm.setAnts(swarm.getAnts() + 1);

                    field = new BaseField(wCounter, hCounter, null, numTeams, swarm);

                    Brain antBrain = new Brain();

                    Ant ant = new Ant(field, runningId, false, swarm, 0, antBrain, Direction.northwest);
                    runningId++;
                    addAnt(antsOnField, field, ant);
                } else {

                    field = getField(numTeams, hCounter, wCounter, descChar);

                }

                fields[wCounter][hCounter] = field;

            }

        }

        if(scanner.hasNext() || scanner.hasNextLine()) {
            throw new IllegalArgumentException("map file was not at eof after fully read.");
        }

        return new World(width, height, antsOnField, fields, swarms);
    }

    private void checkNotNull(String mapppp) {
        if(mapppp == null){
            throw new IllegalArgumentException("map was null");
        }
    }

    private void checkMapWidth(int width, char[] currentLine) {
        if(currentLine.length != width) {
            throw new IllegalArgumentException("map width doesnt match");
        }
    }

    private void addAnt(List<Ant> antsOnField, Field field, Ant ant) {
        field.setAnt(ant);
        antsOnField.add(ant);
    }

    private void checkScannerLeft(Iterator<String> scanner) {
        if(!scanner.hasNext()) {
            throw new IllegalArgumentException("height big, none left");
        }
    }

    private void checkDimensions(int width, int height) {
        if(width % 2 != 0 || height % 2 != 0 || width < 2 || height < 2) {
            throw new IllegalArgumentException("w&h wrong");
        }
    }

    private Field getField(int numTeams, int hCounter, int wCounter, char descChar) {
        Field field;
        if(descChar == '.' || descChar >= '1' && descChar <= '9') {
            int food = descChar == '.' ? 0 : Integer.parseInt(new String(new char[] {descChar}));

            field = new PlaneField(wCounter, hCounter, food, numTeams);
        } else if(descChar == ROCK_CHAR) {
            field = new RockField(wCounter, hCounter, numTeams);
        } else if(descChar == ANTLION_CHAR) {
            field = new AntLionField(wCounter, hCounter, numTeams);
        } else {
            throw new IllegalArgumentException("invalid token " + descChar);
        }
        return field;
    }

    private Swarm getSwarm(Map<Character, Program> programs, Map<Character, Swarm> swarms, char descChar) {
        Swarm swarm = swarms.get(descChar);
        if(swarm == null) {
            Program program = programs.get(descChar);
            if(program == null) {
                throw new IllegalArgumentException("did not find brain");
            }
            swarm = new Swarm(descChar, 0, program);
            swarms.put(descChar, swarm);
        }
        return swarm;
    }

    private void checkStringSanity(String map) {
        String[] lines = map.split("\n");
        if(Arrays.stream(lines).filter(strr -> strr.contains(" ")).anyMatch(strr -> true)) {
            throw new IllegalArgumentException("whitespace in map");
        }
        try {
            Integer.parseInt(lines[0]);
            Integer.parseInt(lines[1]);
        } catch(NumberFormatException nfee) {
            throw new IllegalArgumentException("w/h falsche pos", nfee);
        }
        // TODO uU mehr checks?
    }

}
