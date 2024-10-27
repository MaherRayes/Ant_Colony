package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Foe extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "..AB\n"+
            "..A.\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\nsense right foe else 2\n set 1 \n sense ahead foe else 4\n set 2 \n sense here foe else 6\n set 3\njump 0\n}";

        WorldInfo world = gameInfo.simulate(7, 42, map, brain, brain);
        AntInfo an = world.getAnt(2);
        boolean[] b = an.getRegister();

        if(!b[1] || b[2] || b[3]){
            fail("The sense should work with foe but not a friend or the ant itself");
        }
    }
}
