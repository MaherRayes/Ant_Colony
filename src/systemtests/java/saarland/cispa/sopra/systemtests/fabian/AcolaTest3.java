package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AcolaTest3 extends BaseTest {

	private final static int rounds = 10000;
	@Override
	protected void test(GameInfo gameInfo) {
		//Testet Wahrscheinlichkeiten
		String map = getCheapMap();
		String brain = getUselessBrain();
		String brain1 =
				"brain \"Flippie\"{\n"
				+ "flip 10 else 2\n"
				+ "jump 1\n"	//10%
				+ "jump 2\n"	//90%
				+ "}";
		int count1 = 0;
		WorldInfo world;
		AntInfo ant;
		for (int i = 0; i < rounds; i++) {
			world = gameInfo.simulate(3, i, map, brain1, brain);
			ant = world.getAnt(0);
			if (ant.getPc() == 1) {
				count1++;
			}
		}
		int untergrenze = (int) (rounds*0.09);
		int obergrenze = (int) (rounds*0.101);
		int expected = (int) (0.1*rounds);
		assertTrue(String.format("Zufallsverteilung stimmt nicht. Erwartet %d/%d +-0.1*, war %d/%d", expected, rounds, count1, rounds),
				untergrenze <= count1 &&  count1 <= obergrenze);

		//Test, ob flip 0 wie flip 1 geht
		String brain2 =
				"brain \"NullFlipper\"{\n"
						+ "flip 0 else 2\n"
						+ "jump 1\n"
						+ "jump 2\n"
						+ "}";

		String brain3 =
				"brain \"EinsFlipper\"{\n"
						+ "flip 2 else 2\n"
						+ "jump 1\n"	//50%
						+ "jump 2\n"	//50%
						+ "}";
		AntInfo ant1;
		AntInfo ant2;
		int count1Ant1 = 0;
		int count1Ant2 = 0;
		for (int i = 0; i < rounds; i++) {
			world = gameInfo.simulate(3, i, map, brain2, brain3);
			ant1 = world.getAnt(0);
			ant2 = world.getAnt(1);
			if (ant1.getPc() == 1) {
				count1Ant1++;
			}
			if (ant2.getPc() == 1) {
				count1Ant2++;
			}
		}
		int untergrenze50 = (int) (0.45*rounds);
		int obergrenze50 = (int) (0.55*rounds);
		assertTrue(String.format("Flip 0 (ist %d, muss %d sein)", count1Ant1, rounds),
				count1Ant1 == rounds);

		assertTrue(String.format("Flip 2 hat zu hohe Abweichung (%d, erwartet: %d - %d)", count1Ant2,  untergrenze50, obergrenze50),
				untergrenze50 <= count1Ant2 && count1Ant2 <= obergrenze50);
	}

}
