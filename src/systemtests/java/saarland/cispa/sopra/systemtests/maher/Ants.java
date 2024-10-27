package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Ants extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "AAA.\n"+
            "B...\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\nturn left\njump 0\n}";

        WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);

        if(world.getAnts().size() != 4){
            fail("the number of ants isn't right");
        }

        if(world.getScore('A') != 0 || world.getScore('B') != 0){
            fail("The iniatial score isn't zero");
        }
    }
}
