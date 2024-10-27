package saarland.cispa.sopra.systemtests.fabian;

/*Spielfeld ist min 2x2 und max. 127x127
* torusförmig
*
* */

import saarland.cispa.sopra.systemtests.SystemTest;

public abstract class BaseTest extends SystemTest {
    public String getMap1() {
    	return
            "4\n" +
            "4\n" +
            ".A..\n" +
            "....\n" +
            "....\n" +
            "....\n";
}
    /*Dieses Brain bewegt sich eins nach vorne (NW)*/
    public String getBrainMove() {
        return "brain \"moveNW\"\n{" +
            "move else 2\n" +
            "jump 1\n" + 		//Erfolgreich gemoved
            "jump 2\n" +		//Nicht erfolgreich gemoved
            "}";
    }

    public String getUselessBrain() {
    	return "brain \"OpferAmeise\" {\n"
    			+ "jump 0\n"
    			+ "}";
    }

    public void assertTrue (String s, boolean bool) {
    	if (!bool) {
    		fail(s);
    	}
    }

    public void assertFalse (String s, boolean bool) {
    	if (bool) {
    		fail(s);
    	}
    }

    public String getCheapMap () {
    	return
    			"2\n"
    			+ "2\n"
    			+ "A.\n"
    			+ ".B\n";
    }
}
