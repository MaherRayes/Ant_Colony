package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class RestTimeNoMoveTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AB\n" +
            "..";
        String brainA = "brain \"sample\" {\nturn left\njump 0\n}";
        String brainB = "brain \"sample\" {\nturn left\njump 0\n}";
        WorldInfo world = gameInfo.simulate(1, 42, map, brainA, brainB);
        if(world.getAnt(0).getRestTime()!=0) {
        	fail("Rest time for ant 0 is nor properly set to 0, it was: "+world.getAnt(0).getRestTime());
        }
        if(world.getAnt(1).getRestTime()!=0) {
        	fail("Rest time for ant 1 is nor properly set to 0, it was: "+world.getAnt(1).getRestTime());
        }
    }
}
