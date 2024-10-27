package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.FieldInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class KampfTest1 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test, ob umzingeln stimmt
		String brain = getUselessBrain();
		String map1 =
				"2\n"
				+ "2\n"
				+ "AB\n"
				+ "BB\n";
		WorldInfo world1 = gameInfo.simulate(10, 45, map1, brain, brain);
		world1.getAnt(0);

		String brainMove = getBrainMove();
		final WorldInfo world2 = gameInfo.simulate(1, 132, map1, brainMove, brain);
		FieldInfo field = world1.getFieldAt(0, 0);
		expect(NoSuchElementException.class, ()-> world2.getAnt(0));

		assertTrue(String.format("Tote Ameise hat %d Futter hinterlassen, anstatt keins", field.getFood()), field.getFood() == 0);
		assertTrue(String.format("Team A hat %d Punkte erhalten, anstatt 3", world2.getScore('A')), world2.getScore('A') == 3);

		//Testet, ob beide sterben
		String map2 =
				"4\n"
				+ "4\n"
				+ "#BB#\n"
				+ "BAB#\n"
				+ "BAB#\n"
				+ "BB##\n";
		WorldInfo world3 = gameInfo.simulate(1, 345, map2, brainMove, brain);
		expect(NoSuchElementException.class, ()-> world3.getAnt(3));
		expect(NoSuchElementException.class, ()-> world3.getAnt(6));

		//Test, ob erst nach move getestet wird
		String brain2 =
				"brain \"chillMoveBrain\"{\n"
				+ "jump 1\n"
				+ "move else 1\n"
				+ "jump 1\n"
				+ "}";
		WorldInfo world4 = gameInfo.simulate(1, 453, map1, brain2, brain2);
		world4.getAnt(0);

		//Test: A muss sterben und B überleben
		String map3 =
				"4\n"
				+ "4\n"
				+ "#AA#\n"
				+ "ABB#\n"
				+ "#AAB\n"
				+ "#BB#\n";
		WorldInfo world5 = gameInfo.simulate(2, 245326, map3, brainMove, brain);
		expect(NoSuchElementException.class, ()-> world5.getAnt(3));
		world5.getAnt(6);

		String map6 =
				"4\n"
				+ "4\n"
				+ ".B..\n"
				+ "BA1.\n"
				+ ".BBB\n"
				+ "....\n";
		String brain6 =
				"brain \"Kill\"{\n"
				+ "sense ahead food else 2\n"
				+ "move else 2\n"
				+ "jump 2\n"
				+ "}";
		WorldInfo world6 = gameInfo.simulate(100, 13, map6, getUselessBrain(), brain6);
		field = world6.getFieldAt(1, 1);
		assertFalse("Tote Ameise lebt", field.getAnt().isPresent());

		String map7 =	//Ameise geht in Tod
				"4\n"
				+ "4\n"
				+ ".BA.\n"
				+ "B.B.\n"
				+ "BBB.\n"
				+ "....";
		String brain7 =
				"brain \"toDeath\"{\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "move else 4\n"
				+ "jump 3\n"
				+ "jump 4\n"
				+ "}";
		WorldInfo world7 = gameInfo.simulate(100, 132, map7, brain7, getUselessBrain());
		expect(NoSuchElementException.class, ()-> world7.getAnt(1));
		field = world7.getFieldAt(1, 1);
		if (field.getFood() != 3) {
			fail(String.format("Foodmenge an Todesort war falsch (%d), anstatt 3)", field.getFood()));
		}



	}

}
