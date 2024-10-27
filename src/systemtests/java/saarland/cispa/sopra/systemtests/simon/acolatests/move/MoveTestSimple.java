package saarland.cispa.sopra.systemtests.simon.acolatests.move;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MoveTestSimple extends MoveBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "move else 2", "jump 1", "jump 2");
        String trivial = trivialBrain();

        simulate(1, 42, map, brain, trivial);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1, 0,  1, "northwest"));
        verifyAnts(new AntTestObject(1, 2, 2,  "northwest"));
        verifyNoMoreAnts();

    }
}
