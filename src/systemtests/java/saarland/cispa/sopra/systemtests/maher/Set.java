package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Set extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\nset 1\n unset 1\njump 0\n}";

        WorldInfo world = gameInfo.simulate(0, 42, map, brain, brain);



        boolean[] b = world.getAnt(0).getRegister();

        if(b.length != 6){
            fail("number of registers isn't right");
        }

        for(int i = 0; i<6; i++){
            if(b[1]){
                fail("initial value of the register 1 isn't false");
            }
        }

        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        WorldInfo world2 = gameInfo.simulate(1, 42, map, brain, brain);

        boolean[] b2 = world2.getAnt(0).getRegister();

        if(!b2[1]){
            fail("The value of the register 1 didn't change");
        }

        WorldInfo world3 = gameInfo.simulate(2, 42, map, brain, brain);

        boolean[] b3 = world3.getAnt(0).getRegister();

        if(b3[1]){
            fail("The value of the register 1 is still true after unsetting it");
        }


    }
}
