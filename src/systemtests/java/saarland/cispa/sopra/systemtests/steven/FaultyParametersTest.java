package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersTest extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		this.testCommand(gameInfo, "test else 0");
		this.testCommand(gameInfo, "test 0 ");
		this.testCommand(gameInfo, "test 0 else");
		this.testCommand(gameInfo, "test 0 else -1");
		this.testCommand(gameInfo, "test 0 else 10");
		this.testCommand(gameInfo, "test -1 else 0");
	}
}
