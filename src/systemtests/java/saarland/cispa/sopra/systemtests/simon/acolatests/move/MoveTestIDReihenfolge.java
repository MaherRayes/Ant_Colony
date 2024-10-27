package saarland.cispa.sopra.systemtests.simon.acolatests.move;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MoveTestIDReihenfolge extends MoveBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "move else 2", "jump 1", "jump 2");

        simulate(50, 42, map, brain, brain);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1, 0,1,  "northwest"));
        verifyAnts(new AntTestObject(1, 1, 1,1,  "northwest"));
        verifyNoMoreAnts();

    }
}
