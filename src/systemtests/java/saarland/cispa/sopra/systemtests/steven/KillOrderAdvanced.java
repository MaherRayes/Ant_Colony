package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class KillOrderAdvanced extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		//d has to die following id order
		String map = "4\n4\n" +
	            	 "ABCD\n"
	            	+"E.F.\n"
	            	+"GH..\n"
	            	+"....";
		String brainD = "brain \"sample\" {\n"
				+ "move else 0\n"
				+ "move else 0\n"
				+ "move else 0\n"
				+ "jump 3\n}"; //43
		String brain = "brain \"sample\" {\njump 0\n}";
		WorldInfo world = gameInfo.simulate(45, 42, map, brain, brain, brain, brainD, brain, brain, brain, brain);
		world.getAnts();

		expect(NoSuchElementException.class, () ->world.getAnt(3));
		if(world.getAnts().size()!=7) {
			fail("Ant list has not been adjusted to an ant death!");
		}
		if(world.getFieldAt(1, 1).getAnt().isPresent()) {
			fail("Ant has not been removed from the map!");
		}
	}

}
