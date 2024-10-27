package saarland.cispa.sopra.systemtests.giuliano.map;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;

public class InvalidMapSizeTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder1 = new MapBuilder(3,3).set(0,0,'A').set(1,0,'B');
        MapBuilder builder2 = new MapBuilder(0,0);
        MapBuilder builder3 = new MapBuilder(128,129).set(0,0,'A').set(1,0,'B');
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo,builder1.export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo,builder2.export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo,builder3.export()));
    }
}
