package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class PunkteTest1 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map1 = getCheapMap();
		String brain = getUselessBrain();
		WorldInfo world = gameInfo.simulate(3, 89, map1, brain, brain);
		assertTrue(String.format("Initiale Punktestand ist falsch(A:%d, B:%d)",world.getScore('A'), world.getScore('B')),
				world.getScore('A') == 0 && world.getScore('B') == 0);

		//Test: Normale Futterabgabe
		String map2 =
				"4\n"
				+ "4\n"
				+ "AA##\n"
				+ "1A##\n"
				+ "AA##\n"
				+ "B##.\n";
		String brainA = //Wenn vorne Futter ist geh nach vorne und nimm es und sonst geh einfach nach vorne
				"brain \"takePoints\"{\n"
				+ "sense ahead food else 6\n"
				+ "move else 8\n"
				+ "pickup else 8\n"
				+ "move else 8\n"
				+ "drop else 8\n"
				+ "jump 5\n"	//Erste Ameise (Id=1) ist ab hier fertig
				+ "move else 8\n"
				+ "jump 7\n"
				+ "jump 8\n"	//Error für Ameise id=0
				+ "}";
		world = gameInfo.simulate(200, 234, map2, brainA, brain);
		assertTrue(String.format("Fehler! (ant0.pc = %d, ant4.pc = %d)", world.getAnt(0).getPc(), world.getAnt(4).getPc()),
				world.getAnt(0).getPc() == 7 && world.getAnt(4).getPc() == 5);

		assertTrue(String.format("Obwohl A genau einen Punkt gemacht hat, hat A %d Punkte", world.getScore('A')), world.getScore('A') == 1);

		//Test: A gibt B Futter
		String map3 =
				"2\n"
				+ "4\n"
				+ "..\n"
				+ "A.\n"
				+ ".1\n"
				+ ".B\n";
		brainA = getBrainMove();
		String brainB =
				"brain \"Verraeter\"{\n"
				+ "move else 5\n"
				+ "pickup else 5\n"
				+ "move else 5\n"
				+ "drop else 5\n"
				+ "jump 4\n"	//Korrekt
				+ "jump 5\n"	//Fehler
				+ "}";
		world = gameInfo.simulate(100, 14323, map3, brainA, brainB);
		AntInfo ant = world.getAnt(1);
		assertTrue(String.format("Ameise B konnte nicht verräterisch handeln(PC = %d, Punkte A = %d, Punkte B = %d)",
				ant.getPc(), world.getScore('A'), world.getScore('B')),
				ant.getPc() == 4 && world.getScore('A') == 1 && world.getScore('B') == 0);

		//B und A können punkten
		String map4 =
				"4\n"
				+ "4\n"
				+ "....\n"
				+ "2.2.\n"
				+ ".A.B\n"
				+ "....\n";
		String brain4 =
				"brain \"TakeFood\"{\n"
				+ "move else 8\n"
				+ "pickup else 8\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "turn left\n"
				+ "move else 8\n"
				+ "drop else 8\n"
				+ "jump 7\n"	//Korrekt
				+ "jump 8\n"	//Falsch
				+ "}";
		var world4 = gameInfo.simulate(200, 1231, map4, brain4, brain4);
		var ant41 = world4.getAnt(0);
		var ant42 = world4.getAnt(1);
		if (ant41.getPc() != 7 || ant42.getPc() != 7) {
			fail(String.format("Pc: erwartet: 8/8, war %d/%d", ant41.getPc(), ant42.getPc()));
		}
		if (world4.getScore('A') != 1 || world4.getScore('B') != 1) {
			fail(String.format("Erwartet 1/1, war %d/%d", world4.getScore('A'), world4.getScore('B')));
		}
	}





}
