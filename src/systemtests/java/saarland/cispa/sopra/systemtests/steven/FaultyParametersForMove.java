package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersForMove extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		this.testCommand(gameInfo, "move");
		this.testCommand(gameInfo, "move ");
		this.testCommand(gameInfo, "move -1");
		this.testCommand(gameInfo, "move else 2");
		this.testCommand(gameInfo, "move else");
		this.testCommand(gameInfo, "move else ");
		this.testCommand(gameInfo, "move else -1");
	}
}
