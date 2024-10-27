package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class BrainMissing extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n"
				+ "A.\n"
				+ "B.";
		String brains = "brain \"mark\" {\nturn left\njump 0\n}";
		String brain = " \"mark\" {\nturn left\njump 0\n}";
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(1, 42, map, brains, brain));

	}

}
