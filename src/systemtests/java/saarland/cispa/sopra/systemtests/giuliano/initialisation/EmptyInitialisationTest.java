package saarland.cispa.sopra.systemtests.giuliano.initialisation;

import saarland.cispa.sopra.systemtests.WorldInfo;

public class EmptyInitialisationTest extends InitialisationTest {
    @Override
    public void run(WorldInfo world) {
        if(world == null) {
            fail("null");
        }
    }
}
