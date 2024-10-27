package saarland.cispa.sopra.systemtests.giuliano.program;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public abstract class SimpleProgramTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        if(valid()) {
            try {
                getWorld(gameInfo);
            } catch (IllegalStateException e) {
                fail(failMessage());
            }
        }
        else {
            expect(IllegalStateException.class, () -> fail(failMessage()));
        }
    }

    public abstract boolean valid();

    public abstract String failMessage();

    public WorldInfo getWorld(GameInfo gameInfo) {
        return gameInfo.simulate(0,0,buildSimpleMap(),getBrain(),getBrain());
    }

    public abstract String getBrain();
}
