package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DoubleDropAfterPickupTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            ".1\n" +
	            "AB";
		String brainB = "brain \"samplee\" {\nmove else 0\npickup else 1\ndrop else 0\ndrop else 0\njump 0\n}";
	    String brainA = "brain \"sample\" {\nturn left\njump 0\n}";
	    WorldInfo world = gameInfo.simulate(17, 42, map, brainA, brainB);

	    if(world.getFieldAt(1, 0).getFood()!=1) {
	    	fail("Was able to drop food twice after pickup!");
	    }
	 }
}

