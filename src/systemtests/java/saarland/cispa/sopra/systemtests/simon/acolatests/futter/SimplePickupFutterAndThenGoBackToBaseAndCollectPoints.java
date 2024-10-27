package saarland.cispa.sopra.systemtests.simon.acolatests.futter;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SimplePickupFutterAndThenGoBackToBaseAndCollectPoints extends FutterBase {
    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 0, '1');

        String map = getMapper().toString();
        String brain = createNewBrain(  "move else 10", "pickup else 10", "turn left","turn left","turn left","move else 10", "drop else 10", "jump 7", "jump 8", "jump 9", "jump 10");

        simulate(100, 42, map, brain, trivialBrain());

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1, 1,  7 ).withCheckFood(false));
        verifyAnts(new AntTestObject(1).withCheckFood(false));
        verifyNoMoreAnts();

        verifyFutterOn(1, 0, 0);

        verifyScore('A', 1);
        verifyScore('B', 0);

    }
}
