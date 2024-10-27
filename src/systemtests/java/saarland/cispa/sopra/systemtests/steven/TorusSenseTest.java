package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class TorusSenseTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map1 = "2\n2\n" +
	            "AB\n" +
	            "#1";
    	String map2 = "2\n2\n" +
	            "AA\n" +
	            "BB";

	        String brainB = "brain \"sample\" {\nturn right\njump 0\n}";
	        String brainA1 = "brain \"sample\" {\nsense ahead food else 5\nsense right rock else 5\n"
	        				+ "sense left foe else 5\n sense left foehome else 5\n "
	        				+ "jump 6\nturn left\njump 6\n}";
	        String brainA2 = "brain \"sample\" {\nsense ahead foehome else 5\nsense right foehome else 5\n"
    							+ "sense left friend else 5\n sense left home else 5\n "
    							+ "jump 6\nturn left\njump 6\n}";
	        WorldInfo world1 = gameInfo.simulate(20, 42, map1, brainA1, brainB);
	        WorldInfo world2 = gameInfo.simulate(20, 42, map2, brainA2, brainB);

	        if(!"northwest".equals(world1.getAnt(0).getDirection())) {
	        	fail("Cannot sense (ant 0) through map boundary!");
	        }
	        if(!"northwest".equals(world2.getAnt(0).getDirection())) {
	        	fail("Cannot sense (ant 0) through map boundary!");
	        }
    }
}

