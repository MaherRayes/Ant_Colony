package saarland.cispa.sopra.systemtests.steven;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class AntBrainNoJump extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	             "AB\n" +
	             "..\n";
	        String brainA = "brain \"sample\" {\njump 0\n}";
	        String brainB = "brain \"sample\" {\nturn left\n}";
	        expect(IllegalArgumentException.class, () -> gameInfo.simulate(7, 42, map, brainA, brainB));

	 }
}

