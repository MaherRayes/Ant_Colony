package saarland.cispa.sopra.systemtests.steven;

import java.util.NoSuchElementException;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AntDiesWithFoodOnFoodField extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            "ABC.\n" +
            "19DE\n" +
            "FGH.\n" +
            "....";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainE = "brain \"sample\" {\nturn right\nturn right\nmove else 0\npickup else 0\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(40, 42, map, brain, brain, brain,brain, brainE, brain,brain, brain);

        if(world.getFieldAt(0, 1).getFood()!=0) {
        	fail("The food has not been picked up by ant 4!");
        }
        if(world.getFieldAt(1, 1).getFood()!=13) {
        	fail("The food from ant 4 that died has not dropped or it did not turn into food!");
        }
        expect(NoSuchElementException.class, () ->world.getAnt(4));
        if(world.getAnts().size()!=7) {
        	fail("Ant has not been removed from list!");
        }
    }
}
