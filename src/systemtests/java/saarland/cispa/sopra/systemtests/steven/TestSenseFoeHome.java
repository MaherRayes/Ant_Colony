package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseFoeHome extends SystemTest{

	private void testFoeHome(GameInfo gameInfo) {
		String mapRightFoeHome = "2\n2\n" +
	            ".A\n" +
	            "B.";
		String mapAheadFoeHome = "2\n2\n" +
	            ".A\n" +
	            ".B";
		String mapLeftFoeHome = "2\n2\n" +
	            "AB\n" +
	            "..";
		String brainAFoeHome = "brain \"sample\" {\njump 0\n}";
	        String brainBRightFoeHome = "brain \"sample\" {\n"
	        			  + "sense right foehome else 5\n"//0
	        			  + "sense ahead foehome else 3\n"//1
	        			  + "set 1\n"//2
	        			  + "sense left foehome else 6\n"//3
	        			  + "set 2\nset 3\n"//4-5
	        			  + "jump 6\n}"; //6
	        String brainBAheadFoeHome = "brain \"sample\" {\n"
      			  + "sense ahead foehome else 5\n"//0
      			  + "sense left foehome else 3\n"//1
      			  + "set 1\n"//2
      			  + "sense right foehome else 6\n"//3
      			  + "set 2\nset 3\n"//4-5
      			  + "jump 6\n}"; //6
	        String brainBLeftFoeHome = "brain \"sample\" {\n"
	      			  + "sense left foehome else 5\n"//0
	      			  + "sense ahead foehome else 3\n"//1
	      			  + "set 1\n"//2
	      			  + "sense right foehome else 6\n"//3
	      			  + "set 2\nset 3\n"//4-5
	      			  + "jump 6\n}"; //6
	        WorldInfo worldRightFoeHome = gameInfo.simulate(21, 42, mapRightFoeHome, brainAFoeHome, brainBRightFoeHome);
	        WorldInfo worldAheadFoeHome = gameInfo.simulate(21, 42, mapAheadFoeHome, brainAFoeHome, brainBAheadFoeHome);
	        WorldInfo worldLeftFoeHome = gameInfo.simulate(21, 42, mapLeftFoeHome, brainAFoeHome, brainBLeftFoeHome);
	        if(worldRightFoeHome.getAnt(1).getRegister()[0]||worldRightFoeHome.getAnt(1).getRegister()[1]||
	        		worldRightFoeHome.getAnt(1).getRegister()[2]||worldRightFoeHome.getAnt(1).getRegister()[3]) {
	        	fail("sense foehome does not work for ant 1!");
	        }
	        if(worldLeftFoeHome.getAnt(1).getRegister()[0]||worldRightFoeHome.getAnt(1).getRegister()[1]||
	        		worldRightFoeHome.getAnt(1).getRegister()[2]||worldRightFoeHome.getAnt(1).getRegister()[3]) {
	        	fail("sense foehome does not work for ant 1!");
	        }
	        if(worldAheadFoeHome.getAnt(1).getRegister()[0]||worldRightFoeHome.getAnt(1).getRegister()[1]||
	        		worldRightFoeHome.getAnt(1).getRegister()[2]||worldRightFoeHome.getAnt(1).getRegister()[3]) {
	        	fail("sense foehome does not work for ant 1!");
	        }
	}

	@Override
	protected void test(GameInfo gameInfo) {
		testFoeHome(gameInfo);

	}

}
