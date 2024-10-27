package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class UnmarkTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "4\n4\n" +
	             "....\n" +
	             ".A..\n"
	            +"..B.\n"
	            +"....";
	        String brainA = "brain \"sample\" {\nmark 0\nmark 1\nmark 2\nmark 3\nmark 4\nmark 5\nmark 6\n"
	        			  + "move else 0\njump 8\n}";
	        String brainB = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\n"
	        		+ "turn left \nturn left \nturn left \nturn left \n"
	        		+ "move else 8\n"
	        		+ "unmark 0\nunmark 1\nunmark 2\nunmark 3\nunmark 4\nunmark 5\n unmark 6\n"
	        		+ "jump 16\n}";
	        WorldInfo world = gameInfo.simulate(80, 42, map, brainA, brainB);
	        for(Boolean b : world.getFieldAt(1, 1).getMarkers().get('A')) {
	        	if(!b) {
	        		fail("Ant 1 from swarm B was able to delete a marker from Ant 0 in swarm A!");
	        	}
	        }
	 }
}

