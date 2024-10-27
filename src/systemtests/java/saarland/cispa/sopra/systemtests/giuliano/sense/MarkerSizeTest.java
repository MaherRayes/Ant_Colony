package saarland.cispa.sopra.systemtests.giuliano.sense;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.FieldInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MarkerSizeTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        WorldInfo w = gameInfo.simulate(0,0,buildSimpleMap(),getEmptyBrain(),getEmptyBrain());
        FieldInfo f = w.getFieldAt(1,1);
        if(f.getMarkers().size() > 2) {
            fail("There were more marker keys than swarms.");
        }
        for(boolean[] b : f.getMarkers().values()) {
            if(b.length != 7) {
                fail(String.format("Swarm had %d markers per field but should have 7.", b.length));
            }
        }
    }
}
