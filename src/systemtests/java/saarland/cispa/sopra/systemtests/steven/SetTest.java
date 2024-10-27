package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SetTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	             "A.\n" +
	             ".B\n";
	        String brainA = "brain \"sample\" {\nset 0\nset 1\nset 2\nset 3\nset 4\nset 5\njump 0\n}";
	        String brainB = "brain \"sample\" {\nturn left\n jump 0\n}";
	        WorldInfo world = gameInfo.simulate(7, 42, map, brainA, brainB);

	        for(Boolean b : world.getAnt(0).getRegister()) {
	        	if(!b) {
	        		fail("Set did not work for a register for ant 0!");
	        	}
	        }
	 }
}

