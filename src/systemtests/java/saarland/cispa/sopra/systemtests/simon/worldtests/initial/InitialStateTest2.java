package saarland.cispa.sopra.systemtests.simon.worldtests.initial;

import saarland.cispa.sopra.systemtests.GameInfo;

public class InitialStateTest2 extends InitStateSuper {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        simulate(0, 42, getMapper().toString(), trivialBrain(), trivialBrain());



        verifyScore('A', 0);
        verifyScore('B', 0);

    }

}
