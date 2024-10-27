package saarland.cispa.sopra.systemtests.simon.acolatests.simple;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class StaticScoreTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = trivialBrain();

        simulate(1, 42, map, brain, brain);

        if (getWorldInfo().getScore('A') != 0) {
            fail("Lol no 0 score");
        }
        if (getWorldInfo().getScore('B') != 0) {
            fail("Lol no 0 score");
        }


        verifyMapper(getMapper());
    }
}
