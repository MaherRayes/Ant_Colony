package saarland.cispa.sopra.systemtests.simon.acolatests.invalidbrain;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class JumpDefects extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();

        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("jump 3"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("jump 1"), trivialBrain()));
    }
}
