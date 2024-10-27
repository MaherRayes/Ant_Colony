package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class FutterTest3 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test 3: Kann mehr als ein Futter auf ein Feld gelegt werden
        var brain1 =
        		"brain \"Futtertraeger\"{\n"
        		+ "move else 5\n"
        		+ "pickup else 5\n"
        		+ "move else 5\n"
        		+ "drop else 5\n"
        		+ "jump 4\n"
        		+ "jump 5\n"
        		+ "}";
        var map1 =
            	"4\n" +
                "4\n" +
                "1...\n" +
                "1...\n" +
                ".A..\n" +
                ".B..\n";
        var world1 = gameInfo.simulate(100, 42, map1, brain1, getUselessBrain());
        var field1 = world1.getFieldAt(0, 0);
        assertTrue("Futter wurde nicht erneut gesetzt", field1.getFood() == 2);
        field1 = world1.getFieldAt(0, 1);
        assertTrue("Futter wurde nicht entfernt", field1.getFood() == 0);

        //Kann Futter auf 10 erhöt werden
        var map2 =
        		"2\n"
        		+ "2\n"
        		+ "1B\n"
        		+ "A9\n";
        var brain2 =
        		"brain \"Futterstabler\"{\n"
        		+ "move else 5\n"
        		+ "pickup else 5\n"
        		+ "move else 5\n"
        		+ "drop else 5\n"
        		+ "jump 4\n"	//Kein Fehler
        		+ "jump 5\n"	//Fehler
        		+ "}";
        world1 = gameInfo.simulate(100, 42, map2, brain2, getUselessBrain());
        field1 = world1.getFieldAt(1, 1);
        assertTrue(String.format("Auf Feld(1,1) ist %d Futter, anstatt 10", field1.getFood()), field1.getFood() == 10);

        //Futter aufheben, wo nix is
        var map3 =
        		"2\n"
        		+ "2\n"
        		+ "1B\n"
        		+ "A.\n";
        var brain3 =
        		"brain \"HoffnungslosesAufheben\"{\n"
        		+ "pickup else 2\n"
        		+ "jump 1\n"	//Hat aufgehoben
        		+ "jump 2\n"	//Hat nichts aufgehoben
        		+ "}";
        var world3 = gameInfo.simulate(100, 1241, map3, brain3, getUselessBrain());
        var ant3 = world3.getAnt(1);
        var field3 = world3.getFieldAt(0, 1);
        assertTrue("Ameise hat was aufgehoben oder so gemacht als ob, obwohl da nichts war", !ant3.hasFood() && ant3.getPc() == 2 && field3.getFood() == 0);

        //Futter droppen, obwohl Ameise nichts hat
        var map4 = map3;
        var brain4 =
        		"brain \"Aufgeber\"{\n"
        		+ "drop else 2\n"
        		+ "jump 1\n"
        		+ "jump 2\n"
        		+ "}";
        var world4 = gameInfo.simulate(100, -129, map4, brain4, getUselessBrain());
        var ant4 = world4.getAnt(1);
        var field4 = world4.getFieldAt(0, 1);
        if (!(ant4.getPc() == 2 && field4.getFood() == 0)) {
        	fail("was gedroppt, obwohl es nicht geht");
        }
	}

}
