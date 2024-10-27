package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class FutterTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test 2: Kann die Ameise ein Futter aufnehmen und ein Felder weiter vorne wieder ablegen

        var map =
        	"4\n" +
            "4\n" +
            "....\n" +
            "1...\n" +
            ".A..\n" +
            ".B..\n";

        var brain =
        		"brain \"Futtertraeger\"{\n"
        		+ "move else 5\n"
        		+ "pickup else 5\n"
        		+ "move else 5\n"
        		+ "drop else 5\n"
        		+ "jump 4\n"
        		+ "jump 5\n"
        		+ "}";
        var world = gameInfo.simulate(100, 42, map, brain, getUselessBrain());
        var ant = world.getAnt(0);
        assertTrue("Ameise konnte nicht das machen, was sie sollte", ant.getPc() == 4);

        var field = world.getFieldAt(0, 1);
        assertTrue ("Futter wurde nicht entfernt", field.getFood() == 0);

        field = world.getFieldAt(0, 0);
        assertTrue("Futter wurde nicht gesetzt", field.getFood() == 1);
	}

}
