package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class BaseNonConnected extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);
        getMapper().setField(2, 2, 'A');
        expect(Exception.class, () -> simulate(1, 42, getMapper().toString(), trivialBrain(), trivialBrain()));
    }
}
