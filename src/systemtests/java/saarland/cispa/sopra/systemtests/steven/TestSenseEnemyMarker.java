package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseEnemyMarker extends SystemTest {




	private void testEnemyMarker(GameInfo gameInfo) {
		String mapRightMarker = "2\n2\n" +
	            ".A\n" +
	            "B.";
		String mapAheadMarker = "2\n2\n" +
	            ".A\n" +
	            ".B";
		String mapLeftMarker = "2\n2\n" +
	            "AB\n" +
	            "..";
		String brainAMarker = "brain \"sample\" {\nmark 0\njump 0\n}";
	        String brainBRightMarker = "brain \"sample\" {\njump 1\n"
	        			  + "sense right marker 0 else 2\n"//0
	        			  + "sense ahead marker 0 else 4\n"//1
	        			  + "set 1\n"//2
	        			  + "sense left marker 0 else 7\n"//3
	        			  + "set 2\nset 3\n"//4-5
	        			  + "jump 7\n}"; //6
	        String brainBAheadMarker = "brain \"sample\" {\njump 1\n"
      			  + "sense ahead marker 0 else 2\n"//0
      			  + "sense left marker 0 else 4\n"//1
      			  + "set 1\n"//2
      			  + "sense right marker 0 else 7\n"//3
      			  + "set 2\nset 3\n"//4-5
      			  + "jump 7\n}"; //6
	        String brainBLeftMarker = "brain \"sample\" {\njump 1\n"
	      			  + "sense left marker 0 else 2\n"//0
	      			  + "sense ahead marker 0 else 4\n"//1
	      			  + "set 1\n"//2
	      			  + "sense right marker 0 else 7\n"//3
	      			  + "set 2\nset 3\n"//4-5
	      			  + "jump 7\n}"; //6
	        WorldInfo worldRightMarker = gameInfo.simulate(21, 42, mapRightMarker, brainAMarker, brainBRightMarker);
	        WorldInfo worldAheadMarker = gameInfo.simulate(21, 42, mapAheadMarker, brainAMarker, brainBAheadMarker);
	        WorldInfo worldLeftMarker = gameInfo.simulate(21, 42, mapLeftMarker, brainAMarker, brainBLeftMarker);
	        if(worldRightMarker.getAnt(1).getRegister()[0]||worldRightMarker.getAnt(1).getRegister()[1]||
	        		worldRightMarker.getAnt(1).getRegister()[2]||worldRightMarker.getAnt(1).getRegister()[3]) {
	        	fail("sense foe marker 1does not work for ant 1!");
	        }
	        if(worldLeftMarker.getAnt(1).getRegister()[0]||worldRightMarker.getAnt(1).getRegister()[1]||
	        		worldRightMarker.getAnt(1).getRegister()[2]||worldRightMarker.getAnt(1).getRegister()[3]) {
	        	fail("sense foe marker 2 does not work for ant 1!");
	        }
	        if(worldAheadMarker.getAnt(1).getRegister()[0]||worldRightMarker.getAnt(1).getRegister()[1]||
	        		worldRightMarker.getAnt(1).getRegister()[2]||worldRightMarker.getAnt(1).getRegister()[3]) {
	        	fail("sense foe marker 3 does not work for ant 1!");
	        }
	}


	@Override
	protected void test(GameInfo gameInfo) {


		testEnemyMarker(gameInfo);

	 }
}

