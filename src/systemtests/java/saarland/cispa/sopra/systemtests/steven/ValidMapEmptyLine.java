package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class ValidMapEmptyLine extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "4\n4\n"
				+ "A...\n"
				+ "....\n"
				+ "....\n"
				+ "B...\n";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        WorldInfo worldInfo = gameInfo.simulate(1, 42, map, brain, brain);
        if(worldInfo == null) {
        	fail("Empty line after the map is not allowed!");
        }
	}
}
