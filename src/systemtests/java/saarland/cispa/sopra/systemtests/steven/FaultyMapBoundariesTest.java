package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class FaultyMapBoundariesTest extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		map129Test(gameInfo);
		baseSplitTest(gameInfo);
		fiveTest(gameInfo);
		negativeTest(gameInfo);
		oneTest(gameInfo);
		sizeTooLarge(gameInfo);
		threeTest(gameInfo);
		zeroTest(gameInfo);
	}
	protected void zeroTest(GameInfo gameInfo) {
		String map = "0\n0\n";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));

	}
	protected void threeTest(GameInfo gameInfo) {
		String map = "3\n3\n" +
	            ".A.\n" +
	            ".B."
	            +"...";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));

	}
	protected void sizeTooLarge(GameInfo gameInfo) {
		String map = "4\n4\n"
				+ "A..."
				+ "...."
				+ "...B"
				+ "...."
				+ "....";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));

	}
	protected void oneTest(GameInfo gameInfo) {
		String map = "1\n1\n" +
	            	 "A";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));

	}
	protected void negativeTest(GameInfo gameInfo) {
		String map = "-1\n-1\n" +
	            ".A\n" +
	            "B.";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));

	}
	protected void fiveTest(GameInfo gameInfo) {
		String map = "5\n5\n" +
	            "....A\n" +
	            "B...."+
	            "....."+
	            "....."+
	            ".....";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));

	}
	protected void baseSplitTest(GameInfo gameInfo) {
		String map = "4\n4\n"
				+ "A..."
				+ "...."
				+ ".A.."
				+ "B..B";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));

	}
	protected void map129Test(GameInfo gameInfo) {
		StringBuilder map = new StringBuilder(16700);
		map.append("129\n129\nAB");

		for(int x= 2; x<129; x++) {
			map.append('.');
		}
		map.append('\n');
		for(int y = 1; y< 128; y++) {
			for(int x = 0; x< 129; x++) {
				map.append('.');
			}
			map.append('\n');
		}
		for(int x= 0; x<129; x++) {
			map.append('.');
		}
		//map.append('B');

		final String finalMap = map.toString();
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, finalMap, brain, brain));

	}
}
