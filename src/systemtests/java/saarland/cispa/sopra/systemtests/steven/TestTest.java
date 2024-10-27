package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	             "A.\n" +
	             ".B\n";
	        String brainA = "brain \"sample\" {\njump 2\n turn left\n set 0\nset 1\nset 2\nset 3\nset 4\nset 5\n"
	        				+ "test 0 else 1\ntest 1 else 1\ntest 2 else 1\n"
	        				+ "test 3 else 1\ntest 4 else 1\ntest 5 else 1\n"
	        				+ "jump 14\n}";
	        String brainB = "brain \"sample\" {\nturn left\n jump 0\n}";
	        WorldInfo world = gameInfo.simulate(20, 42, map, brainA, brainB);

	        if("west".equals(world.getAnt(0).getDirection())) {
	        	fail("Test did not work correctly for ant 0 for positive register values!");
	        }
	 }
}

