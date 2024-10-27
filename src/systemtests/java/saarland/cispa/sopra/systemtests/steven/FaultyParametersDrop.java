package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;

public class FaultyParametersDrop extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		testCommand(gameInfo, "drop");
		testCommand(gameInfo, "drop ");
		testCommand(gameInfo, "drop else");
		testCommand(gameInfo, "drop else -1");
		testCommand(gameInfo, "drop else 10");
	}
}
