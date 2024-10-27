package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SenseEnemyMarkerTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            ".A\n" +
	            ".B";
	        String brainB = "brain \"sample\" {\n"
	        			  + "jump 1\njump 2\njump 3\njump 4\njump 5\njump 6\njump 7\n" //0-6
	        			  + "sense ahead marker 0 else 9\nturn left\n"//7-8
	        			  + "sense ahead marker 1 else 11\nturn left\n"//9-10
	        			  + "sense ahead marker 2 else 13\nturn left\n"//11-12
	        			  + "sense ahead marker 3 else 15\nturn left\n"//13-14
	        			  + "sense ahead marker 4 else 17\nturn left\n"//15-16
	        			  + "sense ahead marker 5 else 19\nturn left\n"//17-18
	        			  + "sense ahead marker 6 else 21\nturn left\n"//19-20
	        			  + "\njump 21\n}";
	        String brainA = "brain \"sample\" {\nmark 0\nmark 1\nmark 2\nmark 3\nmark 4\nmark 5\nmark 6\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(21, 42, map, brainA, brainB);
	        if(!"northwest".equals(world.getAnt(0).getDirection())) {
	        	fail("A mark has not been set to true after marking on field 1,0!");
	        }
	 }
}

