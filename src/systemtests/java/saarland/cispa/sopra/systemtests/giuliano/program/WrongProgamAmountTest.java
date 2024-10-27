package saarland.cispa.sopra.systemtests.giuliano.program;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;

public class WrongProgamAmountTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'A').set(0,1,'B').set(1,0,'C');
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(0,0,builder.export(),getEmptyBrain(),getEmptyBrain()));
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(0,0,builder.export(),getEmptyBrain(),getEmptyBrain(),getEmptyBrain(),getEmptyBrain()));
    }
}
