package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class TurnRightTwiceTest extends SystemTest {
	private final static String east = "east";
	private final static String rightBrain = "brain \"rT\" {\nturn right\nturn right\nset 0\njump 2\n}";
	private final static String brain = "brain \"rT\" {\nturn right\nturn right\njump 0\n}";
	private final static String map ="2\n2\n" +
            						 "A.\n" +
            						 "B.";

    @Override
    public void test(GameInfo gameInfo) {
    	WorldInfo world = gameInfo.simulate(4, 42, map, rightBrain, brain);
        if(!TurnRightTwiceTest.east.equals(world.getAnt(0).getDirection())) {
        	fail("Expected after 2 single turn right east direction, but was: "+world.getAnt(0).getDirection());
        }
    }
}
