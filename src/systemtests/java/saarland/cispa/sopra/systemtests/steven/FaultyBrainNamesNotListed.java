package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;



public class FaultyBrainNamesNotListed extends FaultyBrainNamesBase{
	private enum IllegalWords {
	    ahead, here, friend, foe,food,
	    rock, home, foehome, marker,
	    northeast, east, northwest, southeast, southwest,
	    west
	}

	@Override
	protected void test(GameInfo gameInfo) {
		for(IllegalWords w : IllegalWords.values()) {
			this.testBrainName(gameInfo, w.toString());
		}
	}

}
