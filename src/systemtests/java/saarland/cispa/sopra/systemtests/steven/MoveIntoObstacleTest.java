package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class MoveIntoObstacleTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            "####\n" +
            "A..B\n"
            +"....\n"
            +"....";
        String brain = "brain \"sample\" {\nmove else 1\nturn left\njump 2\n}";
        WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);

        if (world.getAnt(0).getField().getX()==3) {
        	if(world.getAnt(0).getField().getY()==0) {
        		fail("Ant 0 is not at 0,1, but at:"+ world.getAnt(0).getField().toString());
        	}
        }
        if (world.getAnt(1).getField().getX()==2) {
        	if(world.getAnt(1).getField().getY()==0) {
        		fail("Ant 1 is not at 3,1, but at:"+ world.getAnt(1).getField().toString());
        	}
        }
    }
}
