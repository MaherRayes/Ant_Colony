package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class FaultyBaseOrderTest extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "4\n4\n"
				+ "B..."
				+ "...."
				+ "...."
				+ "...A";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));

	}

}