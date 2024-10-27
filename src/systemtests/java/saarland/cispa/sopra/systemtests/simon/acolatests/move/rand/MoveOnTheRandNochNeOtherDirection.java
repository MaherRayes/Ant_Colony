package saarland.cispa.sopra.systemtests.simon.acolatests.move.rand;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MoveOnTheRandNochNeOtherDirection extends MoveOnTheRandBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain(  "turn right", "move else 3", "jump 2", "jump 3");

        simulate(50, 42, map, brain, trivialBrain());

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 0, 3,  2, "northeast"));
        verifyAnts(new AntTestObject(1, 1, 1,  "northwest"));
        verifyNoMoreAnts();

    }
}
