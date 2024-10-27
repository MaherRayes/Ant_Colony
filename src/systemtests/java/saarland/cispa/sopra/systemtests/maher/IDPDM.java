package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class IDPDM extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "A...\n"+
            "B...\n" +
            "....\n" +
            "...A";
        String brain = "brain \"sample\" {\nturn left\njump 0\n}";

        WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);

        if(world.getAnt(0).getField().getX() != 0 || world.getAnt(0).getField().getY() != 0){
            fail("The ID of the ant is wrong");
        }

        if(world.getAnt(1).getField().getX() != 0 || world.getAnt(1).getField().getY() != 1){
            fail("The ID of the ant is wrong");
        }

        if(world.getAnt(2).getField().getX() != 3 || world.getAnt(2).getField().getY() != 3){
            fail("The ID of the ant is wrong");
        }
    }
}
