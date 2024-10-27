package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

import java.util.NoSuchElementException;

public class OOBField extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);
        simulate(1, 42, getMapper().toString(), trivialBrain(), trivialBrain());
        expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(4, 4));
        expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(-1, 0));
        expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(0, -1));
    }
}
