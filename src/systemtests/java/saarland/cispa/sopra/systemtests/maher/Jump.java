package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Jump extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\nset 1\n jump 3\n unset 1\njump 0\n}";

        WorldInfo world = gameInfo.simulate(3, 42, map, brain, brain);

        boolean[] b = world.getAnt(0).getRegister();

        if(!b[1]){
            fail("jump didn't work right");

        }
    }
}
