package saarland.cispa.sopra.systemtests.simon.acolatests.turn;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class TurnTestSimple extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "turn left", "jump 0");
        String brainTwo = createNewBrain( "turn right", "jump 0");

        simulate(1, 42, map, brain, brainTwo);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 0, 0,  "west"));
        verifyAnts(new AntTestObject(1, 1, 0,  "northeast"));
        verifyNoMoreAnts();

    }
}
