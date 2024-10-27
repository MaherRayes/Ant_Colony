package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Move3 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi2 = simGame2(17, gameInfo);

        boolean[] b2 = wi2.getAnt(0).getRegister();
        if(!b2[1]){
            fail("The ant moved, so there should be no jumping in the code");
        }

        if(wi2.getAnt(1).getField().getX() != 1 || wi2.getAnt(1).getField().getY() != 1){
            fail("the first ant should be standing on (1,1)");
        }

        if(wi2.getAnt(0).getField().getX() != 0 || wi2.getAnt(0).getField().getY() != 0){
            fail("the first ant should be standing on (0,0)");
        }


    }



    private WorldInfo simGame2(int round, GameInfo g) {

        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\n turn right \n turn right\n move else 3\n set 1 \njump 0\n}";
        return g.simulate(round, 42, map, brain, brain);

    }
}
