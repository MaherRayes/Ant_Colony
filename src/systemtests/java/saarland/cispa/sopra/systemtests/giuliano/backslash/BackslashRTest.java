package saarland.cispa.sopra.systemtests.giuliano.backslash;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.BaseTest;

public class BackslashRTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        String map = "2\r2\nAA\nBB";
        String brain = trivialBrain();
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1,1,map,brain,brain));
    }
}
