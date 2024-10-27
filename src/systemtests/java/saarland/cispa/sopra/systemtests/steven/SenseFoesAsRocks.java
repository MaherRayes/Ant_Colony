package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class SenseFoesAsRocks extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		//d has to die following id order
		String map = "4\n4\n" +
	            	 "AA..\n"
	            	+"BC..\n"
	            	+"....\n"
	            	+"....";

		String brain = "brain \"sample\" {\njump 0\n}";
		String brainA = "brain \"sample\" {\nsense left rock else 2\nmark 0\njump 0\n}";
		String brainC = "brain \"sample\" {\nsense ahead rock else 2\nset 0\njump 0\n}";
		WorldInfo world = gameInfo.simulate(45, 42, map, brainA, brain, brainC);
		if(!world.getFieldAt(1, 0).getMarkers().get('A')[0]) {
			fail("Friend has not been sensed as an obstacle!");
		}
		if(!world.getAnt(3).getRegister()[0]) {
			fail("Foe has not been sensed as an obstacle!");
		}
	}

}
