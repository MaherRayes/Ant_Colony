package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Turning extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\n turn right \n turn left \n turn left \n turn left \n turn left \n turn left \n turn left \n turn left \n jump 1\n}";

        WorldInfo world = gameInfo.simulate(0, 42, map, brain, brain);

        if(!"northwest".equals(world.getAnt(0).getDirection())){
            fail("not the right direction, should be northwest");
        }
        WorldInfo world1 = gameInfo.simulate(1, 42, map, brain, brain);

        if(!"northeast".equals(world1.getAnt(0).getDirection())){
            fail("not the right direction, should be northeast");
        }
        WorldInfo world2 = gameInfo.simulate(2, 42, map, brain, brain);

        if(!"northwest".equals(world2.getAnt(0).getDirection())){
            fail("not the right direction, should be northwest");
        }
        WorldInfo world3 = gameInfo.simulate(3, 42, map, brain, brain);

        if(!"west".equals(world3.getAnt(0).getDirection())){
            fail("not the right direction, should be west");
        }
        WorldInfo world4 = gameInfo.simulate(4, 42, map, brain, brain);

        if(!"southwest".equals(world4.getAnt(0).getDirection())){
            fail("not the right direction, should be southwest");
        }
        WorldInfo world5 = gameInfo.simulate(5, 42, map, brain, brain);

        if(!"southeast".equals(world5.getAnt(0).getDirection())){
            fail("not the right direction, should be southeast");
        }
        WorldInfo world6 = gameInfo.simulate(6, 42, map, brain, brain);

        if(!"east".equals(world6.getAnt(0).getDirection())){
            fail("not the right direction, should be east");
        }
        WorldInfo world7 = gameInfo.simulate(7, 42, map, brain, brain);

        if(!"northeast".equals(world7.getAnt(0).getDirection())){
            fail("not the right direction, should be northeast");
        }
        WorldInfo world8 = gameInfo.simulate(8, 42, map, brain, brain);

        if(!"northwest".equals(world8.getAnt(0).getDirection())){
            fail("not the right direction, should be northwest");
        }


    }
}
