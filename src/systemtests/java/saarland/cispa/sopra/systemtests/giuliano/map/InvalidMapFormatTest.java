package saarland.cispa.sopra.systemtests.giuliano.map;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;

public class InvalidMapFormatTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder[] builders = new MapBuilder[9];
        builders[0] = new MapBuilder(4, 4).set(1, 0, 'A').set(2, 0, 'B').setShownHeight(6);
        builders[1] = new MapBuilder(4, 4).set(1, 0, 'A').set(2, 0, 'B').setShownWidth(6);
        builders[2] = new MapBuilder(4, 4).set(1, 0, 'A').set(2, 0, 'B').setShownHeight(-1);
        builders[3] = new MapBuilder(4, 4).set(1, 0, 'a').set(2, 0, 'B');
        builders[4] = new MapBuilder(4, 4).set(1, 0, 'A').set(2, 0, 'B').set(1, 1, '0');
        builders[5] = new MapBuilder(4, 4).set(0, 0, 'A').set(1, 0, 'B').set(2, 0, 'A');
        builders[6] = new MapBuilder(4, 4).set(1, 0, 'A');
        builders[7] = new MapBuilder(4, 4).set(1, 0, 'A').set(2, 0, 'Z');
        builders[8] = new MapBuilder(4, 4).set(0, 0, 'A').set(1, 0, 'B').set(2, 0, 'c');

        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[0].export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[1].export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[2].export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[3].export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[4].export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[5].export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[6].export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[7].export()));
        expect(IllegalArgumentException.class, () -> generateByMap(gameInfo, builders[8].export()));
    }
}
