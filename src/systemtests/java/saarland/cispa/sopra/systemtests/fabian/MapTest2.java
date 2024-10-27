package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class MapTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test 2: Kann die Ameise genau einmal Futter aufheben
        var map =
            "4\n" +
            "4\n" +
            ".2..\n" +
            ".A..\n" +
            ".B..\n" +
            "....\n";
        var brain =
            "brain \"Essenaufheber\"{\n" +
            "move else 3\n" +
            "pickup else 4\n" +
            "pickup else 5\n" +
            "jump 3\n" +
            "jump 4\n" +
            "jump 5\n" +
            "}";
        var world = gameInfo.simulate(100, 42, map, brain, getUselessBrain());
        var fieldMapTest = world.getFieldAt(1, 0).getType();
        assertTrue("Essensfeld war kein Punkt", fieldMapTest == '.');
        var ant = world.getAnt(0);
        assertTrue("Ameise hat nicht das Futter richtig aufgenommen", ant.getPc() == 5);

        //Test: Erkennt Ameise Stein auf der anderen Seite
        map =
        		"2\n"
        		+ "2\n"
        		+ "A#\n"
        		+ "B.\n";
        brain =
        		"brain \"GegenSteinSpringer\"{\n"
        		+ "turn left\n"
        		+ "sense ahead rock else 3\n"
        		+ "move else 4\n"
        		+ "jump 3\n"	//falsch
        		+ "jump 4\n"	//korrekt
        		+ "}";
        world = gameInfo.simulate(100, 234, map, brain, getUselessBrain());
        ant = world.getAnt(0);
        assertTrue("Ameise hat Stein bei move nicht erkannt", ant.getPc() == 4);
	}

}
