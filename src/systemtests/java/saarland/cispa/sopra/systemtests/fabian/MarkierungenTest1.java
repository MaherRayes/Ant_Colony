package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MarkierungenTest1 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test: Können Markierungen gesetzt und gelesen werden und sind sie initial auf false?
		String map =
				"4\n"
				+ "4\n"
				+ "....\n"
				+ ".AB.\n"
				+ "....\n"
				+ "....\n";
		String brain = "brain \"DerMarkierer\"{\n"
				+ "move else 4\n"
				+ "mark 0\n"
				+ "sense here marker 0 else 4\n"
				+ "sense here marker 1 else 5\n"
				+ "jump 4\n"	//nicht erfolgreich
				+ "jump 5\n"	//Erfolgreich
				+ "}";
		WorldInfo world = gameInfo.simulate(100, 42, map, brain, getUselessBrain());
		AntInfo ant = world.getAnt(0);
		assertTrue("Markierung wurde nicht gesetzt oder Mark 1 war grundlos gesetzt", ant.getPc() == 5);
	}

}
