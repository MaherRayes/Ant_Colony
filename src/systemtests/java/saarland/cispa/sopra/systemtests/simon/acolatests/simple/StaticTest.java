package saarland.cispa.sopra.systemtests.simon.acolatests.simple;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class StaticTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "jump 0");

        simulate(1, 42, map, brain, brain);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 0, 0, 0, "northwest"));
        verifyAnts(new AntTestObject(1, 1, 0, 0, "northwest"));
        verifyNoMoreAnts();

        verifyMapper(getMapper());
    }
}
