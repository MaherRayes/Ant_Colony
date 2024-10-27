package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class AcolaTest1 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test, ob falsche Braineingaben abgefangen werden (Kap 1.8.1)
		String map = getCheapMap();
		String brain = getUselessBrain();
		String brain1 = 	//brain vergessen
				"\"IrgendwieKeinBrain\"{\n"
				+ "jump 0\n"
				+ "}";
		String brain2 = 	//Name vergessen
				"brain {\n"
				+ "jump 0\n"
				+ "}";
		String brain3 =		//Anführungsstriche vergessen
				"brain freierName {\n"
				+ "jump 1\n"
				+ "jump 0\n"
				+ "}";
		String brain4 =		//Schlüsselwort als Name
				"brain \"brain\"{\n"
				+ "jump 2\n"
				+ "jump 0\n"
				+ "jump 1\n"
				+ "}";
		String brain5 =		//Zeilenumbruch vergessen
				"brain \"Zeilenarm\"{\n"
				+ "jump 1\n"
				+ "jump 0"
				+ "}";
		String brain6 =		//ungültige Sprungadresse
				"brain \"Overjump\"{\n"
				+ "jump 1\n"
				+ "}";

		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain1, brain));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 90, map, brain2, brain));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 402, map, brain3, brain));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, -9, map, brain4, brain));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 18, map, brain5, brain));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 1717, map, brain6, brain));
	}

}
