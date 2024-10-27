package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseFood extends SystemTest{
	private void testFood(GameInfo gameInfo) {
		String mapRight = "2\n2\n" +
	            "A1\n" +
	            "B.";
		String mapAhead = "2\n2\n" +
	            "A1\n" +
	            ".B";
		String mapLeft = "2\n2\n" +
	            "A.\n" +
	            "1B";
		String brainA = "brain \"sample\" {\njump 0\n}";
	        String brainBRight = "brain \"sample\" {\n"
	        			  + "sense right food else 5\n"//0
	        			  + "sense ahead food else 3\n"//1
	        			  + "set 1\n"//2
	        			  + "sense left food else 6\n"//3
	        			  + "set 2\nset 3\n"//4-5
	        			  + "jump 6\n}"; //6
	        String brainBAhead = "brain \"sample\" {\n"
      			  + "sense ahead food else 5\n"//0
      			  + "sense left food else 3\n"//1
      			  + "set 1\n"//2
      			  + "sense right food else 6\n"//3
      			  + "set 2\nset 3\n"//4-5
      			  + "jump 6\n}"; //6
	        String brainBLeft = "brain \"sample\" {\n"
	      			  + "sense left food else 5\n"//0
	      			  + "sense ahead food else 3\n"//1
	      			  + "set 1\n"//2
	      			  + "sense right food else 6\n"//3
	      			  + "set 2\nset 3\n"//4-5
	      			  + "jump 6\n}"; //6
	        WorldInfo worldRight = gameInfo.simulate(21, 42, mapRight, brainA, brainBRight);
	        WorldInfo worldAhead = gameInfo.simulate(21, 42, mapAhead, brainA, brainBAhead);
	        WorldInfo worldLeft = gameInfo.simulate(21, 42, mapLeft, brainA, brainBLeft);
	        if(worldRight.getAnt(1).getRegister()[0]||worldRight.getAnt(1).getRegister()[1]||
	        		worldRight.getAnt(1).getRegister()[2]||worldRight.getAnt(1).getRegister()[3]) {
	        	fail("sense food does not work for ant 1!");
	        }
	        if(worldLeft.getAnt(1).getRegister()[0]||worldRight.getAnt(1).getRegister()[1]||
	        		worldRight.getAnt(1).getRegister()[2]||worldRight.getAnt(1).getRegister()[3]) {
	        	fail("sense food does not work for ant 1!");
	        }
	        if(worldAhead.getAnt(1).getRegister()[0]||worldRight.getAnt(1).getRegister()[1]||
	        		worldRight.getAnt(1).getRegister()[2]||worldRight.getAnt(1).getRegister()[3]) {
	        	fail("sense food does not work for ant 1!");
	        }
	}
	@Override
	public void test(GameInfo gameInfo) {
		testFood(gameInfo);
	}
}
