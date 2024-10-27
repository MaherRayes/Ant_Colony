package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class MarkierungenTest4 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Kann Ameise rechts lesen
		String map1 =
				"2\n"
				+ "2\n"
				+ "B.\n"
				+ "AA\n";
		String brain1 =
				"brain \"Dufter\"{\n"
				+ "sense ahead foe else 3\n"
				+ "mark 3\n"
				+ "jump 2\n"
				+ "jump 4\n"	//Ab hier ist der Riecher
				+ "sense left marker 3 else 6\n"
				+ "sense left marker 4 else 7\n"
				+ "jump 6\n"
				+ "jump 7\n"
				+ "}";
		var world1 = gameInfo.simulate(100, 1431, map1, brain1, getUselessBrain());
		var ant1 = world1.getAnt(2);
		assertTrue (String.format("Fehler beim duften (pc = %d)", ant1.getPc()), ant1.getPc() == 7);

		String map2 =
				"2\n"
				+ "4\n"
				+ "A.\n"
				+ "A.\n"
				+ "A.\n"
				+ ".B";
		String brain2 =
				"brain \"homeSearcher\"{\n"
				+ "sense ahead home else 2\n"
				+ "jump 1\n"
				+ "jump 2\n"
				+ "}";
		var world2 = gameInfo.simulate(10, -123, map2, brain2, getUselessBrain());
		var ant2 = world2.getAnt(2);
		assertTrue (String.format("Ameise hat nicht sechseckig gerochen (pc = %d)", ant2.getPc()), ant2.getPc() == 2);
	}

}
