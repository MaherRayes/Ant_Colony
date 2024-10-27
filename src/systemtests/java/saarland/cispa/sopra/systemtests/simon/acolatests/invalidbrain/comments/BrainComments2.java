package saarland.cispa.sopra.systemtests.simon.acolatests.invalidbrain.comments;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class BrainComments2 extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();

        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("jump 0 /* asd *", "jump 0"), trivialBrain()));

    }
}
