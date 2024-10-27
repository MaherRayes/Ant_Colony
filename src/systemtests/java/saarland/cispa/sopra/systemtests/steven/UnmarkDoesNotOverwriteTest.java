package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class UnmarkDoesNotOverwriteTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            "AB\n" +
	            "..";
	        String brainB = "brain \"sample\" {\nmark 0\nmark 1\nmark 2\nmark 3\nmark 4\nmark 5\nmark 6\nturn left\nmove else 8\n"
	        			  + "unmark 0\n"
	        			  + "unmark 1\n"
	        			  + "unmark 2\n"
	        			  + "unmark 3\n"
	        			  + "unmark 4\n"
	        			  + "unmark 5\n"
	        			  + "unmark 6\n"
	        			  + "\njump 16\n}";
	        String brainA = "brain \"sample\" {\nmark 0\nmark 1\nmark 2\nmark 3\nmark 4\nmark 5\nmark 6\n"
	        				+ "move else 0\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(100, 42, map, brainA, brainB);
	        for(Boolean b : world.getFieldAt(0, 0).getMarkers().get('A')) {
	        	if(!b) {
	        		fail("Ant 1 was able to overwrite Ant 0s markers with unmark!");
	        	}
	        }
	 }
}

