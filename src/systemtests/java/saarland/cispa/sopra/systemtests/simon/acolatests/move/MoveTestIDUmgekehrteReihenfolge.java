package saarland.cispa.sopra.systemtests.simon.acolatests.move;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MoveTestIDUmgekehrteReihenfolge extends MoveBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "turn left","turn left","turn left", "move else 5", "jump 4", "jump 5");

        simulate(10, 42, map, brain, brain);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1, 1,5,  "southeast"));
        verifyAnts(new AntTestObject(1, 2, 3,4,  "southeast"));
        verifyNoMoreAnts();

    }
}
