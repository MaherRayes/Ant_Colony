package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AcolaTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test: Kap 1.8.2 + 1.8.3
		String map = getCheapMap();
		String brain = getUselessBrain();
		String brain1 =
				"brain \"DerSetter\"{\n"
				+ "set 2\n"
				+ "test 2 else 4\n"
				+ "unset 2\n"
				+ "test 2 else 5\n"
				+ "jump 4\n"	//Fehler
				+ "jump 5\n"	//Erfolg
				+ "}";
		WorldInfo world = gameInfo.simulate(100, 41, map, brain1, brain);
		AntInfo ant = world.getAnt(0);
		assertTrue("Ameise hat einen Set/Unset Fehler", ant.getPc() == 5);

		map =
				"4\n"
				+ "4\n"
				+ "....\n"
				+ "..A.\n"
				+ "....\n"
				+ "..B.\n";
		String brain2 =
				"brain \"RightTurner\"{\n"
				+ "turn right\n"
				+ "move else 2\n"
				+ "jump 2\n"
				+ "}";
		world = gameInfo.simulate(100, 867, map, brain2, brain);
		ant = world.getAnt(0);
		String dir = ant.getDirection();
		assertTrue(String.format("Ameise hat sich nicht gedreht. Sie guckt nach %s, anstatt nacht northeast", dir), "northeast".equals(dir));

		//funktioniert sense ahead mit friend Ameise
		map =
				"2\n"
				+ "2\n"
				+ "AB\n"
				+ "A.\n";
		String brain3 =
				"brain \"Ameisenriecher\"{\n"
				+ "sense ahead friend else 2\n"
				+ "jump 1\n"
				+ "jump 2\n"
				+ "}";
		world = gameInfo.simulate(100, 132, map, brain3, brain);
		ant = world.getAnt(2);
		assertTrue("Ameise hat andere Ameise nicht gerochen", ant.getPc() == 1);

		//Sense right foehome
		String brain4 =
				"brain \"foeFinder\"{\n"
				+ "sense right foehome else 2\n"
				+ "jump 1\n"
				+ "jump 2\n"
				+ "}";
		world = gameInfo.simulate(100, 67, map, brain4, brain);
		ant = world.getAnt(2);
		assertTrue("Ameise hat Gegnerbasis nicht gerochen", ant.getPc() == 1);
	}

}
