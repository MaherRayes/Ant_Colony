package saarland.cispa.sopra.systemtests.simon.acolatests.futter;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SimplePickupFutterTwice extends FutterBase {
    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 0, '9');
        String brain = createNewBrain(  "move else 3", "pickup else 4", "pickup else 5", "jump 3", "jump 4", "jump 5");

        String map = getMapper().toString();

        simulate(50, 42, map, brain, trivialBrain());

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1, 0,  5, "northwest").withCheckFood(true));
        verifyAnts(new AntTestObject(1, 2, 2,  "northwest").withCheckFood(false));
        verifyFutterOn(1, 0, 8);
        verifyNoMoreAnts();


    }
}
