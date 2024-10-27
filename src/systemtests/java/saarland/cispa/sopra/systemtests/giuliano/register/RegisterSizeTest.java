package saarland.cispa.sopra.systemtests.giuliano.register;

import saarland.cispa.sopra.systemtests.GameInfo;

public class RegisterSizeTest extends RegisterTest {
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
        int size = getWorld(gameInfo).getAnt(0).getRegister().length;
        if(size != 6) {
            fail(String.format("Register size was %d but should be 6.", size));
        }
    }
}
