package saarland.cispa.sopra.systemtests.simon.acolatests.flip;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SimpleFlipTestNegativ extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "flip 0 else 2", "jump 1", "jump 2");

        simulate(5, 42, map, brain, brain);

        // initial direction: northwest
        verifyAnts(new AntTestObject(1, 1));
        verifyAnts(new AntTestObject(0, 1));

    }
}
