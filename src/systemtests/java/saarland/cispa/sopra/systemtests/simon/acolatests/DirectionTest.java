package saarland.cispa.sopra.systemtests.simon.acolatests;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class DirectionTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "direction northwest else 2", "jump 1", "jump 2");
        String brainTwo = createNewBrain( "direction east else 2", "jump 1", "jump 2");

        simulate(20, 42, map, brain, brainTwo);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1));
        verifyAnts(new AntTestObject(1, 2));
        verifyNoMoreAnts();

    }
}
