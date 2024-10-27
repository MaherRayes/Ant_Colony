package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MoveIntoAntTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            ".A\n" +
	            "B.";
	        String brainA = "brain \"sample\" {\nmove else 1\njump 0\n}";
	        String brainB = "brain \"sample\" {\nturn right\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(1, 42, map, brainA, brainB);

	        if(world.getAnt(0).getField().getX()!=1) {
	        	if(world.getAnt(0).getField().getY()!=0) {
	        		fail("Ant 0 moved even though ant 1 is in the way!");
	        	}
	        }
	}

}
