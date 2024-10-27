package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodPickupDropBaseTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//TODO
		String map = "2\n2\n" +
	            ".1\n" +
	            "AB";
		String brainA = "brain \"sampleB\" {\nturn left\njump 0\n}";
	    String brainBPickupDrop = "brain \"sampleA\" {\nmove else 0\npickup else 0\nturn left\nturn left\nturn left\nmove else 0\ndrop else 0\njump 7\n}";
	    WorldInfo world = gameInfo.simulate(40, 42, map, brainA, brainBPickupDrop);

	    if(world.getAnt(1).hasFood()) {
	    	fail("Did not remove food from ant 1 after dropping in base");
	    }
	    if(world.getScore('B')!=1) {
	    	fail("Did not count dropped food for swarm B in base as a point");
	    }
	    if(world.getFieldAt(1, 1).getFood()!=0) {
	    	fail("Did not remove the food in base for swarm B after dropping it there");
	    }
	 }
}

