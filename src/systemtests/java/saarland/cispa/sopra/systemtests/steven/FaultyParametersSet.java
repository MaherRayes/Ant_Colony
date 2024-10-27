package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersSet extends FaultyParametersBase {
	@Override
	protected void test(GameInfo gameInfo) {
		this.testCommand(gameInfo, "set");
		this.testCommand(gameInfo, "set ");
		this.testCommand(gameInfo, "set 6");
		this.testCommand(gameInfo, "set -1");
	}
}
