package saarland.cispa.sopra.systemtests.steven;

import java.util.NoSuchElementException;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AntFightNoDeath extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "6\n6\n" +
            "AAAA..\n" +
            "AAAA..\n" +
            "AAAA..\n" +
            "......\n"
           +".....B\n"
           +"......";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainB = "brain \"sample\" {\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(2, 42, map, brain, brainB);
        try {
        	world.getAnt(4);
        }catch(NoSuchElementException e) {
        	fail("If an ant is surrounded by friendly units, it should not die!");
        }
        //expect(NoSuchElementException.class, () ->world.getAnt(4));

    }
}
