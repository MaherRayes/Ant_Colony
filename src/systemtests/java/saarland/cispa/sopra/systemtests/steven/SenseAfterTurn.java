package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class SenseAfterTurn extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            	 ".#\n"
	            	 +"AB";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
		String brainBSenseAhead = "brain \"sample\" {\nsense ahead rock else 2\nset 0\njump 2\n}";
		String brainBSenseRight = "brain \"sample\" {\nturn left\nsense right rock else 3\nset 0\njump 3\n}";
		String brainBSenseLeft = "brain \"sample\" {\nturn right\nsense left rock else 3\nset 0\njump 3\n}";
		WorldInfo worldSenseAhead = gameInfo.simulate(1, 42, map, brain, brainBSenseAhead);
		WorldInfo worldSenseRight = gameInfo.simulate(1, 42, map, brain, brainBSenseRight);
		WorldInfo worldSenseLeft = gameInfo.simulate(1, 42, map, brain, brainBSenseLeft);

        if(worldSenseAhead.getAnt(1).getRegister()[0]) {
        	fail("Sense does not adjust to the direction the ant is turning!");
        }
        if(worldSenseRight.getAnt(1).getRegister()[0]) {
        	fail("Sense does not adjust to the direction the ant is turning!");
        }
        if(worldSenseLeft.getAnt(1).getRegister()[0]) {
        	fail("Sense does not adjust to the direction the ant is turning!");
        }

	}

}
