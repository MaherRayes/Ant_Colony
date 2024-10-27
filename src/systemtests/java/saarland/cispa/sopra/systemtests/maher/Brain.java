package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class Brain extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n"+
            "A.\n"+
            "B.";
        String brain = "brain \"sample\" {\nturn left\njump 0\n}";

        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain));
    }
}
