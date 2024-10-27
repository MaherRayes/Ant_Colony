package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FlipTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            "1.\n" +
	            "AB";
		String brainA = "brain \"sampleB\" {\nturn left\njump 0\n}";
	    String brainBPickupDrop = "brain \"sampleA\" {\nflip 3 else 2\nturn left\njump 0\n}";
	    WorldInfo oldWorld = gameInfo.simulate(15, 42, map, brainA, brainBPickupDrop);
	    for(int x=0; x<11; x++) {
	    	WorldInfo newWorld = gameInfo.simulate(15, 42, map, brainA, brainBPickupDrop);
	    	if(!newWorld.getAnt(1).getDirection().equals(oldWorld.getAnt(1).getDirection())) {
	    		fail("It seems that there has been not one consistent seed been used!");
	    	}
	    }
	 }
}

