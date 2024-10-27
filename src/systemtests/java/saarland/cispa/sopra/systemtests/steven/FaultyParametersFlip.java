package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersFlip extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		testCommand(gameInfo, "flip");
		testCommand(gameInfo, "flip ");
		testCommand(gameInfo, "flip else");
		testCommand(gameInfo, "flip else -1");
		testCommand(gameInfo, "flip else 10");
		testCommand(gameInfo, "flip 3 else 10");
		testCommand(gameInfo, "flip -1 else 0");
	}
}
