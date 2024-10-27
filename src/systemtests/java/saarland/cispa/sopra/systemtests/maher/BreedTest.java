
package saarland.cispa.sopra.systemtests.maher;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class BreedTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "..1.\n"+
            ".A1.\n" +
            "..A.\n" +
            ".B..";
        String brain = "brain \"sample\" {\nturn right\n move else 0\n pickup else 3\n turn left\n breed else 6\n set 1\n jump 0\n}";

        WorldInfo world = gameInfo.simulate(6, 42, map, brain, brain);

        if(!world.getAnt(1).getRegister()[1]){
            fail("The breed instruction worked, There should be no jumping");
        }

        if(world.getAnt(0).getRegister()[1] || world.getAnt(2).getRegister()[1]){
            fail("The breed instruction didn't work, There should be jumping");
        }

        if(world.getAnt(3).getField().getX() != 3 || world.getAnt(3).getField().getY() != 0){
            fail("The breeded ant should be standing on the field (3,0)");
        }

        if(world.getAnt(0).hasFood() || world.getAnt(1).hasFood()){
            fail("After breeding the ants should not be holding any food");
        }


    }
}
