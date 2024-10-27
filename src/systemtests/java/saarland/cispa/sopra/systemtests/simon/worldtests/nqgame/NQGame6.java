package saarland.cispa.sopra.systemtests.simon.worldtests.nqgame;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.simon.worldtests.NonQuadraticGame;

public class NQGame6 extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        NonQuadraticGame g = new NonQuadraticGame();
        g.executeTest(gameInfo);
        g.checkScore();
    }
}
