package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Direction extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\n turn right \n direction west else 3\n set 1\n turn left \n turn left \njump 1\n}";

        WorldInfo world = gameInfo.simulate(0, 42, map, brain, brain);

        if(!"northwest".equals(world.getAnt(0).getDirection())){
            fail("the initial direction of an ant isn't northwest");
        }

        WorldInfo world2 = gameInfo.simulate(1, 42, map, brain, brain);

        if(!"northeast".equals(world2.getAnt(0).getDirection())){
            fail("The ant didn't turn right");
        }

        WorldInfo world3 = gameInfo.simulate(3, 42, map, brain, brain);

        boolean[] b = world3.getAnt(0).getRegister();

        if(b[1]){
            fail("Checking direction was false, there should be jumping");
        }

        WorldInfo world4 = gameInfo.simulate(7, 42, map, brain, brain);

        boolean[] b2 = world4.getAnt(0).getRegister();

        if(!b2[1]){
            fail("Checking direction was false, there should be jumping");
        }

    }
}
