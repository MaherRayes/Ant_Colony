package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class BreedFailDead extends SystemTest {

    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            ".AA.\n"+
            "ABA.\n" +
            ".A..\n" +
            "....";

        String brain = "brain \"sample\" {\n jump 0\n}";
        String brain2 = "brain \"sample2\" {\nbreed else 0\njump 0\n}";

        WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain2);


        if(world.getAnts().size() != 5){
            fail("The ant didn't breed and should be dead");
        }

        if(world.getScore('B') != 3){

            fail("The score should be 1");

        }


    }


}
