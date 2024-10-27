package saarland.cispa.sopra.systemtests.simon;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseTest extends SystemTest {

    private static final String generischerBrainName = "Braaaaaaiins";
    private int brainCounter; // = 0

    protected WorldInfo worldInfo;
    protected GameInfo gameInfo;
    private final List<AntTestObject> allSeenAnts = new ArrayList<>();
    private Mapper mapper = new Mapper(4, 4);

    public BaseTest() {
        mapper.setField(0, 0, 'A');
        mapper.setField(1, 0, 'B');
    }

    public Mapper setMapper(Mapper mapper) {
        this.mapper = mapper;
        return this.mapper;
    }

    public Mapper getMapper() {
        return mapper;
    }


    public String createNewBrain(String... inst) {
        return createNewBrainWithName(generischerBrainName + (brainCounter++), inst);
    }
    public String createNewBrainWithName(String name, String... inst) {
        return "brain \"" + name + "\" {\n" + Arrays.stream(inst).reduce("", (a, b) -> a + "\n" + b) + "\n}";
    }


    public String trivialBrain() {
        return createNewBrain("jump 0");
    }

    public void verifyAnts(AntTestObject... ants) {
        Arrays.stream(ants).forEach(this::verifyAnt);
    }


    public void verifyAnt(AntTestObject testAnt) {
        allSeenAnts.add(testAnt);
        AntInfo ai = worldInfo.getAnt(testAnt.getId());
        if (testAnt.isTestPos() && ai.getField().getX() != testAnt.getXpos()) {
            fail("Ant xpos fail. Should be " + testAnt.getXpos() + " was " + ai.getField().getX());
        }
        if (testAnt.isTestPos() && ai.getField().getY() != testAnt.getYpos()) {
            fail("Ant ypos fail. Should be " + testAnt.getYpos() + " was " + ai.getField().getY());
        }

        if (testAnt.isTestPc() && ai.getPc() != testAnt.getPc()) {
            fail("Ant pc fail. Antid=" + testAnt.getId());
        }
        if (testAnt.isTestDir() && !ai.getDirection().equals(testAnt.getDirection())) {
            fail("Dir non match. Antid=" + testAnt.getId());
        }
        if (testAnt.isCheckFood() && testAnt.isHasFood() != ai.hasFood()) {
            fail("Food non match. Antid=" + testAnt.getId());
        }
        if (testAnt.isCheckRegisters()) {
            if (ai.getRegister().length == 6) {
                for (int i = 0; i < testAnt.getRegisters().length; i++) {
                    if (ai.getRegister()[i] != testAnt.getRegisters()[i]) {
                        fail("Register mismatch");
                    }
                }
            } else {
                fail("Register size");
            }
        }
        if(testAnt.isCheckRestTime()){
            if(ai.getRestTime() != testAnt.getRestTime()){
                fail("Rest time does not match");
            }
        }


    }

    public void verifyMapper(Mapper mapper) {
        if (!mapper.compareToWorldInfo(this)) {
            fail("Mapper comparison failed.");
        }
    }

    public void verifyMarker(int x, int y, char team, boolean... marker) {
        boolean[] orig = worldInfo.getFieldAt(x, y).getMarkers().get(team);
        if (orig == null) {
         //   fail("orig is null");
            for (boolean aMarker : marker) {
                if (aMarker) {
                    fail("expected set marker, but marker arr was null");
                }
            }
            return;
        }
        if (orig.length != 7) {
            fail("orig len mismatch");
        }
        for (int i = 0; i < marker.length; i++) {
            if (orig[i] != marker[i]) {
                fail("Marker mismatch");
            }
        }
    }

    public void verifyNoMoreAnts() {
        if (worldInfo.getAnts().size() != allSeenAnts.size()) {
            fail("Ant size ist irgendwie komisch. Wurden Dinge zweimal geaddet? Sollte: " + worldInfo.getAnts().size() + " war aber " + allSeenAnts.size());
        }
    }


    public void verifyFutterOn(int x, int y, int anzahl) {
        if (worldInfo.getFieldAt(x, y).getFood() != anzahl) {
            fail("Futteranzahl falsch");
        }
    }

    public void verifyScore(char swarm, int score) {
        if (worldInfo.getScore(swarm) != score) {
            fail("Score falsch");
        }
    }

    public void simulate(int rounds, long seed, File world, File... brains) {
        this.worldInfo = gameInfo.simulate(rounds, seed, world, brains);
    }

    public void simulate(int rounds, long seed, String world, String... brains) {
        this.worldInfo = gameInfo.simulate(rounds, seed, world, brains);
    }

    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public WorldInfo getWorldInfo() {
        return worldInfo;
    }
}
