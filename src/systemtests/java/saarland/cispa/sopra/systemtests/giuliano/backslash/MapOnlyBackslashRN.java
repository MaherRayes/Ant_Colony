package saarland.cispa.sopra.systemtests.giuliano.backslash;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.BaseTest;

public class MapOnlyBackslashRN extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        String map = "2\r\n2\r\nAA\r\nBB";
        String brain = trivialBrain();
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1,1,map,brain,brain));
    }
}
