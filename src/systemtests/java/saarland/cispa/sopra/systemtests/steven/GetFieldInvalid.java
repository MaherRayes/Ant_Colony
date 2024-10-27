package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class GetFieldInvalid extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "##\n" +
            "AB";
        String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);

        expect(NoSuchElementException.class, () -> world.getFieldAt(-1, 0));
        expect(NoSuchElementException.class, () -> world.getFieldAt(0, -1));
        expect(NoSuchElementException.class, () -> world.getFieldAt(2, 1));
        expect(NoSuchElementException.class, () -> world.getFieldAt(1, 2));
    }
}
