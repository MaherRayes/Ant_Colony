package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestFunctionsOfInterfaceEquals extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "A.\n" +
            ".B";
        String brain = "brain \"sample\" {\nmove else 0\njump 0\n}";
        String brainA = "brain \"sample\" {\nturn right\njump 0\n}";

        WorldInfo world = gameInfo.simulate(2, 42, map, brainA, brain);
        if(!world.equals(world)) {
        	fail("Equals does not work for world!");
        }
        if(!world.getAnt(0).equals(world.getAnt(0))) {
        	fail("Equals does not work for ant!");
        }
        if(!world.getFieldAt(0, 0).equals(world.getFieldAt(0, 0))) {
        	fail("Equals does not work for field!");
        }
        if(!world.getFieldAt(0, 0).equals(world.getAnt(0).getField())) {
        	fail("Equals does not work with field from map and field from ant!");
        }
    }
}
