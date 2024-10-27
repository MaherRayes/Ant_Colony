package saarland.cispa.sopra.systemtests.simon.acolatests.marker;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SenseMarker1 extends BaseTest {

    // TODO currently commented out. What is up here?

    @Override
    protected void test(GameInfo gameInfo) {
       setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "mark 0", "sense here marker 0 else 5", "sense here marker 1 else 4", "jump 3", "jump 4", "jump 5");

        simulate(10, 42, map, brain, trivialBrain());

        // initial direction: northwest
        verifyAnt(new AntTestObject(0, 4));

        verifyMarker(0, 0, 'A', true, false, false, false);
        verifyMarker(0, 0, 'B', false, false, false, false);

    }
}
