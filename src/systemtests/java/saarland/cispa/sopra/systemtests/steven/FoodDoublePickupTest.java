package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodDoublePickupTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            ".2\n" +
	            "AB";
		String brainA = "brain \"sampleA\" {\nturn left\njump 0\n}";
	    String brainBPickup = "brain \"sampleB\" {\nmove else 0\npickup else 0\npickup else 3\njump 2\n}";
	    WorldInfo worldPickup = gameInfo.simulate(18, 42, map, brainA, brainBPickup);
	    worldPickup.getAnt(0);

	    //Pickup Only
	    if(worldPickup.getFieldAt(1, 0).getFood()!=1) {
	    	fail("Did not remove food from field 0,0 after pickup by ant 0 or too much was removed!");
	    }
	    if(!worldPickup.getAnt(1).hasFood()) {
	    	fail("Ant 0 does not carry food after pickup");
	    }

	 }
}

