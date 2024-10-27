package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SenseMark extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "..A.\n"+
            "..B.\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\nmark 1\nsense ahead marker 1 else 3\n set 1 \n sense here marker 1 else 5 \n set 2 \njump 0\n}";
        String brain2 = "brain \"sample2\" {\nmark 1\njump 0\n}";

        WorldInfo world = gameInfo.simulate(6, 42, map, brain2, brain);
        AntInfo an = world.getAnt(1);
        boolean[] b = an.getRegister();

        if(b[1] || !b[2]){
            fail("The sense shouldn't work with the markers of the enemy");
        }
    }
}
