package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class TorusFightAndDeathNorth extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            ".ABC\n" +
            "..DE\n" +
            ".F..\n" +
            "GGGG";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainF = "brain \"sample\" {\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(8, 42, map, brain, brain, brain,brain, brain, brainF, brain);
        expect(NoSuchElementException.class, () ->world.getAnt(1));

    }
}
