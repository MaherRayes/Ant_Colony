package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class TorusFightAndDeathWest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"
          + "....\n" +
            "A..B\n" +
            ".C.D\n" +
            "E..F";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainC = "brain \"sample\" {\nturn left\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(8, 42, map, brain, brain, brainC,brain, brain, brain);
        expect(NoSuchElementException.class, () ->world.getAnt(2));

    }
}
