package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Move4 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(16, gameInfo);

        boolean[] b = wi.getAnt(0).getRegister();
        boolean[] b2 = wi.getAnt(1).getRegister();

        if(!b[1]||!b2[1]){

            fail("Both ants should have moved");
        }

        if(wi.getAnt(0).getField().getX() != 3 || wi.getAnt(0).getField().getY() != 3){
            fail("The position of the first ant is wrong");
        }

        if(wi.getAnt(1).getField().getX() != 0 || wi.getAnt(1).getField().getY() != 0){
            fail("The position of the second ant is wrong");
        }

    }



    private WorldInfo simGame(int round, GameInfo g) {

        String map = "4\n4\n" +
            "A...\n" +
            "B...\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\n move else 2 \n set 1\n jump 2\n}";
        return g.simulate(round, 42, map, brain, brain);

    }
}
