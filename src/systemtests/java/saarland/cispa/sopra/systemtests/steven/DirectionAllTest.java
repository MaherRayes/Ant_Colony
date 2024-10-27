package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DirectionAllTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
					 "..\n" +
	            	 "AB";
		String brainANorthwest = "brain \"sampleB\" {\ndirection northwest else 2\nset 0\njump 2\n}";
		String brainAWest = "brain \"sampleB\" {\nturn left\ndirection west else 3\nset 0\njump 3\n}";
		String brainASouthwest = "brain \"sampleB\" {\nturn left\nturn left\ndirection southwest else 4\nset 0\njump 4\n}";
		String brainASoutheast = "brain \"sampleB\" {\nturn left\nturn left\nturn left\ndirection southeast else 5\nset 0\njump 5\n}";
		String brainAEast = "brain \"sampleB\" {\nturn left\nturn left\nturn left\nturn left\ndirection east else 6\nset 0\njump 6\n}";
		String brainANortheast = "brain \"sampleB\" {\nturn left\nturn left\nturn left\nturn left\nturn left\ndirection northeast else 7\nset 0\njump 7\n}";
	    String brainB = "brain \"sampleB\" {\nturn left\njump 0\n}";
	    WorldInfo worldNorthwest = gameInfo.simulate(15, 42, map, brainANorthwest, brainB);
	    WorldInfo worldWest = gameInfo.simulate(15, 42, map, brainAWest, brainB);
	    WorldInfo worldSouthwest = gameInfo.simulate(15, 42, map, brainASouthwest, brainB);
	    WorldInfo worldSoutheast = gameInfo.simulate(15, 42, map, brainASoutheast, brainB);
	    WorldInfo worldEast = gameInfo.simulate(15, 42, map, brainAEast, brainB);
	    WorldInfo worldNortheast = gameInfo.simulate(15, 42, map, brainANortheast, brainB);

	    if(!worldNorthwest.getAnt(0).getRegister()[0]) {
	    	fail("Direction did not work even though ant 0 was in the expected direction!");
	    }
	    if(!worldWest.getAnt(0).getRegister()[0]) {
	    	fail("Direction did not work even though ant 0 was in the expected direction!");
	    }
	    if(!worldSouthwest.getAnt(0).getRegister()[0]) {
	    	fail("Direction did not work even though ant 0 was in the expected direction!");
	    }
	    if(!worldSoutheast.getAnt(0).getRegister()[0]) {
	    	fail("Direction did not work even though ant 0 was in the expected direction!");
	    }
	    if(!worldEast.getAnt(0).getRegister()[0]) {
	    	fail("Direction did not work even though ant 0 was in the expected direction!");
	    }
	    if(!worldNortheast.getAnt(0).getRegister()[0]) {
	    	fail("Direction did not work even though ant 0 was in the expected direction!");
	    }

	 }
}

