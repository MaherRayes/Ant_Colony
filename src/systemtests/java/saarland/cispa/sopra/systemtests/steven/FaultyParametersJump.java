package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersJump extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		testCommand(gameInfo, "jump");
		testCommand(gameInfo, "jump ");
		testCommand(gameInfo, "jump -1");
		testCommand(gameInfo, "jump 10");
		testCommand(gameInfo, "jump 0 else 0");
	}
}
