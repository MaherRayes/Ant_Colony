package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class IsPresentTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AA\n" +
            "AB";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainA = "brain \"sample\" {\nturn right\njump 0\n}";

        WorldInfo world = gameInfo.simulate(2, 42, map, brainA, brain);

        for(int x=0; x<2;x++) {
        	for(int y=0;y<2;y++) {
        		if(!world.getFieldAt(x, y).getAnt().isPresent()) {
        			fail("Ant is not present on field it stands on!");
        		}
        	}
        }
    }

}
