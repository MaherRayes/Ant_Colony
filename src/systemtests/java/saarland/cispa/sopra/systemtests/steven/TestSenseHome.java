package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseHome extends SystemTest{
	private void testHome(GameInfo gameInfo) {
		String mapRightHome = "2\n2\n" +
	            ".A\n" +
	            "AB";
		String mapAheadHome = "2\n2\n" +
	            "A.\n" +
	            "AB";
		String mapLeftHome = "2\n2\n" +
	            "AA\n" +
	            ".B";
		String brainBHome = "brain \"sample\" {\njump 0\n}";
	        String brainARightHome = "brain \"sample\" {\n"
	        			  + "sense right home else 5\n"//0
	        			  + "sense ahead home else 3\n"//1
	        			  + "set 1\n"//2
	        			  + "sense left home else 6\n"//3
	        			  + "set 2\nset 3\n"//4-5
	        			  + "jump 6\n}"; //6
	        String brainAAheadHome = "brain \"sample\" {\n"
      			  + "sense ahead home else 5\n"//0
      			  + "sense left home else 3\n"//1
      			  + "set 1\n"//2
      			  + "sense right home else 6\n"//3
      			  + "set 2\nset 3\n"//4-5
      			  + "jump 6\n}"; //6
	        String brainALeftHome = "brain \"sample\" {\n"
	      			  + "sense left home else 5\n"//0
	      			  + "sense ahead home else 3\n"//1
	      			  + "set 1\n"//2
	      			  + "sense right home else 6\n"//3
	      			  + "set 2\nset 3\n"//4-5
	      			  + "jump 6\n}"; //6
	        WorldInfo worldRightHome = gameInfo.simulate(21, 42, mapRightHome, brainARightHome, brainBHome);
	        WorldInfo worldAheadHome = gameInfo.simulate(21, 42, mapAheadHome, brainAAheadHome, brainBHome);
	        WorldInfo worldLeftHome = gameInfo.simulate(21, 42, mapLeftHome, brainALeftHome, brainBHome);
	        if(worldRightHome.getAnt(1).getRegister()[0]||worldRightHome.getAnt(1).getRegister()[1]||
	        		worldRightHome.getAnt(1).getRegister()[2]||worldRightHome.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	        if(worldLeftHome.getAnt(1).getRegister()[0]||worldRightHome.getAnt(1).getRegister()[1]||
	        		worldRightHome.getAnt(1).getRegister()[2]||worldRightHome.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	        if(worldAheadHome.getAnt(1).getRegister()[0]||worldRightHome.getAnt(1).getRegister()[1]||
	        		worldRightHome.getAnt(1).getRegister()[2]||worldRightHome.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	}

	@Override
	protected void test(GameInfo gameInfo) {
		testHome(gameInfo);

	}

}
