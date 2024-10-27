package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FutterTest1 extends BaseTest{

	@Override
	protected void test(GameInfo gameInfo) {
		//Test 1: Kann die Ameise genau einmal Futter aufheben

	    String map =
	        "4\n" +
	        "4\n" +
	        ".2..\n" +
	        ".A..\n" +
	        ".B..\n" +
	        "....\n";
	    String brain =
	        "brain \"Essenaufheber\"\n{\n" +
	        "move else 6\n" +
	        "pickup else 4\n" +
	        "pickup else 5\n" +
	        "jump 3\n" +
	        "jump 4\n" +
	        "jump 5\n" +
	        "jump 6\n" +
	        "}";
	    WorldInfo world = gameInfo.simulate(100, 42, map, brain, getUselessBrain());
	    AntInfo ant = world.getAnt(0);
	    assertTrue("Ameise hat nicht das Futter richtig aufgenommen", ant.getPc() == 5);
	    assertTrue("Ameise hat kein Essen aufgenommen", ant.hasFood());
	}

}
