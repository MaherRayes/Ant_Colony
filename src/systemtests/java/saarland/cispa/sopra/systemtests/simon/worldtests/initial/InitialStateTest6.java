package saarland.cispa.sopra.systemtests.simon.worldtests.initial;

import saarland.cispa.sopra.systemtests.GameInfo;

public class InitialStateTest6 extends InitStateSuper {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        simulate(0, 42, getMapper().toString(), trivialBrain(), trivialBrain());

        verifyFutterOn(0, 3, 1);
        verifyFutterOn(1, 0, 2);
        verifyFutterOn(0, 0, 0);
        verifyFutterOn(2, 0, 0);
        verifyFutterOn(3, 0, 0);
        verifyFutterOn(3, 3, 0);

        verifyMarker(0, 0, 'A', false, false, false, false, false, false, false);
        verifyMarker(0, 0, 'B', false, false, false, false, false, false, false);
        verifyMarker(3, 0, 'A', false, false, false, false, false, false, false);
        verifyMarker(0, 3, 'A', false, false, false, false, false, false, false);
        verifyMarker(0, 3, 'B', false, false, false, false, false, false, false);


    }

}
