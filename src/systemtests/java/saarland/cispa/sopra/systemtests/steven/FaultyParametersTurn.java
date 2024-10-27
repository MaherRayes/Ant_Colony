package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersTurn extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		testCommand(gameInfo, "turn");
		testCommand(gameInfo, "turn ");
		testCommand(gameInfo, "turn -1");
		testCommand(gameInfo, "turn 1");
		testCommand(gameInfo, "turn ahead");
		testCommand(gameInfo, "turn here");
		testCommand(gameInfo, "turn southeast");
		testCommand(gameInfo, "turn southwest");
		testCommand(gameInfo, "turn east");
		testCommand(gameInfo, "turn west");
		testCommand(gameInfo, "turn northeast");
		testCommand(gameInfo, "turn northwest");
		testCommand(gameInfo, "turn north");
		testCommand(gameInfo, "turn south");
	}
}
