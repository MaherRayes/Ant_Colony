package saarland.cispa.sopra.systemtests.simon.worldtests.initial;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class InitialStateTest1 extends InitStateSuper {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        simulate(0, 42, getMapper().toString(), trivialBrain(), trivialBrain());

        verifyAnt(new AntTestObject(0, 0, 0, 0, "northwest").withCheckRegisters(false, false, false, false, false, false).withCheckFood(false).withCheckRestTime(0));
        verifyAnt(new AntTestObject(1, 0, 1, 0, "northwest").withCheckRegisters(false, false, false, false, false, false).withCheckFood(false).withCheckRestTime(0));


    }

}
