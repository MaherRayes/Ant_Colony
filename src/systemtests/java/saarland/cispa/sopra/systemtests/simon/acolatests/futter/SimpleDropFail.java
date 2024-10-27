package saarland.cispa.sopra.systemtests.simon.acolatests.futter;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SimpleDropFail extends FutterBase {
    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 0, '.');

        String map = getMapper().toString();
        String brain = createNewBrain(  "drop else 2", "jump 1", "jump 2");

        simulate(50, 42, map, brain, trivialBrain());

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1, 1,  2, "northwest").withCheckFood(false));
        verifyAnts(new AntTestObject(1, 2, 2,  "northwest").withCheckFood(false));
        verifyNoMoreAnts();

        verifyFutterOn(1,0,0);

    }
}
