package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class NoFoodPickupTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            "AB\n" +
	            "..";
		String brainB = "brain \"samplee\" {\nturn left\njump 0\n}";
	    String brainAPickup = "brain \"sample\" {\npickup else 1\njump 0\n}";
	    WorldInfo worldPickup = gameInfo.simulate(1, 42, map, brainAPickup, brainB);

	    //Pickup Only
	    if(worldPickup.getFieldAt(0, 0).getFood()==-1) {
	    	fail("Ant 0 removed food from field 0,0 even though there was none!");
	    }
	    if(worldPickup.getAnt(0).hasFood()) {
	    	fail("Ant 0 carries food after pickup even though there was none on field 0,0");
	    }
	 }
}

