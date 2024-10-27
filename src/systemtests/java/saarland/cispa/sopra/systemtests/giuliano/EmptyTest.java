package saarland.cispa.sopra.systemtests.giuliano;

import saarland.cispa.sopra.systemtests.GameInfo;

public class EmptyTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        if(gameInfo == null) {
            fail("null");
        }
    }
}
