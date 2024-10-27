package saarland.cispa.sopra.systemtests.steven;

import java.util.NoSuchElementException;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AntDiesWithFoodOnBaseTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            "ABC.\n" +
            "D.E1\n" +
            "FGH.\n" +
            "....";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainH = "brain \"sample\" {\nturn left\n turn right\nmove else 0\njump 0\n}";
        String brainD = "brain \"sample\" {\nturn left\nmove else 0\npickup else 0\nturn right\nturn right\nturn right\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(40, 42, map, brain, brain, brain,brainD, brain, brain,brain, brainH);

        if(world.getScore('D')!=4) {
        	fail("Ant 3 died on its base field, but it did not get an increased score from the food");
        }
        if(world.getFieldAt(0, 1).getFood()!=0) {
        	fail("The food dropped by Ant3s death has not disappeared upon landing on  a base field!");
        }
        expect(NoSuchElementException.class, () ->world.getAnt(3));
        if(world.getAnts().size()!=7) {
        	fail("Ant has not been removed from list!");
        }
    }

}
