package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class OneMoveObstacleTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map = "2\n2\n" +
	            "AB\n" +
	            ".#";
	        String brainA = "brain \"sample\" {\nmove else 0\njump 0\n}";
	        String brainB = "brain \"sample\" {\nturn left\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(1, 42, map, brainA, brainB);
	        if(world.getAnt(0).getField().getX()!=0) {
	        	if(world.getAnt(0).getField().getY()!=0) {
	        		 fail("Ant 0 is not at 1,0, but at:"+ world.getAnt(0).getField().toString());
	        	}
	        }
	        expect(NoSuchElementException.class, () -> world.getAnt(42));
    }
}

