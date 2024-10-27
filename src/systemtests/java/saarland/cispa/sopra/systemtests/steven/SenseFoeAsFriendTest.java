package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class SenseFoeAsFriendTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map = "2\n2\n" +
	            "AA\n" +
	            ".B";
	        String brainA = "brain \"sample\" {\nturn right\njump 0\n}";
	        String brainBSenseAhead = "brain \"sample\" {\nsense ahead friend else 2\nset 0\njump 2\n}";
	        WorldInfo worldSenseAhead = gameInfo.simulate(1, 42, map, brainA, brainBSenseAhead);
	        if(worldSenseAhead.getAnt(0).getRegister()[0]) {
	        	fail("The ant sensed a foe as friend!");
	        }
    }
}

