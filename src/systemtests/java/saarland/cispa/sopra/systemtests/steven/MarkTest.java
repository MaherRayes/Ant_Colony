package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MarkTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            ".A\n" +
	            "B.";
	        String brainA = "brain \"sample\" {\njump 2\nturn left\n"
	        			  + "mark 0\nmark 1\nmark 2\nmark 3\nmark 4\nmark 5\nmark 6\n"
	        			  + "sense here marker 0 else 1\n"
	        			  + "sense here marker 1 else 1\n"
	        			  + "sense here marker 2 else 1\n"
	        			  + "sense here marker 3 else 1\n"
	        			  + "sense here marker 4 else 1\n"
	        			  + "sense here marker 5 else 1\n"
	        			  + "sense here marker 6 else 1\n"
	        			  + "\njump 16\n}";
	        String brainB = "brain \"sample\" {\nturn right\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(20, 42, map, brainA, brainB);
	        if(!"northwest".equals(world.getAnt(0).getDirection())) {
	        	fail("A mark has not been set to true after marking on field 1,0!");
	        }
	        for(Boolean b : world.getFieldAt(1, 0).getMarkers().get('A')) {
	        	if(!b) {
	        		fail("A marker from ant 0 has not been properly set!");
	        	}
	        }
	 }
}

