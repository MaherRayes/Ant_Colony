package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class InstruktionenTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test, ob die Zeit der Befehlsausführung stimmt
		String map =
				"2\n"
				+ "2\n"
				+ "..\n"
				+ "AB\n";
		String brain =
				"brain \"Billighirn\"{\n"
				+ "move else 2\n"
				+ "jump 2\n"
				+ "jump 3\n"
				+ "jump 3\n"
				+ "}";
		WorldInfo world = gameInfo.simulate(0, 42, map, brain, getUselessBrain());
		AntInfo ant = world.getAnt(0);
		assertTrue("Ameise hat einen Zug ausgeführt", ant.getPc() == 0);

		world = gameInfo.simulate(1, 42, map, brain, getUselessBrain());
		ant = world.getAnt(0);
		assertTrue(String.format("Ameise hat nicht genau einen Zug ausgeführt. Restzeit = %d(Erwartet: 13)", ant.getRestTime()),
				ant.getPc() == 1 && ant.getRestTime() == 13);

		world = gameInfo.simulate(15, 42, map, brain, getUselessBrain());
		ant = world.getAnt(0);
		assertTrue("Restzeit falsch gemacht", ant.getPc() == 2);

		//Test, ob bei falschem move keine Pause
		map =
				"2\n"
				+ "2\n"
				+ "#.\n"
				+ "AB\n";
		world = gameInfo.simulate(2, 17123, map, brain, getUselessBrain());
		ant = world.getAnt(0);
		assertTrue(String.format("Bei fehlerhaftem move wurde falsche Restzeit gemacht (=%d, anstatt 1)", ant.getRestTime()+1), ant.getPc() == 3);
	}

}
