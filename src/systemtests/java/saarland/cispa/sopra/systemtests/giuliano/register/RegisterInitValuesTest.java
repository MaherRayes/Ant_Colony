package saarland.cispa.sopra.systemtests.giuliano.register;

import saarland.cispa.sopra.systemtests.GameInfo;

public class RegisterInitValuesTest extends RegisterTest {
    @Override
    public String getBrainA() {
        return getEmptyBrain();
    }

    @Override
    public String getBrainB() {
        return getEmptyBrain();
    }

    @Override
    protected void test(GameInfo gameInfo) {
        boolean[] values = getWorld(gameInfo).getAnt(0).getRegister();
        for(boolean b : values) {
            if(b) {
                fail("Registers must be false initially.");
            }
        }
    }
}
