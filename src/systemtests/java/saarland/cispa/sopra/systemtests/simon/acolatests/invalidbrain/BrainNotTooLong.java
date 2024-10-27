package saarland.cispa.sopra.systemtests.simon.acolatests.invalidbrain;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

import java.util.stream.IntStream;

public class BrainNotTooLong extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain(IntStream.range(0, 2500).mapToObj(i -> "jump " + i).toArray(String[]::new)); // too big!

        simulate(1, 42, map, brain, brain);

        verifyAnt(new AntTestObject(0, 0));
        verifyAnt(new AntTestObject(1, 0));

    }
}
