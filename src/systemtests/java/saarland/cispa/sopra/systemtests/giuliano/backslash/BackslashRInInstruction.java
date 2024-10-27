package saarland.cispa.sopra.systemtests.giuliano.backslash;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.BaseTest;

public class BackslashRInInstruction extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        String map = "2\n2\nAA\nBB";
        String brain = "brain \"name\" {\njump\r0\njump 0\n}";
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1,1,map,brain,brain));
    }
}
