package saarland.cispa.sopra.systemtests.simon.worldtests.initial;

import saarland.cispa.sopra.systemtests.GameInfo;

public class InitialStateTest3 extends InitStateSuper {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        simulate(0, 42, getMapper().toString(), trivialBrain(), trivialBrain());

        verifyMapper(getMapper());


    }

}
