package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseFoe extends SystemTest{
	private void testFoe(GameInfo gameInfo) {
		String mapRightFoe = "2\n2\n" +
	            ".A\n" +
	            "B.";
		String mapAheadFoe = "2\n2\n" +
	            ".A\n" +
	            ".B";
		String mapLeftFoe = "2\n2\n" +
	            "AB\n" +
	            "..";
		String brainAFoe = "brain \"sample\" {\njump 0\n}";
	        String brainBRightFoe = "brain \"sample\" {\n"
	        			  + "sense right foe else 5\n"//0
	        			  + "sense ahead foe else 3\n"//1
	        			  + "set 1\n"//2
	        			  + "sense left foe else 6\n"//3
	        			  + "set 2\nset 3\n"//4-5
	        			  + "jump 6\n}"; //6
	        String brainBAheadFoe = "brain \"sample\" {\n"
      			  + "sense ahead foe else 5\n"//0
      			  + "sense left foe else 3\n"//1
      			  + "set 1\n"//2
      			  + "sense right foe else 6\n"//3
      			  + "set 2\nset 3\n"//4-5
      			  + "jump 6\n}"; //6
	        String brainBLeftFoe = "brain \"sample\" {\n"
	      			  + "sense left foe else 5\n"//0
	      			  + "sense ahead foe else 3\n"//1
	      			  + "set 1\n"//2
	      			  + "sense right foe else 6\n"//3
	      			  + "set 2\nset 3\n"//4-5
	      			  + "jump 6\n}"; //6
	        WorldInfo worldRightFoe = gameInfo.simulate(21, 42, mapRightFoe, brainAFoe, brainBRightFoe);
	        WorldInfo worldAheadFoe = gameInfo.simulate(21, 42, mapAheadFoe, brainAFoe, brainBAheadFoe);
	        WorldInfo worldLeftFoe = gameInfo.simulate(21, 42, mapLeftFoe, brainAFoe, brainBLeftFoe);
	        if(worldRightFoe.getAnt(1).getRegister()[0]||worldRightFoe.getAnt(1).getRegister()[1]||
	        		worldRightFoe.getAnt(1).getRegister()[2]||worldRightFoe.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	        if(worldLeftFoe.getAnt(1).getRegister()[0]||worldRightFoe.getAnt(1).getRegister()[1]||
	        		worldRightFoe.getAnt(1).getRegister()[2]||worldRightFoe.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	        if(worldAheadFoe.getAnt(1).getRegister()[0]||worldRightFoe.getAnt(1).getRegister()[1]||
	        		worldRightFoe.getAnt(1).getRegister()[2]||worldRightFoe.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	}
	@Override
	protected void test(GameInfo gameInfo) {
		testFoe(gameInfo);

	}

}
