package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Test extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\nset 1\n test 1 else 3\n unset 1\njump 0\n}";

        WorldInfo world = gameInfo.simulate(3, 42, map, brain, brain);

        boolean[] b = world.getAnt(0).getRegister();
        if(b[1]){
            fail("skipped a command even though the tested value is true");
        }

        String brain2 = "brain \"sample\" {\n test 1 else 2\n set 1\njump 0\n}";
        WorldInfo world2 = gameInfo.simulate(2, 42, map, brain2, brain2);

        boolean[] b2 = world2.getAnt(0).getRegister();
        if(b2[1]){
            fail("didn't skip the command even though the tested value is false");
        }


    }
}
