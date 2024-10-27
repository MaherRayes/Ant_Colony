package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class OneMoreMutantBitch extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "4\n4\n" +
	             ".AA.\n" +
	             "A9A.\n"
	            +".A1.\n"
	            +"..B.";
	        String brainA = "brain \"sample\" {\njump 0\n}";
	        String brainB = "brain \"sample\" {\nmove else 0\npickup else 0\nmove else 0\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(40, 42, map, brainA, brainB);
	        if(world.getFieldAt(1, 1).getFood()!=13) {
	        	fail("The proper food amount on the field after death has not been dropped!");
	        }
	 }
}

