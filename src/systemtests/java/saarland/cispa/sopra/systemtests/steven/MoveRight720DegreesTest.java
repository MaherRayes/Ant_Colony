package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class MoveRight720DegreesTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "##\n" +
            "AB";
        String brain60  = "brain \"sample\" {\nturn right\njump 1\n}"; //northeast
        String brain120 = "brain \"sample\" {\nturn right\nturn right\njump 2\n}"; //east
        String brain180 = "brain \"sample\" {\nturn right\nturn right\nturn right\njump 3\n}"; //southeast
        String brain240 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\njump 4\n}"; //southwest
        String brain300 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\njump 5\n}"; //west
        String brain360 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\njump 6\n}"; //northwest

        String brain420 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\njump 7\n}";
        String brain480 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\njump 8\n}";
        String brain540 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\njump 9\n}";
        String brain600 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\njump 10\n}";
        String brain660 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\njump 11\n}";
        String brain720 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\nturn right\njump 12\n}";

        WorldInfo world60  = gameInfo.simulate(1, 42, map, brain60 , brain60);
        WorldInfo world120 = gameInfo.simulate(2, 42, map, brain120, brain60);
        WorldInfo world180 = gameInfo.simulate(3, 42, map, brain180, brain60);
        WorldInfo world240 = gameInfo.simulate(4, 42, map, brain240, brain60);
        WorldInfo world300 = gameInfo.simulate(5, 42, map, brain300, brain60);
        WorldInfo world360 = gameInfo.simulate(6, 42, map, brain360, brain60);

        WorldInfo world420 = gameInfo.simulate(7, 42, map, brain420,  brain60);
        WorldInfo world480 = gameInfo.simulate(8, 42, map, brain480,  brain60);
        WorldInfo world540 = gameInfo.simulate(9, 42, map, brain540,  brain60);
        WorldInfo world600 = gameInfo.simulate(10, 42, map, brain600, brain60);
        WorldInfo world660 = gameInfo.simulate(11, 42, map, brain660, brain60);
        WorldInfo world720 = gameInfo.simulate(12, 42, map, brain720, brain60);
        if(!"northeast".equals(world60.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"east".equals(world120.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"southeast".equals(world180.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"southwest".equals(world240.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"west".equals(world300.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"northwest".equals(world360.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"northeast".equals(world420.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"east".equals(world480.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"southeast".equals(world540.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"southwest".equals(world600.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"west".equals(world660.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
        if(!"northwest".equals(world720.getAnt(0).getDirection())) {
        	fail("Ant 0 did not turn to right properly!");
        }
    }
}
