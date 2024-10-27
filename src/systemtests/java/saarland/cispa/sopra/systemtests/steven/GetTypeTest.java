package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class GetTypeTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n" +
            "AB..\n" +
            "#1..\n"
          + "...."
          + "....";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);
        if(world.getFieldAt(0, 0).getType()!='A') {
        	fail("Field A is not of Type A!");
        }
        if(world.getFieldAt(1, 0).getType()!='B') {
        	fail("Field B is not of Type B!");
        }
        if(world.getFieldAt(0, 1).getType()!='#') {
        	fail("Field # is not of Type #!");
        }
        if(world.getFieldAt(1, 1).getType()!='.') {
        	fail("Food Field . is not of Type .!");
        }
        if(world.getFieldAt(2, 2).getType()!='.') {
        	fail("Field . is not of Type .!");
        }
    }
}
