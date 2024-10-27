package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class TorusFightAndDeathSouth extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            "..AB\n" +
            "....\n" +
            "D.C.\n" +
            ".EFG";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainD = "brain \"sample\" {\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(8, 42, map, brain, brain, brain,brainD, brain, brain,brain);
        expect(NoSuchElementException.class, () ->world.getAnt(5));

    }
}
