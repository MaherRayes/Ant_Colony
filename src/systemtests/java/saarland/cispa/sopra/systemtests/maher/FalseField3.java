package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class FalseField3 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n"+
            "B.\n"+
            ".A";
        String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        WorldInfo wi = gameInfo.simulate(1, 42, map, brain, brain);

        expect(NoSuchElementException.class, () -> wi.getFieldAt(3,3));
    }
}
