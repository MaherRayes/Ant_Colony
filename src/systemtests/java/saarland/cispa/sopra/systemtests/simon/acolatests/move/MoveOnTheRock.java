package saarland.cispa.sopra.systemtests.simon.acolatests.move;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MoveOnTheRock extends MoveBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 0, '#');

        String map = getMapper().toString();
        String brain = createNewBrain(  "move else 2", "jump 1", "jump 2");

        simulate(1, 42, map, brain, trivialBrain());

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1, 1,  2, "northwest").withCheckRestTime(0));
        verifyAnts(new AntTestObject(1, 2, 2,  "northwest"));
        verifyNoMoreAnts();

    }
}
