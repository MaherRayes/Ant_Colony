package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class UnmarkAndMarkTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "4\n4\n" +
	             "....\n" +
	             ".A..\n"
	            +"..B.\n"
	            +"....";
	        String brainA = "brain \"sample\" {\nmark 1\nmove else 0\nturn right\nturn right\nturn right\nmove else 0\n"
	        				+ "sense here marker 1 else 8\njump 7\nset 0\n jump 9\n}";
	        String brainB = "brain \"sample\" {\nmark 1\nmove else 0\nunmark 1\nturn right\nmove else 0\n"
	        		+ "jump 5\n}";
	        WorldInfo world = gameInfo.simulate(80, 42, map, brainA, brainB);
	        if(world.getAnt(0).getRegister()[1]) {
	        	fail("unmark overwrote a marker from swarm A by B!");
	        }
	 }
}

