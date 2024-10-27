package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class TorusMoveIntoAnt extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map = "2\n2\n" + //nach oben
	            "AB\n" +
	            "CD";
	        String brainR = "brain \"sample\" {\nturn right\njump 0\n}";
	        String brainA = "brain \"sample\" {\nturn right\njump 0\n}";
	        String brainA1 = "brain \"sample\" {\nturn right\nmove else 2\njump 2\n}";
	        String brainA2 = "brain \"sample\" {\nturn left\nmove else 2\njump 2\n}";

	        String brainB3 = "brain \"sample\" {\nturn right\nturn right\nmove else 3\njump 3\n}";
	        String brainC4 = "brain \"sample\" {\nturn left\nturn left\nmove else 2\njump 2\n}";
	        WorldInfo worldA = gameInfo.simulate(20, 42, map, brainA1, brainR ,brainR ,brainR);
	        WorldInfo worldB = gameInfo.simulate(20, 42, map, brainA2, brainR ,brainR ,brainR);

	        WorldInfo worldC = gameInfo.simulate(20, 42, map, brainA , brainB3,brainR ,brainR);
	        WorldInfo worldD = gameInfo.simulate(20, 42, map, brainA , brainR ,brainC4,brainR);
	        if(worldA.getAnt(0).getField().getX()!=0) {
	        	if(worldA.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 0,0, but at:"+ worldB.getAnt(0).getField().toString());
	        	}
	        }
	        if(worldB.getAnt(0).getField().getX()!=0) {
	        	if(worldB.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 0,0, but at:"+ worldB.getAnt(0).getField().toString());
	        	}
	        }

	        if(worldC.getAnt(1).getField().getX()!=1) {
	        	if(worldC.getAnt(1).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 1,0, but at:"+ worldC.getAnt(1).getField().toString());
	        	}
	        }
	        if(worldD.getAnt(2).getField().getX()!=0) {
	        	if(worldD.getAnt(2).getField().getY()!=1) {
	        		 fail("Ant 0 is not at 0,1, but at:"+ worldD.getAnt(2).getField().toString());
	        	}
	        }
    }
}

