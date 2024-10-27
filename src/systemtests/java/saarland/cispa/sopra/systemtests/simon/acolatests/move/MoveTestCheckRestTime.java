package saarland.cispa.sopra.systemtests.simon.acolatests.move;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MoveTestCheckRestTime extends MoveBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "move else 1", "jump 1");
        String trivial = trivialBrain();

        simulate(14, 42, map, brain, trivial);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0).withCheckRestTime(0));

    }
}
