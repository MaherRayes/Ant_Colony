package saarland.cispa.sopra.systemtests.giuliano;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.FieldInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseTest extends SystemTest {

    //TODO Change to assertions
    public boolean hasAntAt(WorldInfo world, int x, int y) {
        return world.getFieldAt(x, y).getAnt().isPresent();
    }

    public boolean hasAntAt(WorldInfo world, int x, int y, AntInfo ant) {
        if(ant == null) {
            return false;
        }
        AtomicBoolean res = new AtomicBoolean(false);
        world.getFieldAt(x, y).getAnt().ifPresent(a -> res.set(a.equals(ant)));
        return res.get();
    }

    public boolean hasAntAt(WorldInfo world, int x, int y, int antID) {
        return hasAntAt(world, x, y, world.getAnt(antID));
    }

    public void checkAntAmount(WorldInfo w, int expected) {
        if(w.getAnts().size() != expected) {
            fail(String.format("Expected world to contain %d ants but were %d.", expected, w.getAnts().size()));
        }
    }

    public void checkScore(WorldInfo w, char swarm, int expected) {
        if(w.getScore(swarm) != expected) {
            fail(String.format("Expected swarm %c to have score %d but was %d.", swarm, expected, w.getScore(swarm)));
        }
    }

    public void checkSwarm(AntInfo ant, char expected) {
        if(ant.getSwarm() != expected) {
            fail(String.format("Ant %d should be swarm %c but was %c.",ant.getId(),expected,ant.getSwarm()));
        }
    }

    public void checkNoAntAt(WorldInfo w, int x, int y) {
        if(w.getFieldAt(x, y).getAnt().isPresent()) {
            fail(String.format("Expected field (%d,%d) not to have an ant.", x, y));
        }
    }

    public void checkAntAt(WorldInfo w, int x, int y) {
        if(!w.getFieldAt(x, y).getAnt().isPresent()) {
            fail(String.format("Expected field (%d,%d) to have an ant.", x, y));
        }
    }
    public void checkCoordinates(int x, int y) {
        assert x >= 0;
        assert y >= 0;
    }

    public void checkFood(FieldInfo field, int expected) {
        if(field.getFood() != expected) {
            fail(String.format("Field (%d,%d) of type %c should have %d food but had %d food.", field.getX(), field.getY(), field.getType(), expected,
                field.getFood()));
        }
    }

    public void checkDirection(AntInfo ant, Direction expected) {
        if(!ant.getDirection().equals(expected.toString())) {
            fail(String.format("Expected direction %s as ant %d's direction but got %s", ant.getDirection(), ant.getId(), expected));
        }

    }

    public void checkHasFood(AntInfo ant, boolean expected) {
        if(ant.hasFood() != expected) {
            fail(String.format("Expected ant %d to have food: %b but was inverted.", ant.getId(), expected));
        }
    }

    public void checkRestTime(AntInfo ant, int expected) {
        if(ant.getRestTime() != expected) {
            fail(String.format("Expected rest time of %d but got %d.", expected, ant.getRestTime()));
        }
    }

    public void checkPC(AntInfo ant, int expected) {
        if(ant.getPc() != expected) {
            fail(String.format("Expected a PC of %d but got %d.", expected, ant.getPc()));
        }
    }

    public void checkID(AntInfo ant, int expected) {
        if(ant.getId() != expected) {
            fail(String.format("Expected id of ant %d to be %d.", ant.getId(), expected));
        }
    }

    public void checkPosition(AntInfo ant, int x, int y) {
        int xi = ant.getField().getX();
        int yi = ant.getField().getY();
        if(xi != x || yi != y) {
            fail(String.format("Ant %d was on (%d,%d) but expected (%d,%d).", ant.getId(), xi, yi, x, y));
        }
    }

    public void checkPosition(AntInfo ant, int x, int y, int prevX, int prevY, String direction) {
        int xi = ant.getField().getX();
        int yi = ant.getField().getY();
        if(xi != x || yi != y) {
            fail(String.format("Ant %d went %s from (%d,%d) was on (%d,%d) but expected (%d,%d).", ant.getId(),direction,prevX,prevY, xi, yi, x, y));
        }
    }

    public void checkValidField(WorldInfo world, int x, int y) {
        try {
            world.getFieldAt(x, y);
        } catch(NoSuchElementException e) {
            fail(String.format("Field (%d,%d) should be valid but no such element fount.", x, y));
        }
    }

    public String buildSimpleMap() {
        return "6\n6\n" + "......\n" + ".A....\n" + "..3...\n" + "...BB.\n" + "..#...\n" + "......";
    }

    public String buildCustomMap(char[] replace, char[] replacements) {
        String map = "4\n4\nabcd\nefgh\nijkl\nmnop";
        for(int i = 0; i < replace.length; i++) {
            map = map.replace(replace[i], replacements[i]);
        }
        for(int i = 0; i < map.length(); i++) {
            if(map.charAt(i) >= 'a' && map.charAt(i) <= 'z') {
                map = map.replace(map.charAt(i), '.');
            }
        }
        return map;
    }

    public String buildCustomMap(char a, char b) {
        char[] replace = {a, b};
        char[] replacements = {'A', 'B'};
        return buildCustomMap(replace, replacements);
    }

    public void generateByMap(GameInfo gameInfo, String map) {
        gameInfo.simulate(0, 0, map, getEmptyBrain(), getEmptyBrain());
    }

    public String generateBrain(List<String> code) {
        return generateBrainWithName("dummy", code);
    }

    public String generateBrain(String... code) {
        return generateBrainWithName("dummy", code);
    }

    public String generateBrainWithName(String name, List<String> code) {
        return generateBrainWithName(name, code.toArray(new String[0]));
    }

    public String generateBrainWithName(String name, String... code) {
        StringBuilder sb = new StringBuilder("brain \"").append(name).append("\" {\n");
        for(String snippet : code) {
            sb.append(snippet).append('\n');
        }
        sb.append('}');
        return sb.toString();
    }

    public String getEmptyBrain() {
        return generateBrain("jump 0");
    }
}
