package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodPickupEnemyBase extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {

		String map = "4\n4\n" +
	            "A...\n" +
	            "1...\n"
	           +".B..\n"
	           +"....";
		String brainA = "brain \"sampleB\" {\nmove else 0\njump 0\n}";
	    String brainBPickupDrop = "brain \"sampleA\" {\nmove else 0\npickup else 0\nmove else 0\ndrop else 0\njump 4\n}";
	    WorldInfo world = gameInfo.simulate(40, 42, map, brainA, brainBPickupDrop);

	    if(world.getAnt(1).hasFood()) {
	    	fail("Did not remove food from ant 1 after dropping in base");
	    }
	    if(world.getScore('A')!=1) {
	    	fail("Did not count dropped food for swarm A by B in base as a point");
	    }
	    if(world.getFieldAt(0, 1).getFood()!=0) {
	    	fail("Did not remove the food in base for swarm B after dropping it there");
	    }
	 }
}

