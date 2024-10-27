package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class CheckRocksKill extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            "###.\n" +
            "A.#.\n" +
            "##B.\n" +
            "....";
        String brainA = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainB = "brain \"sample\" {\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(2, 42, map, brainA, brainB);
        try {
        	world.getAnt(0);
        }catch(NoSuchElementException e) {
        	fail("Ant was surrounded by rocks and got killed!");
        }
    }
}
