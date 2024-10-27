package saarland.cispa.sopra.systemtests.giuliano.map;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;

public class ValidMapTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(128,128).set(0,0,'A').set(1,0,'B');
        try {
            generateByMap(gameInfo, builder.export());
        } catch(IllegalStateException e) {
            fail("Map was invalid but should be valid.");
        }
    }
}
