package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MapTest1 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Test 1: Kann man über die Ränder springen?
        String map =
            "4\n" +
            "4\n" +
            ".A..\n" +
            "....\n" +
            ".B..\n" +
            "....";
        String brain =
        	"brain \"moveNW\"\n{" +
            "move else 2\n" +
            "jump 1\n" +  //Erfolgreich gemoved
            "jump 2\n" +  //Nicht erfolgreich gemoved
            "}";
        WorldInfo world = gameInfo.simulate(10, 42, map, brain, getUselessBrain());
        var field = world.getAnt(0).getField();
        String fehlerausgabe = String.format("Ameise ist zu (%d,%d) anstatt zu (3,0) gegangen.", field.getX(), field.getY());
        assertFalse(fehlerausgabe, field.getX() == 3 && field.getY() == 0);

        //Stimmeen die maxFeld Angaben
        String bigMap= "128\n"
        		+ "128\n";
        String veryBigMap = "129\n"
        		+ "129\n";

        String reihe = "AB"; //+126 Punkte
        for (int p = 0; p < 126; p++) {
        	reihe = reihe.concat(".");
        }
        String reihe2 = reihe.concat("#");
        reihe = reihe.concat("\n");
        reihe2 = reihe2.concat("\n");
        for (int z = 0; z < 128; z++) {
        	bigMap = bigMap.concat(reihe);
        	veryBigMap = veryBigMap.concat(reihe2);
        }
        veryBigMap = veryBigMap.concat(reihe2);
        String veryBigMap2 = veryBigMap;
        gameInfo.simulate(2, 1321, bigMap, brain, brain);
        expect(IllegalArgumentException.class, ()-> gameInfo.simulate(2, 1321, veryBigMap2, brain, brain));
	}

}
