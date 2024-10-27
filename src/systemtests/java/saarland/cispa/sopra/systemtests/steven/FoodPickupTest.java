package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodPickupTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            ".1\n" +
	            "AB";
		String brainA = "brain \"sampleA\" {\nturn left\njump 0\n}";
	    String brainBPickup = "brain \"sampleB\" {\nmove else 0\npickup else 0\njump 2\n}";
	    WorldInfo worldPickup = gameInfo.simulate(16, 42, map, brainA, brainBPickup);
	    worldPickup.getAnt(0);

	    //Pickup Only
	    if(worldPickup.getFieldAt(0, 0).getFood()!=0) {
	    	fail("Did not remove food from field 0,0 after pickup by ant 0");
	    }
	    if(!worldPickup.getAnt(1).hasFood()) {
	    	fail("Ant 0 does not carry food after pickup");
	    }

	 }
}

