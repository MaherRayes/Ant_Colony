package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Home extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "...B\n"+
            "..A.\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\nsense ahead home else 2\n set 1 \n sense right home else 4\n set 2 \n sense here home else 6\n set 3\njump 0\n}";

        WorldInfo world = gameInfo.simulate(7, 42, map, brain, brain);
        AntInfo an = world.getAnt(1);
        boolean[] b = an.getRegister();

        if(b[1] || b[2] || !b[3]){
            fail("The sense should just work with the base of the ant");
        }
    }
}
