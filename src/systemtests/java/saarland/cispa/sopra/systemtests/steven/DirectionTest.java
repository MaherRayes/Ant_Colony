package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DirectionTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            "..\n" +
	            "AB";
		String brainA = "brain \"sampleB\" {\ndirection northwest else 2\nturn left\njump 2\n}";
	    String brainB = "brain \"sampleB\" {\nturn left\njump 0\n}";
	    WorldInfo world = gameInfo.simulate(15, 42, map, brainA, brainB);
	    if(!"west".equals(world.getAnt(0).getDirection())) {
	    	fail("The ant could not use direction properly!");
	    }
	 }
}

