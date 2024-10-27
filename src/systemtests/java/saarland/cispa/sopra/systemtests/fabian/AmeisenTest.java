package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.FieldInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;
import java.util.Optional;

public class AmeisenTest extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test 1: Testet initiale Blickrichtung,ID, Position und Futteranzahl(=0)
		String map =
				"4\n"
				+ "4\n"
				+ "AA..\n"
				+ "BB..\n"
				+ "CC..\n"
				+ "DD..\n";
		String brain = getUselessBrain();
		WorldInfo world = gameInfo.simulate(0, 0, map, brain, brain, brain, brain);
		FieldInfo field;
		Optional<AntInfo> antOpt;
		AntInfo ant = null;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 2; x++) {
				field = world.getFieldAt(x, y);
				antOpt = field.getAnt();
				assertTrue("Ameise wurde nicht gesetzt", antOpt.isPresent());
				ant = antOpt.get();
				assertTrue("ID stimmt nicht", ant.getId() == x + 2*y);
				assertTrue("Blickrichung stimmt nicht", "northwest".equals(ant.getDirection()));
				assertFalse("Ameise hat initial schon Futter", ant.hasFood());
			}
		}
		try {
			ant = world.getFieldAt(0, 0).getAnt().get();
		} catch (NoSuchElementException e) {
			fail("Auf dem Feld (0,0) war keine Ameise");
		}
		if (ant.getSwarm() != 'A') {
			fail("Schwarmzuteilung ist falsch (A)");
		}

		try {
			ant = world.getFieldAt(1, 2).getAnt().get();
		} catch (NoSuchElementException e) {
			fail ("Auf dem Feld (1,2) war keine Ameise");
		}
		if (ant.getSwarm() != 'C') {
			fail("Schwarmzuteilung ist falsch (C)");
		}

		try {
			ant = world.getFieldAt(1, 3).getAnt().get();
		} catch (NoSuchElementException e) {
			fail ("Auf dem Feld (1,3) war keine Ameise");
		}
		if (ant.getSwarm() != 'D') {
			fail("Schwarmzuteilung ist falsch (D)");
		}

		//Test: Mehr Ameisen auf einem Feld
		map =
				"2\n"
				+ "2\n"
				+ "AB\n"
				+ "A#\n";
		String brainA = getBrainMove();
		String brainB = getUselessBrain();
		world = gameInfo.simulate(100, 141, map, brainA, brainB);
		var ant1 = world.getAnt(0);
		var ant2 = world.getAnt(2);
		if (ant1.getField().equals(ant2.getField())) {
			fail("Zwei Ameisen auf gleichem Feld");
		}
		//Typen der Felder nachgucken von map
		var field1 = world.getFieldAt(0, 0).getType();
		var field2 = world.getFieldAt(1, 1).getType();
		var field3 = world.getFieldAt(1, 0).getType();
		if (!(field1 == 'A' && field2 == '#' && field3 == 'B')) {
			fail("Feld hat nicht gestimmt");
		}
	}

}


//Mark sense
//kill
//Jump am ende
