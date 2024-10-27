package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersUnmark extends FaultyParametersBase {
	@Override
	protected void test(GameInfo gameInfo) {
		this.testCommand(gameInfo, "unmark");
		this.testCommand(gameInfo, "unmark ");
		this.testCommand(gameInfo, "unmark -1");
		this.testCommand(gameInfo, "unmark 7");
	}
}
