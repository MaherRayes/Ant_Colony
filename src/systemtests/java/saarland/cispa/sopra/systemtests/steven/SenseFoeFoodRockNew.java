package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SenseFoeFoodRockNew extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            "A#\n" +
	            "1B";
	        String brainB = "brain \"sample\" {\n"
	        			  + "mark 0\n"//0
	        			  + "sense left food else 9\n"//1
	        			  + "sense ahead rock else 9\n"//2
	        			  + "sense right foe else 9\n"//3
	        			  + "sense here friend else 9\n"//4
	        			  + "sense here home else 9\n"//5
	        			  + "sense right foehome else 9\n"//6
	        			  + "sense here marker 0 else 9\n"//7
	        			  + "jump 8\n"				//8
	        			  + "turn left\njump 10\n}"; //9-10
	        String brainA = "brain \"sample\" {\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(21, 42, map, brainA, brainB);
	        if(!"northwest".equals(world.getAnt(0).getDirection())) {
	        	fail("The ant cannot use sense properly! ");
	        }
	 }
}

