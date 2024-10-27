package saarland.cispa.sopra.systemtests.giuliano.food;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class ScoreInvalidSwarmTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        WorldInfo w = gameInfo.simulate(0,0,buildSimpleMap(),getEmptyBrain(),getEmptyBrain());
        expect(IllegalArgumentException.class, () -> w.getScore('C'));
    }
}
