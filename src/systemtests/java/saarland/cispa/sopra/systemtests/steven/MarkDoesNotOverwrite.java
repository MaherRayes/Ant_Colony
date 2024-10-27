package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MarkDoesNotOverwrite extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            "A.\n" +
	            ".B";
	        String brainB = "brain \"sample\" {\nturn left\njump 0\n}";
	        String brainA = "brain \"sample\" {\nmark 0\nmark 1\nmark 2\nmark 3\nmark 4\nmark 5\nmark 6\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(8, 42, map, brainA, brainB);
	        for(Boolean b : world.getAnt(0).getField().getMarkers().get('B')) {
	        	if(b) {
	        		fail("Mark from ant 0 overwrote the marker from ant 1!");
	        	}
	        }
	 }
}

