package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseHere extends SystemTest{
	private void testSenseHere(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            "A1\n" +
	            "B.";
		String brainA = "brain \"sample\" {\nmark 0\nsense here friend else 13\njump 4\nset 0\n" //0-3
										+ "sense here foe else 6\nset 0\n" //4-5
										+ "sense here foehome else 8\nset 0\n" //6-7
										+ "sense here marker 0 else 13\n" //8
										+ "sense here food else 11\nset 0\n" //9-10
										+ "sense here home else 13\n"// 11
										+ "jump 14\nset 0\n"//12-13
										+ "jump 14\n}";//14
		String brainB = "brain \"sample\" {\njump 0\n}";//15
		WorldInfo world = gameInfo.simulate(21, 42, map, brainA, brainB);
		if(world.getAnt(0).getRegister()[0]) {
			fail("Ant is not able to sense here!");
		}
	}
	@Override
	public void test(GameInfo gameInfo) {
		testSenseHere(gameInfo);
	}

}
