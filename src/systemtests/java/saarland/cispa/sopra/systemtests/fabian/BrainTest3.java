package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class BrainTest3 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = getCheapMap();
		String brain11 = //Brain am Anfang fehlt
				"\"TheKing\"{\n"
				+ "jump 0\n"
				+ "}";
		String brain12 = "";	//leere Zeichenkette
		String brain13 = 		//Leeres brain
				"brain \"UhShit\"{\n"
				+ "}";
		String brain14 =
				"brain \"noJumper\"{\n"
				+ "move else 0\n"
				+ "jump 0\n"
				+ "move else 0\n"
				+ "}";
		String brain15 =
				"brain \"ZeilenumbruchHater\"{\n"
				+ "jump 0"
				+ "}";
		String brain16 =
				"brain \"FalschReihenfolge\"{\n"
				+ "jump 1\n"
				+ "sense foe left else 0\n"
				+ "jump 0\n"
				+ "}";
		String brain17 =
				"brain \"FalschMarker\"{\n"
				+ "jump 0\n"
				+ "sense ahead 0 marker else 0\n"
				+ "jump 0\n"
				+ "}";
		String brain18 =
				"brain \"äöüß\"{\n"
				+ "jump 0\n"
				+ "}";

		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain11, brain11));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain13, brain13));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain15, brain15));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain17, brain17));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain12, brain12));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain14, brain14));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain16, brain16));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain18, brain18));
	}

}
