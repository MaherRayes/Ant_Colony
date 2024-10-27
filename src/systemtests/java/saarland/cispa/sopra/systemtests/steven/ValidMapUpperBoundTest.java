package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class ValidMapUpperBoundTest extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		StringBuilder map = new StringBuilder(16700);
		map.append("128\n128\nA");
		for(int x= 1; x<128; x++) {
			map.append('.');
		}
		map.append('\n');
		for(int y = 1; y< 127; y++) {
			for(int x = 0; x< 128; x++) {
				map.append('.');
			}
			map.append('\n');
		}
		for(int x= 0; x<127; x++) {
			map.append('.');
		}
		map.append('B');
		final String finalMap = map.toString();
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
		WorldInfo world =gameInfo.simulate(1, 42, finalMap, brain, brain);

		if(world == null) {
			fail("Did not create the game in the valid 128x128 map bounds!");
		}
	}

}
