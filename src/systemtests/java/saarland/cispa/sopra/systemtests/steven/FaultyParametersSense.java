package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyParametersSense extends FaultyParametersBase{
	@Override
	protected void test(GameInfo gameInfo) {
		testCommand(gameInfo, "sense");
		testCommand(gameInfo, "sense ");
		testCommand(gameInfo, "sense northeast foe else 0");
		testCommand(gameInfo, "sense northwest foe else 0");
		testCommand(gameInfo, "sense north foe else 0");
		testCommand(gameInfo, "sense south foe else 0");
		testCommand(gameInfo, "sense east foe else 0");
		testCommand(gameInfo, "sense west foe else 0");
		testCommand(gameInfo, "sense southeast foe else 0");
		testCommand(gameInfo, "sense southwest foe else 0");
		testCommand(gameInfo, "sense left");
		testCommand(gameInfo, "sense ahead");
		testCommand(gameInfo, "sense right");

		testCommand(gameInfo, "sense left else 0");
		testCommand(gameInfo, "sense left foe else -1");
		testCommand(gameInfo, "sense left foe else");
		testCommand(gameInfo, "sense left marker -1 else 0");
		testCommand(gameInfo, "sense left marker 7 else 0");
		testCommand(gameInfo, "sense left marker 0 else -1");
		testCommand(gameInfo, "sense left marker 0 else 10");


	}
}
