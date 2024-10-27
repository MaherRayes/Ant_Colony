package saarland.cispa.sopra.systemtests.simon.acolatests.move;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MoveTestAndTurn extends MoveBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "turn left","move else 3", "jump 2", "jump 3");
        String trivial = trivialBrain();

        simulate(2, 42, map, brain, trivial);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 0, 1,  2, "west").withCheckRestTime(13));
        verifyAnts(new AntTestObject(1, 2, 2,  "northwest"));
        verifyNoMoreAnts();

    }
}
