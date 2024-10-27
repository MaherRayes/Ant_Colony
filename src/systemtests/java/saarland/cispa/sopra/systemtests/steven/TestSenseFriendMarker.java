package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseFriendMarker extends SystemTest{
	private void testFriendMarker(GameInfo gameInfo) {
		String mapRightFriendMarker = "2\n2\n" +
	            ".A\n" +
	            "AB";
		String mapAheadFriendMarker = "2\n2\n" +
	            "A.\n" +
	            "AB";
		String mapLeftFriendMarker = "2\n2\n" +
	            "AA\n" +
	            ".B";
		String brainBFriendMarker = "brain \"sample\" {\njump 0\n}";
	        String brainARightFriendMarker = "brain \"sample\" {\nmark 0\n"
	        			  + "sense right marker 0 else 6\n"//0
	        			  + "sense ahead marker 0 else 4\n"//1
	        			  + "set 1\n"//2
	        			  + "sense left marker 0 else 7\n"//3
	        			  + "set 2\nset 3\n"//4-5
	        			  + "jump 7\n}"; //6
	        String brainAAheadFriendMarker = "brain \"sample\" {\nmark 0\n"
      			  + "sense ahead marker 0 else 6\n"//0
      			  + "sense left marker 0 else 4\n"//1
      			  + "set 1\n"//2
      			  + "sense right marker 0 else 7\n"//3
      			  + "set 2\nset 3\n"//4-5
      			  + "jump 7\n}"; //6
	        String brainALeftFriendMarker = "brain \"sample\" {\nmark 0\n"
	      			  + "sense left marker 0 else 6\n"//0
	      			  + "sense ahead marker 0 else 4\n"//1
	      			  + "set 1\n"//2
	      			  + "sense right marker 0 else 7\n"//3
	      			  + "set 2\nset 3\n"//4-5
	      			  + "jump 7\n}"; //6
	        WorldInfo worldRightFriendMarker = gameInfo.simulate(21, 42, mapRightFriendMarker, brainARightFriendMarker, brainBFriendMarker);
	        WorldInfo worldAheadFriendMarker = gameInfo.simulate(21, 42, mapAheadFriendMarker, brainAAheadFriendMarker, brainBFriendMarker);
	        WorldInfo worldLeftFriendMarker = gameInfo.simulate(21, 42, mapLeftFriendMarker, brainALeftFriendMarker, brainBFriendMarker);
	        if(worldRightFriendMarker.getAnt(1).getRegister()[0]||worldRightFriendMarker.getAnt(1).getRegister()[1]||
	        		worldRightFriendMarker.getAnt(1).getRegister()[2]||worldRightFriendMarker.getAnt(1).getRegister()[3]) {
	        	fail("sense friend marker does not work for ant 1!");
	        }
	        if(worldLeftFriendMarker.getAnt(1).getRegister()[0]||worldRightFriendMarker.getAnt(1).getRegister()[1]||
	        		worldRightFriendMarker.getAnt(1).getRegister()[2]||worldRightFriendMarker.getAnt(1).getRegister()[3]) {
	        	fail("sense friend marker 2 does not work for ant 1!");
	        }
	        if(worldAheadFriendMarker.getAnt(1).getRegister()[0]||worldRightFriendMarker.getAnt(1).getRegister()[1]||
	        		worldRightFriendMarker.getAnt(1).getRegister()[2]||worldRightFriendMarker.getAnt(1).getRegister()[3]) {
	        	fail("sense friend marker 3 does not work for ant 1!");
	        }
	}
	@Override
	protected void test(GameInfo gameInfo) {
		testFriendMarker(gameInfo);
	}

}
