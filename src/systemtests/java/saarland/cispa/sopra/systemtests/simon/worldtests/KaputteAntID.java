package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

import java.util.NoSuchElementException;

public class KaputteAntID extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);
        simulate(1, 42, getMapper().toString(), trivialBrain(), trivialBrain());
        expect(NoSuchElementException.class, () -> worldInfo.getAnt(-1));
        expect(NoSuchElementException.class, () -> worldInfo.getAnt(2));
        expect(NoSuchElementException.class, () -> worldInfo.getAnt(7));
        if (worldInfo.getAnt(0).getSwarm() != 'A' || worldInfo.getAnt(1).getSwarm() != 'B') {
            fail("Ant fail");
        }
        verifyAnt(new AntTestObject(0).withCheckRegisters(false, false, false, false, false, false));

    }
}
