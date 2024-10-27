package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class UnsuccessfulMoveKillTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            "ABC.\n" +
            "DEF.\n" +
            "GHI.\n" +
            "....";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainI = "brain \"sample\" {\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(2, 42, map, brain, brain, brain,brain, brain, brain,brain, brain, brainI);
        expect(NoSuchElementException.class, () ->world.getAnt(3));
        if(world.getAnts().size()==9) {
        	fail("Did not remove the ant from the ant list!");
        }
    }
}
