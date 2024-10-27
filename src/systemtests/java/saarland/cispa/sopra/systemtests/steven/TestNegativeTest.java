package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestNegativeTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	             "A.\n" +
	             ".B";
	        String brainA = "brain \"sample\" {\nunset 0\nunset 1\nunset 2\nunset 3\nunset 4\nunset 5\n" //0-5
	        				+ "test 0 else 9\nturn left\njump 24\n"//6-8
	        				+ "test 1 else 12\nturn left\njump 24\n"//9-11
	        				+ "test 2 else 15\nturn left\njump 24\n"//12-14
	        				+ "test 3 else 18\nturn left\njump 24\n"//15-17
	        				+ "test 4 else 21\nturn left\njump 24\n"//18-20
	        				+ "test 5 else 24\nturn left\njump 24\n"//21-23
	        				+ "jump 24\n}";//24
	        String brainB = "brain \"sample\" {\nturn left\n jump 0\n}";
	        WorldInfo world = gameInfo.simulate(30, 42, map, brainA, brainB);

	        if("west".equals(world.getAnt(0).getDirection())) {
	        	fail("Test did not work correctly for ant 0 for false register values!");
	        }
	 }
}

