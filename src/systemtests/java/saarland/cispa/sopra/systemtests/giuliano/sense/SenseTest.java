package saarland.cispa.sopra.systemtests.giuliano.sense;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.FieldInfo;

public abstract class SenseTest extends BaseTest {

    public void checkSense(AntInfo ant, boolean expected, String error) {
        boolean sensed = ant.getPc() != 0;
        if(sensed != expected) {
            fail(String.format("Object sensed: %b but should be viceversa. error: %s", sensed, error));
        }
    }

    public void checkSense(FieldInfo field, boolean expected, String error) {
        field.getAnt().ifPresentOrElse(ant -> checkSense(ant, expected, error), () -> fail("Invalid sense test."));
    }

    public char[] getSensableObjects() {
        return new char[]{'A', 'B', '7', '#', 'A', 'B'};
    }

    public String[] getSensableKeywords() {
        return new String[]{"friend", "foe", "food", "rock", "home", "foehome"};
    }
}
