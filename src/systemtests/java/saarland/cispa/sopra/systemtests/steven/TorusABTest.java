package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;
import java.util.NoSuchElementException;

public class TorusABTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AA\n" +
            "AB";
        String brain = "brain \"sample\" {\nmove else 0\njump 0\n}";
        String brainA = "brain \"sample\" {\nturn right\njump 0\n}";

        WorldInfo world = gameInfo.simulate(2, 42, map, brainA, brain);

        if(world.getScore('B')!=3) {
        	fail("Ant 3 died on its base field, but it did not get an increased score from the food");
        }
        if(world.getFieldAt(1, 1).getFood()!=0) {
        	fail("The food dropped by Ant0s death has not disappeared upon landing on  a base field!");
        }
        expect(NoSuchElementException.class, () ->world.getAnt(3));
        if(world.getFieldAt(1, 1).getAnt().isPresent()) {
        	fail("Ant has not removed from the field it died on!");
        }
        if(world.getAnts().size()!=3) {
        	fail("Did not remove ant 3 from the list!");
        }
    }
}
