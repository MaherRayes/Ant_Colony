package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SenseRock extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "..#B\n"+
            "..A.\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\nsense ahead rock else 2\n set 1 \n sense right rock else 4\n set 2\n jump 0\n}";

        WorldInfo world = gameInfo.simulate(3, 42, map, brain, brain);
        AntInfo an = world.getAnt(1);
        boolean[] b = an.getRegister();

        if(!b[1] || b[2]){
            fail("The sense should work with food and stop working with it after picking it up");
        }
    }
}
