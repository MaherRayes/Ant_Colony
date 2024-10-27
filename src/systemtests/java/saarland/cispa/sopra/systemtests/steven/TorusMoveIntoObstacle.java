package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class TorusMoveIntoObstacle extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map1 = "2\n2\n" + //nach oben
	            "AB\n" +
	            "##";
    	String map2 = "2\n2\n" + //nach links
	            "A#\n" +
	            "B#";
    	String map3 = "2\n2\n" + //nach rechts
	            "#A\n" +
	            "#B";
    	String map4 = "2\n2\n" + //nach unten
	            "##\n" +
	            "AB";
	        String brainB = "brain \"sample\" {\nturn right\njump 0\n}";
	        String brainA1 = "brain \"sample\" {\nturn right\nmove else 2\njump 2\n}";
	        String brainA2 = "brain \"sample\" {\nturn left\nmove else 2\njump 2\n}";
	        String brainA3 = "brain \"sample\" {\nturn right\nturn right\nmove else 3\njump 3\n}";
	        String brainA4 = "brain \"sample\" {\nturn left\nturn left\nmove else 2\njump 2\n}";
	        WorldInfo worldO1 = gameInfo.simulate(20, 42, map1, brainA1, brainB);
	        WorldInfo worldO2 = gameInfo.simulate(20, 42, map2, brainA2, brainB);
	        WorldInfo worldO3 = gameInfo.simulate(20, 42, map3, brainA3, brainB);
	        WorldInfo worldO4 = gameInfo.simulate(20, 42, map4, brainA4, brainB);
	        if(worldO1.getAnt(0).getField().getX()!=0) {
	        	if(worldO1.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 0,0, but at:"+ worldO1.getAnt(0).getField().toString());
	        	}
	        }
	        if(worldO2.getAnt(0).getField().getX()!=0) {
	        	if(worldO2.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 0,0, but at:"+ worldO2.getAnt(0).getField().toString());
	        	}
	        }
	        if(worldO3.getAnt(0).getField().getX()!=1) {
	        	if(worldO3.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 1,0, but at:"+ worldO3.getAnt(0).getField().toString());
	        	}
	        }
	        if(worldO4.getAnt(0).getField().getX()!=0) {
	        	if(worldO4.getAnt(0).getField().getY()!=1) {
	        		 fail("Ant 0 is not at 0,1, but at:"+ worldO4.getAnt(0).getField().toString());
	        	}
	        }
    }
}

