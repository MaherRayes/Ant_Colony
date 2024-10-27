package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;
public class FoodPickupAndDropTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//TODO
		String map = "4\n4\n" +
	            ".9..\n" +
	            ".1..\n"
	            +"..AB\n"
	            +"....";
		String brainB = "brain \"samplee\" {\nturn left\njump 0\n}";
	    String brainAPickup = "brain \"sample\" {\nmove else 0\npickup else 0\njump 2\n}";
	    String brainAPickupDrop = "brain \"sample\" {\nmove else 0\npickup else 0\nmove else 0\ndrop else 0\njump 4\n}";
	    WorldInfo worldPickup = gameInfo.simulate(17, 42, map, brainAPickup, brainB);
	    WorldInfo worldPickupDrop = gameInfo.simulate(31, 42, map, brainAPickupDrop, brainB);

	    //Pickup Only
	    if(worldPickup.getFieldAt(1, 1).getFood()!=0) {
	    	fail("Did not remove food from field 1,1 after pickup by ant 0");
	    }
	    if(!worldPickup.getAnt(0).hasFood()) {
	    	fail("Ant 0 does not carry food after pickup");
	    }
	    //Drop
	    if(worldPickupDrop.getFieldAt(1, 0).getFood()!=10) {
	    	fail("Did not increase food count after ant 0 dropped it in field 3,3");
	    }
	    if(worldPickupDrop.getAnt(0).hasFood()) {
	    	fail("Did not remove food from ant 0 after dropping it");
	    }
	 }
}

