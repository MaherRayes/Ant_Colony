package saarland.cispa.sopra.systemtests.simon.acolatests.turn;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class TurnTest360Deg extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "turn left","turn left","turn left", "jump 0");
        String brainTwo = createNewBrain( "turn right","turn right","turn right", "jump 0");

        simulate(7, 42, map, brain, brainTwo);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 0, 0,  "northwest"));
        verifyAnts(new AntTestObject(1, 1, 0,  "northwest"));
        verifyNoMoreAnts();

    }
}
