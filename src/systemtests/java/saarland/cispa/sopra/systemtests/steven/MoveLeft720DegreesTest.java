package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class MoveLeft720DegreesTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "##\n" +
            "AB";
        String brain60L  = "brain \"sample\" {\nturn left\njump 1\n}"; //west
        String brain120L = "brain \"sample\" {\nturn left\nturn left\njump 2\n}"; //southwest
        String brain180L = "brain \"sample\" {\nturn left\nturn left\nturn left\njump 3\n}"; //southeast
        String brain240L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\njump 4\n}"; //east
        String brain300L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\nturn left\njump 5\n}"; //northeast
        String brain360L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\njump 6\n}"; //northwest

        String brain420L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\njump 7\n}";
        String brain480L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\njump 8\n}";
        String brain540L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\njump 9\n}";
        String brain600L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\njump 10\n}";
        String brain660L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\njump 11\n}";
        String brain720L = "brain \"sample\" {\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\nturn left\njump 12\n}";

        WorldInfo world60L  = gameInfo.simulate(1, 42, map, brain60L , brain60L);
        WorldInfo world120L = gameInfo.simulate(2, 42, map, brain120L, brain60L);
        WorldInfo world180L = gameInfo.simulate(3, 42, map, brain180L, brain60L);
        WorldInfo world240L = gameInfo.simulate(4, 42, map, brain240L, brain60L);
        WorldInfo world300L = gameInfo.simulate(5, 42, map, brain300L, brain60L);
        WorldInfo world360L = gameInfo.simulate(6, 42, map, brain360L, brain60L);

        WorldInfo world420L = gameInfo.simulate(7, 42, map, brain420L,  brain60L);
        WorldInfo world480L = gameInfo.simulate(8, 42, map, brain480L,  brain60L);
        WorldInfo world540L = gameInfo.simulate(9, 42, map, brain540L,  brain60L);
        WorldInfo world600L = gameInfo.simulate(10, 42, map, brain600L, brain60L);
        WorldInfo world660L = gameInfo.simulate(11, 42, map, brain660L, brain60L);
        WorldInfo world720L = gameInfo.simulate(12, 42, map, brain720L, brain60L);
        if(!"west".equals(world60L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"southwest".equals(world120L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"southeast".equals(world180L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"east".equals(world240L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"northeast".equals(world300L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"northwest".equals(world360L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"west".equals(world420L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"southwest".equals(world480L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"southeast".equals(world540L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"east".equals(world600L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"northeast".equals(world660L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
        if(!"northwest".equals(world720L.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to left properly!");
        }
    }
}
