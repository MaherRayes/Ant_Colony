package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class FightNoMoveTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "10\n10\n" +
            "...ABC....\n" +
            "...DEF....\n" +
            "...GHI....\n" +
            "..........\n" +
            "..........\n" +
            "..........\n" +
            "..........\n" +
            "..........\n" +
            "..........\n" +
            "..........";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        WorldInfo world = gameInfo.simulate(3, 42, map, brain, brain, brain,brain, brain, brain,brain, brain, brain);
        try{
        	world.getAnt(4);
        }catch(NoSuchElementException e) {
        	fail("Ant 4 died surrounded by ants without any ant using a move command!");
        }
        if(world.getAnts().size()!=9) {
        	fail("Ant has been removed from the list!");
        }
    }
}
