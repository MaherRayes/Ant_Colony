package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class InstruktionenTest1 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test: Kann Brain nur max 2500 Instruktionen haben
		String brain =
				"brain \"Ultrabrain\"{\n";
		for (int x = 0; x < 2499; x++) {
			brain = brain.concat(String.format("jump %d%n", x+1));
		}

		brain = brain.concat("jump 2499\n");
		final String brain1 = brain.concat("}");
		gameInfo.simulate(3000, 42, getCheapMap(), brain1, getUselessBrain());
		brain = "brain \"Hyperbrain\"{\n";
		for (int x = 0; x < 2501; x++) {
			brain = brain.concat(String.format("jump %d%n", x));
		}

		final String brain2 = brain.concat("}");
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(3000, 42, getCheapMap(), brain2, getUselessBrain()));
	}

}
