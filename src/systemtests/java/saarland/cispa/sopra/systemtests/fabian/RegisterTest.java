package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class RegisterTest extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test: Sind die Register richtig gemacht
		String map = getCheapMap();
		String brain = //Ist Register 0, 3 und 5 false
				"brain \"eins\"{\n"
				+ "test 0 else 2\n"
				+ "jump 5\n"
				+ "test 3 else 4\n"
				+ "jump 5\n"
				+ "test 5 else 6\n"
				+ "jump 5\n"
				+ "jump 6\n"
				+ "}";
		WorldInfo world = gameInfo.simulate(100, 42, map, brain, getUselessBrain());
		AntInfo ant = world.getAnt(0);
		assertTrue("Register war falsch initialisiert", ant.getPc() == 6);
		final String brain1 =
				"brain \"RegisterFalsch1\"{\n"
				+ "test -1 else 0\n"
				+ "}";
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(10, 32, map, brain1, getUselessBrain()));

		final String brain2 = //Register 6 gibt es nicht
				"brain \"RegisterFalsch1\"{\n"
				+ "test 6 else 0\n"
				+ "}";
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(10, 32, map, brain2, getUselessBrain()));
	}

}
