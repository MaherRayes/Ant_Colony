package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;


public class FaultyBrainNamesTest extends FaultyBrainNamesBase{
	private enum IllegalWords {
	    move, mark, unmark, set,
	    unset, test, turn, sense,
	    pickup, drop, flip, jump,
	    direction
	}

	@Override
	protected void test(GameInfo gameInfo) {
		for(IllegalWords w : IllegalWords.values()) {
			this.testBrainName(gameInfo, w.toString());
		}
	}

}
