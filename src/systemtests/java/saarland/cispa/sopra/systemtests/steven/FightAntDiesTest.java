package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;
import java.util.NoSuchElementException;

public class FightAntDiesTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            "ABC.\n" +
            "D.E.\n" +
            "FGH.\n" +
            "....";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainH = "brain \"sample\" {\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(2, 42, map, brain, brain, brain,brain, brain, brain,brain, brainH);
        expect(NoSuchElementException.class, () ->world.getAnt(3));
        if(world.getAnts().size()!=7) {
        	fail("Did not remove the ant from the ant list!");
        }
    }
}
