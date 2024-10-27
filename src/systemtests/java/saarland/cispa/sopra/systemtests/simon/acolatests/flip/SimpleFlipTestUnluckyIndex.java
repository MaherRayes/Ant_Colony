package saarland.cispa.sopra.systemtests.simon.acolatests.flip;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SimpleFlipTestUnluckyIndex extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        expect(IllegalArgumentException.class, () -> simulate(10, 10, getMapper().toString(), createNewBrain( "flip -123123 else 5", "jump 1", "jump 2"), trivialBrain()));

    }
}
