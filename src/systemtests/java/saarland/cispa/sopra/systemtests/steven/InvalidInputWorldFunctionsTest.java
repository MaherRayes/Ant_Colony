package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class InvalidInputWorldFunctionsTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            ".B\n";
        String brainA = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainB = "brain \"sample\" {\nturn right\njump 0\n}";
        WorldInfo world = gameInfo.simulate(2, 42, map, brainA, brainB);
        expect(NoSuchElementException.class, () ->world.getAnt(3));
        expect(NoSuchElementException.class, () ->world.getAnt(-1));
        if(world.getWidth()!=2) {
        	fail("Width on map was not properly set!");
        }
        if(world.getHeight()!=2) {
        	fail("Height on map was not properly set!");
        }
        /*
        try {
        	world.getScore('I');
        }catch(Exception e) {

        	return;
        }
        fail("Score accepts illegal input!");*/
    }
}
