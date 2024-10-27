package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public abstract class FaultyParametersBase extends SystemTest{

	public void testCommand(GameInfo gameInfo, String command) {
		String map = "2\n2\n"
				+ "A.\n"
				+ "B.";
	String brain = "brain \"sample\" {\n"
			+ command
			+ "\njump 0\n}";
    expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));
	}
}
