package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class MoveOrderTest extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            	 ".A\n"
	            	 +".B";
		String brain = "brain \"sample\" {\nmove else 0\njump 0\n}";
		WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);
		if(world.getAnt(1).getField().getX()!=1 || world.getAnt(1).getField().getY()!=0) {
			fail("Ants are not moving in ID order!");
		}

	}

}
