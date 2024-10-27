package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class KommentarTest extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test, ob Kommentare funktionieren
		String map = getCheapMap();
		String brain1 =
				"brain \"kommentator\"{\n"
				+ "sense ahead foe else 2\n"
				+ "//Buy new silent mouse, it's cool!\n"
				+ "jump 1\n"
				+ "jump 2\n"
				+ "}";
		WorldInfo world = gameInfo.simulate(1, 342432, map, brain1, getUselessBrain());
		AntInfo ant = world.getAnt(0);
		assertTrue ("OneLine Kommentarfehler", ant.getPc() == 1);

		brain1 =
				"brain \"langKommentator\"{\n"
				+ "jump 1\n"
				+ "/*jump 10\n"
				+ "jump -1\n*/"
				+ "jump 2\n"
				+ "jump 1\n"
				+ "}";
		world = gameInfo.simulate(1, 13232, map, brain1, getUselessBrain());
		ant = world.getAnt(0);
		assertTrue ("Langes Kommentar funktioniert nicht", ant.getPc() == 1);

		//Test, ob unabgeschlossenes Kommentar Fehler wirft
		String brain2 =
				"brain \"Unfertiges Kommentar\"{\n"
				+ "jump 1\n"
				+ "jump 0\n"
				+ "/*fabian riecht heute gut\n"
				+ "}";
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(12, 124131, map, brain2, getUselessBrain()));
	}

}
