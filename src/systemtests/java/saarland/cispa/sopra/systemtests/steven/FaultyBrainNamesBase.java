package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;


public abstract class FaultyBrainNamesBase extends SystemTest{
	protected void testBrainName(GameInfo gameInfo, String w) {
		String map = "2\n2\n"
				+ "B."
				+ ".A";
			String brain = "brain \""+w+"\" {\nturn left\njump 0\n}";
	        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));
	}

}
