package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class TorusMoveNormal extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map1 = "2\n2\n" + //nach northwest und notheast
	            "AB\n" +
	            "..";
    	String map2 = "2\n2\n" + //nach west
	            "A.\n" +
	            "B.";
    	String map3 = "2\n2\n" + //nach east
	            ".A\n" +
	            ".B";
    	String map4 = "2\n2\n" + //nach southwest und southeast
	            "..\n" +
	            "AB";
	        String brainB = "brain \"sample\" {\nturn right\njump 0\n}";
	        String brainA1 = "brain \"sample\" {\nmove else 1\njump 1\n}"; // rauskommen bei 1,1
	        String brainA2 = "brain \"sample\" {\nturn left\nmove else 2\njump 2\n}"; // rauskommen bei 1,0
	        String brainA3 = "brain \"sample\" {\nturn right\nturn right\nmove else 3\njump 3\n}";// rauskommen bei 0,0
	        String brainA4 = "brain \"sample\" {\nturn left\nturn left\nmove else 2\njump 3\n}";// rauskommen bei 1,0
	        WorldInfo world1 = gameInfo.simulate(20, 42, map1, brainA1, brainB);
	        WorldInfo world2 = gameInfo.simulate(20, 42, map2, brainA2, brainB);
	        WorldInfo world3 = gameInfo.simulate(20, 42, map3, brainA3, brainB);
	        WorldInfo world4 = gameInfo.simulate(20, 42, map4, brainA4, brainB);
	        if(world1.getAnt(0).getField().getX()!=1) {
	        	if(world1.getAnt(0).getField().getY()!=1) {
	        		 fail("Ant 0 is not at 1,1, but at:"+ world1.getAnt(0).getField().toString());
	        	}
	        }
	        if(world2.getAnt(0).getField().getX()!=1) {
	        	if(world2.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 1,0, but at:"+ world2.getAnt(0).getField().toString());
	        	}
	        }
	        if(world3.getAnt(0).getField().getX()!=0) {
	        	if(world3.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 0,0, but at:"+ world3.getAnt(0).getField().toString());
	        	}
	        }
	        if(world4.getAnt(0).getField().getX()!=1) {
	        	if(world4.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 1,0, but at:"+ world4.getAnt(0).getField().toString());
	        	}
	        }
    }
}

