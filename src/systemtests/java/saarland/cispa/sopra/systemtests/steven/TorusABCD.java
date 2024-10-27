package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;
import java.util.NoSuchElementException;

public class TorusABCD extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AB\n" +
            "CD";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainA = "brain \"sample\" {\nmove else 0\njump 0\n}";

        WorldInfo world = gameInfo.simulate(2, 42, map, brainA, brain, brain,brain);

        if(world.getScore('A')!=3) {
        	fail("Ant 0 died on its base field, but it did not get an increased score from the food");
        }
        if(world.getFieldAt(0, 0).getFood()!=0) {
        	fail("The food dropped by Ant0s death has not disappeared upon landing on  a base field!");
        }
        expect(NoSuchElementException.class, () ->world.getAnt(0));
        if(world.getFieldAt(0, 0).getAnt().isPresent()) {
        	fail("Ant has not been removed from the field!");
        }
        if(world.getAnts().size()!=3) {
        	fail("Did not remove ant from the ant list!");
        }
    }
}
