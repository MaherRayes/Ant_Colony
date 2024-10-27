package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersMark extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		testCommand(gameInfo, "mark");
		testCommand(gameInfo, "mark ");
		testCommand(gameInfo, "mark -1");
		testCommand(gameInfo, "mark 7");
	}
}
