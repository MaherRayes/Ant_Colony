package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MarkierungenTest3 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test: Kann Ameise vom gleichen Team bzw. anderem Team Markierung lesen
		String map =
				"4\n"
				+ "4\n"
				+ "....\n"
				+ "A...\n"
				+ ".A..\n"
				+ ".B..";
		String aBrain =
				"brain \"TheFriendlyMarker\"{\n"
				+ "mark 4\n"
				+ "move else 4\n"
				+ "sense here marker 4 else 4\n"	//Für zweite Ameise fehler
				+ "jump 3\n"
				+ "jump 4\n"
				+ "}";
		String bBrain =
				"brain \"TheNotSoFriendlyReader\"{\n"
				+ "move else 0\n"
				+ "sense here marker 4 else 3\n"
				+ "jump 2\n"	//falsch
				+ "jump 3\n"	//Korrekt
				+ "}";
		WorldInfo world = gameInfo.simulate(100, 42, map, aBrain, bBrain);
		AntInfo ant = world.getAnt(1);
		assertTrue("A-meise konnte Markierung anderer A-meise nicht lesen", ant.getPc() == 3);
		ant = world.getAnt(2);
		assertTrue("Ameise B konnte Spur von Ameise A lesen", ant.getPc() == 3);
	}

}
