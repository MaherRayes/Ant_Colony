package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SenseFalse extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "A...\n"+
            "....\n" +
            "..B.\n" +
            "....";
        String brain = "brain \"sample\" {\nsense here rock else 2\n set 1 \n sense ahead food else 4\n set 2\n sense right foe else 6\n set 3 \n jump 0\n}";

        WorldInfo world = gameInfo.simulate(7, 42, map, brain, brain);
        AntInfo an = world.getAnt(0);
        boolean[] b = an.getRegister();

        if(b[1] || b[2]||b[3]){
            fail("The sense should work with food and stop working with it after picking it up");
        }
    }
}
