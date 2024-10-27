package saarland.cispa.sopra.systemtests.simon.acolatests.invalidbrain;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

import java.util.stream.IntStream;

public class BrainTooLong extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain(IntStream.range(0, 2501).mapToObj(i -> "jump " + i).toArray(String[]::new)); // too big!

        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, brain, brain));

    }
}
