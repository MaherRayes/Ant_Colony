package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class FightSurrounded4E1F extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		//d has to die following id order
		String map = "4\n4\n" +
	            	 ".AA.\n"
	            	+"BBC.\n"
	            	+"..D.\n"
	            	+"....";

		String brain = "brain \"sample\" {\njump 0\n}";
		String brainC = "brain \"sample\" {\nmove else 0\njump 0\n}";
		WorldInfo world = gameInfo.simulate(45, 42, map, brain, brain, brainC, brain);
		try {
			world.getAnt(3);
		}catch(NoSuchElementException e) {
			fail("Ant 3 died even though it was surrounded by 4 enemies and 1 friendly unit");
		}
	}

}
