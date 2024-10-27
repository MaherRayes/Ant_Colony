package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class JumpTest extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n"
				+ "A.\n"
				+ "B.";
		String brainB = "brain \"sample\" {\nturn left\njump 0\n}";
		String brainA = "brain \"sample\" {\njump 2\nturn left\njump 0\n}";


			WorldInfo world = gameInfo.simulate(1, 42, map, brainA, brainB);
			if(world.getAnt(0).getPc()!=2) {
				fail("PC for next instruction does not match!");
			}

	}

}
