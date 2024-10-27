package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Friend extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "..A.\n"+
            "..A.\n" +
            "....\n" +
            "...B";
        String brain = "brain \"sample\" {\nsense ahead friend else 3\n sense here friend else 3\n set 1 \njump 0\n}";

        WorldInfo world = gameInfo.simulate(3, 42, map, brain, brain);
        AntInfo an = world.getAnt(1);
        boolean[] b = an.getRegister();

        if(!b[1]){
            fail("The sense should work with friend and the ant itself");
        }
    }
}
