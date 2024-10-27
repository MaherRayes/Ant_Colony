package saarland.cispa.sopra.systemtests.giuliano.initialisation;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public abstract class InitialisationTest extends BaseTest {

    @Override
    public void test(GameInfo gameInfo) {
        WorldInfo world = gameInfo.simulate(0, 0, buildSimpleMap(), getEmptyBrain(), getEmptyBrain());
        run(world);
    }

    public abstract void run(WorldInfo world);
}
