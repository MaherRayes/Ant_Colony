package saarland.cispa.sopra.systemtests.simon.worldtests.initial;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class InitialStateTest5 extends InitStateSuper {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        simulate(0, 42, getMapper().toString(), trivialBrain(), trivialBrain());

        verifyAnt(new AntTestObject(1, 0, 1, 0, "northwest"));
        verifyAnt(new AntTestObject(0, 0, 0, 0, "northwest"));
        verifyNoMoreAnts();


    }

}
