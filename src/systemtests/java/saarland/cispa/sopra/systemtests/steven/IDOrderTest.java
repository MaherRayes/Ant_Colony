package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class IDOrderTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AB\n" +
            "CD";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        WorldInfo world = gameInfo.simulate(0, 42, map,  brain, brain, brain, brain);
        if(world.getFieldAt(0, 0).getAnt().get().getId()!=0) {
        	fail("Ant0 does not have ID 0!");
        }
        if(world.getFieldAt(1, 0).getAnt().get().getId()!=1) {
        	fail("Ant1 does not have ID 1!");
        }
        if(world.getFieldAt(0, 1).getAnt().get().getId()!=2) {
        	fail("Ant2 does not have ID 2!");
        }
        if(world.getFieldAt(1, 1).getAnt().get().getId()!=3) {
        	fail("Ant3 does not have ID 3!");
        }



    }
}
