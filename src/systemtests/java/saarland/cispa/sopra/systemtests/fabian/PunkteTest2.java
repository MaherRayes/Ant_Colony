package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class PunkteTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Kann Team zwei Punkte erhalten
		String map =
				"4\n"
				+ "4\n"
				+ "....\n"
				+ "2.2.\n"
				+ ".A.B\n"
				+ "....\n";
		String brain =
				"brain \"TakeFood\"{\n"
				+ "move else 16\n"
				+ "pickup else 16\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "move else 16\n"
				+ "drop else 16\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "move else 16\n"
				+ "pickup else 16\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "jump 15\n"
				+ "jump 16\n"	//Falsch
				+ "}";
		var world = gameInfo.simulate(300, 143, map, brain, brain);
		var ant1 = world.getAnt(0);
		var ant2 = world.getAnt(1);
		assertTrue(String.format("Ant1-pc = %d, sollte 15, Ant2-pc = %d, sollte 15", ant1.getPc(), ant2.getPc()), ant1.getPc() == 15 && ant2.getPc() == 15);

	}

}
