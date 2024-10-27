package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyBrainNamesListed extends FaultyBrainNamesBase{
	private enum IllegalWords {
	    brain, left, right
	}

	@Override
	protected void test(GameInfo gameInfo) {
		for(IllegalWords w : IllegalWords.values()) {
			this.testBrainName(gameInfo, w.toString());
		}
	}

}
