package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class SenseFoeTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map = "2\n2\n" +
	            "AA\n" +
	            ".B";
	        String brainB = "brain \"sample\" {\nturn right\njump 0\n}";
	        String brainASenseHere = "brain \"sample\" {\nsense here foe else 2\nset 0\njump 2\n}";
	        String brainASenseLeft = "brain \"sample\" {\nsense right foe else 2\nset 0\njump 2\n}";
	        WorldInfo worldSenseHere = gameInfo.simulate(1, 42, map, brainASenseHere, brainB);
	        WorldInfo worldSenseLeft = gameInfo.simulate(1, 42, map, brainASenseLeft, brainB);
	        if(worldSenseHere.getAnt(0).getRegister()[0]) {
	        	fail("The ant sensed itself as foe!");
	        }
	        if(worldSenseLeft.getAnt(0).getRegister()[0]) {
	        	fail("The ant sensed a friend as foe!");
	        }
    }
}

