package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class WaitTime extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "A...\n"+
            "B...\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\nmove else 1\njump 0\n}";

        WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);

        if(world.getAnt(0).getRestTime() != 13){
            fail("the wait time should be 13");
        }
    }
}
