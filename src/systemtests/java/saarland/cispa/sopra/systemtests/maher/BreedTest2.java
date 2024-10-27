
package saarland.cispa.sopra.systemtests.maher;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class BreedTest2 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "..1#\n"+
            ".A1#\n" +
            ".BA#\n" +
            ".B..";
        String brain = "brain \"sample\" {\nturn right\n move else 0\n pickup else 6\n turn left\n breed else 6\n set 1\n jump 6\n}";

        WorldInfo world = gameInfo.simulate(6, 42, map, brain, brain);



        if(world.getAnt(3).getField().getX() != 1 || world.getAnt(3).getField().getY() != 3){
            fail("The breeded ant should be standing on the field (3,0)");
        }




    }
}
