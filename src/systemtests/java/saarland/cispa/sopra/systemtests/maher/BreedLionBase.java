package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;



public class BreedLionBase extends SystemTest {

    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "#11.\n"+
            ".AA.\n" +
            "..=B\n" +
            "####";

        String brain = "brain \"sample\" {\n move else 0\n pickup else 1\n turn right \n turn right \n breed else 4 \n jump 5\n}";
        String brain2 = "brain \"sample2\" {\njump 0\n}";

        WorldInfo world = gameInfo.simulate(25, 42, map, brain, brain2);


        if(world.getAnts().size() != 3){
            fail("The breeded ant should be dead");
        }

        if(world.getScore('A') != 1){

            fail("The score should be 1");

        }


    }


}
