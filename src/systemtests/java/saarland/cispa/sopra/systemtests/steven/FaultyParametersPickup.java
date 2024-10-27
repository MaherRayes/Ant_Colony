package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersPickup extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		testCommand(gameInfo, "pickup");
		testCommand(gameInfo, "pickup ");
		testCommand(gameInfo, "pickup else");
		testCommand(gameInfo, "pickup else -1");
		testCommand(gameInfo, "pickup else 10");

	}
}
