package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class PCPDM extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "A...\n"+
            "B...\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\nturn left\njump 0\n}";


        WorldInfo world = gameInfo.simulate(0, 42, map, brain, brain);

        if(world.getAnt(0).getPc() != 0){
            fail("the pc should be on 0");
        }

        WorldInfo world2 = gameInfo.simulate(1, 42, map, brain, brain);

        if(world2.getAnt(0).getPc() != 1){
            fail("the pc should be on 1");
        }
    }
}
