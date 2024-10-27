package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseNothing extends SystemTest{
	private void testNothing(GameInfo gameInfo) {
		String map = "4\n4\n" +
	            "....\n" +
	            ".A..\n"
	          + "....\n"
	          + "...B";
		String brainA = "brain \"sample\" {\nturn left\njump 0\n}";
	    String brainBFoe = "brain \"sample\" {\nsense right foe else 2\nset 0\n"
	        				+ "sense ahead foe else 4\nset 0\n"
	        				+ "sense left foe else 6\nset 0\n"
	        				+ "jump 6\n}"; //6
	    String brainBFriend = "brain \"sample\" {\nsense right friend else 2\nset 0\n"
				+ "sense ahead friend else 4\nset 0\n"
				+ "sense left friend else 6\nset 0\n"
				+ "jump 6\n}"; //6
	    String brainBHome = "brain \"sample\" {\nsense right home else 2\nset 0\n"
				+ "sense ahead home else 4\nset 0\n"
				+ "sense left home else 6\nset 0\n"
				+ "jump 6\n}"; //6
	    String brainBFoeHome = "brain \"sample\" {\nsense right foehome else 2\nset 0\n"
				+ "sense ahead foehome else 4\nset 0\n"
				+ "sense left foehome else 6\nset 0\n"
				+ "jump 6\n}"; //6
	    String brainBRock = "brain \"sample\" {\nsense right rock else 2\nset 0\n"
				+ "sense ahead rock else 4\nset 0\n"
				+ "sense left rock else 6\nset 0\n"
				+ "jump 6\n}"; //6
	    String brainBMarker = "brain \"sample\" {\nsense right marker 0 else 2\nset 0\n"
				+ "sense ahead marker 0 else 4\nset 0\n"
				+ "sense left marker 0 else 6\nset 0\n"
				+ "jump 6\n}"; //6
	    String brainBFood = "brain \"sample\" {\nsense right food else 2\nset 0\n"
				+ "sense ahead food else 4\nset 0\n"
				+ "sense left food else 6\nset 0\n"
				+ "jump 6\n}"; //6

	        WorldInfo worldFoe = gameInfo.simulate(21, 42, map, brainA, brainBFoe);
	        WorldInfo worldFriend = gameInfo.simulate(21, 42, map, brainA, brainBFriend);
	        WorldInfo worldHome = gameInfo.simulate(21, 42, map, brainA, brainBHome);
	        WorldInfo worldFoeHome = gameInfo.simulate(21, 42, map, brainA, brainBFoeHome);
	        WorldInfo worldRock = gameInfo.simulate(21, 42, map, brainA, brainBRock);
	        WorldInfo worldMarker = gameInfo.simulate(21, 42, map, brainA, brainBMarker);
	        WorldInfo worldFood = gameInfo.simulate(21, 42, map, brainA, brainBFood);

	        if(worldMarker.getAnt(1).getRegister()[0]) {
	        	fail("Ant senses Marker on field without!!");
	        }
	        if(worldFoe.getAnt(1).getRegister()[0]) {
	        	fail("Ant senses foe on field without!");
	        }
	        if(worldFriend.getAnt(1).getRegister()[0]) {
	        	fail("Ant senses friend on field without!!");
	        }
	        if(worldHome.getAnt(1).getRegister()[0]) {
	        	fail("Ant senses home on field without!!");
	        }
	        if(worldFoeHome.getAnt(1).getRegister()[0]) {
	        	fail("Ant senses foehome on field without!!");
	        }
	        if(worldRock.getAnt(1).getRegister()[0]) {
	        	fail("Ant senses rock on field without!!");
	        }
	        if(worldFood.getAnt(1).getRegister()[0]) {
	        	fail("Ant senses food on field without!!");
	        }
	}

	@Override
	protected void test(GameInfo gameInfo) {
		testNothing(gameInfo);

	}

}
