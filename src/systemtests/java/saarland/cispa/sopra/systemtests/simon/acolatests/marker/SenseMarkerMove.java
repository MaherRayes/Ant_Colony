package saarland.cispa.sopra.systemtests.simon.acolatests.marker;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SenseMarkerMove extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
       setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "mark 1", "turn left", "turn left", "turn left", "move else 10", "turn left", "turn left", "turn left", "sense ahead marker 1 else 10", "jump 9", "jump 10");

        simulate(100, 42, map, brain, trivialBrain());

        // initial direction: northwest
        verifyAnt(new AntTestObject(0, 9));


        verifyMarker(0, 0, 'A', false, true, false);
        verifyMarker(0, 1, 'A', false, false, false);

    }
}
