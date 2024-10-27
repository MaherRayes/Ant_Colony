package saarland.cispa.sopra.systemtests.giuliano.backslash;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.BaseTest;

public class BackslashRWSNTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        String map = "2\r \n2\nAA\nBB";
        String brain = trivialBrain();
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 1, map, brain, brain));
    }
}
