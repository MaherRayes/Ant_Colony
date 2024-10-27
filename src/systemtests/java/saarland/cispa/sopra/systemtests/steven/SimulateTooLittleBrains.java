package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;


public class SimulateTooLittleBrains extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "BC";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        expect(IllegalArgumentException.class, () ->gameInfo.simulate(1, 42, map, brain, brain) );
    }
}
