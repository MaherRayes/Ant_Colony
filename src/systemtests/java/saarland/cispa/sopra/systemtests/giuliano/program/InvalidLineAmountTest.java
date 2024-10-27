package saarland.cispa.sopra.systemtests.giuliano.program;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

import java.util.ArrayList;

public class InvalidLineAmountTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        ArrayList<String> code = new ArrayList<>();
        for(int i = 1; i <= 2501; i++) {
            code.add("jump 0");
        }
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(0,0,buildSimpleMap(),generateBrain(code),getEmptyBrain()));
    }
}
