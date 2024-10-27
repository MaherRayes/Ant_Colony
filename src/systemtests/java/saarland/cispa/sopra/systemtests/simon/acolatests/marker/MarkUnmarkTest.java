package saarland.cispa.sopra.systemtests.simon.acolatests.marker;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MarkUnmarkTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "mark 0", "unmark 0", "sense here marker 0 else 4", "jump 3", "jump 4");

        simulate(10, 42, map, brain, trivialBrain());

        verifyAnt(new AntTestObject(0, 4));

        verifyMarker(0, 0, 'A', false, false, false);
        verifyMarker(0, 0, 'B', false, false, false);
        verifyMarker(1, 0, 'B', false, false, false);
        verifyMarker(1, 0, 'A', false, false, false);
    }
}
