package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Food3 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(2, gameInfo);

        boolean[] b = wi.getAnt(0).getRegister();
        if(b[1] || wi.getAnt(0).hasFood()){
            fail("The ant didn't pick anything up, so there should be jumping in the code");
        }



    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "2\n2\n" +
            ".A\n" +
            ".B";
        String brain = "brain \"sample\" {\npickup else 2 \n set 1 \njump 0\n}";
        return g.simulate(round, 42, map, brain, brain);

    }
}
