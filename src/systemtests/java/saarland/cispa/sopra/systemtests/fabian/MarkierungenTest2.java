package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MarkierungenTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test: Geht Markierung 6 und ~(7 und -1)
		String map =
				"4\n"
				+ "4\n"
				+ "....\n"
				+ "....\n"
				+ ".A..\n"
				+ "...B\n";
		final String brain =
				"brain \"DerFiesseMarkierer\" {\n"
				+ "move else 4\n"
				+ "mark 6\n"
				+ "sense here marker 6 else 4\n"
				+ "jump 3\n"	//korrekt
				+ "jump 4\n"	//Nicht korrekt
				+ "}";
		WorldInfo world = gameInfo.simulate(100, 42, map, brain, getUselessBrain());
		AntInfo ant = world.getAnt(0);
		assertTrue ("Mark 6 funktioniert nicht", ant.getPc() == 3);
		final String wrongBrain =
				"brain \"DerNochFiessereMarkierer\" {\n"
				+ "move else 4\n"
				+ "mark 7"
				+ "sense here marker 6 else 4"
				+ "jump 3\n"
				+ "jump 4\n"
				+ "}";

		expect(IllegalArgumentException.class, () -> gameInfo.simulate(20, Integer.MIN_VALUE -1, map, wrongBrain, getUselessBrain()));
		final String otherWrongBrain =
				"brain \"DerNochNochFiessereMarkierer\" {\n"
				+ "move else 4\n"
				+ "mark 7\n"
				+ "sense here marker -1 else 4\n"
				+ "jump 3\n"
				+ "jump 4\n"
				+ "}";
		expect(IllegalArgumentException.class, () -> gameInfo.simulate(20, 1, map, otherWrongBrain, getUselessBrain()));
	}

}
