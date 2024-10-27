package saarland.cispa.sopra.systemtests.giuliano.program;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

import java.util.ArrayList;

public class ValidLineAmountTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        ArrayList<String> code = new ArrayList<>();
        for(int i = 1; i <= 2500; i++) {
            code.add("jump 0");
        }
        try {
            gameInfo.simulate(0, 0, buildSimpleMap(), generateBrain(code), getEmptyBrain());
        }catch(IllegalArgumentException e) {
            fail("Argument was valid");
        }
    }
}
