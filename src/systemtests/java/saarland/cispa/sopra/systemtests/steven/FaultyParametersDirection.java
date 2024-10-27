package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersDirection extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		testCommand(gameInfo, "direction");
		testCommand(gameInfo, "direction ");
		testCommand(gameInfo, "direction -1");
		testCommand(gameInfo, "direction 10");
		testCommand(gameInfo, "direction north");
		testCommand(gameInfo, "direction south");
		testCommand(gameInfo, "direction east");
		testCommand(gameInfo, "direction east else");
		testCommand(gameInfo, "direction east else -1");
		testCommand(gameInfo, "direction east else 10");
		testCommand(gameInfo, "direction south else 0");
		testCommand(gameInfo, "direction north else 0");
	}
}
