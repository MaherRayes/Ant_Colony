package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersUnset extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		this.testCommand(gameInfo, "unset");
		this.testCommand(gameInfo, "unset ");
		this.testCommand(gameInfo, "unset -1");
		this.testCommand(gameInfo, "unset 6");
	}
}
