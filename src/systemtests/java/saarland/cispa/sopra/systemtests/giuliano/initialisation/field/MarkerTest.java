package saarland.cispa.sopra.systemtests.giuliano.initialisation.field;

import saarland.cispa.sopra.systemtests.WorldInfo;

public class MarkerTest extends BaseFieldTest {

    @Override
    public void checkField(WorldInfo world, int x, int y, char expectedType) {
        for(boolean[] bools : world.getFieldAt(x, y).getMarkers().values()) {
            for(boolean bool : bools) {
                if(bool) {
                    fail("Initially all markers have to be unset.");
                }
            }
        }
    }
}
