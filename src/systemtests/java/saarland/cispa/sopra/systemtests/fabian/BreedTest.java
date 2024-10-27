package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class BreedTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        String map1 =
            "4\n" +
                "4\n" +
                ".AA.\n" +
                "AB..\n" +
                ".AA.\n" +
                "...C\n";
        String brainC1 =
            "brain \"hopelessBreeder\" {\n" +
                "breed else 0\n" +
                "jump 0\n" +
                "}";
        String brain1 = getUselessBrain();
        WorldInfo world = gameInfo.simulate(1, 01, map1, brain1, brain1, brainC1);
        expect(NoSuchElementException.class, () -> world.getAnt(3));
    }
}
