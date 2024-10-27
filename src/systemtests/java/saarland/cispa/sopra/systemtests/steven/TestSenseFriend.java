package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class TestSenseFriend extends SystemTest{
	private void testFriend(GameInfo gameInfo) {
		String mapRight = "2\n2\n" +
	            ".A\n" +
	            "AB";
		String mapAhead = "2\n2\n" +
	            "A.\n" +
	            "AB";
		String mapLeft = "2\n2\n" +
	            "AA\n" +
	            ".B";
		String brainB = "brain \"sample\" {\njump 0\n}";
	        String brainARight = "brain \"sample\" {\n"
	        			  + "sense right friend else 5\n"//0
	        			  + "sense ahead friend else 3\n"//1
	        			  + "set 1\n"//2
	        			  + "sense left friend else 6\n"//3
	        			  + "set 2\nset 3\n"//4-5
	        			  + "jump 6\n}"; //6
	        String brainAAhead = "brain \"sample\" {\n"
      			  + "sense ahead friend else 5\n"//0
      			  + "sense left friend else 3\n"//1
      			  + "set 1\n"//2
      			  + "sense right friend else 6\n"//3
      			  + "set 2\nset 3\n"//4-5
      			  + "jump 6\n}"; //6
	        String brainALeft = "brain \"sample\" {\n"
	      			  + "sense left friend else 5\n"//0
	      			  + "sense ahead friend else 3\n"//1
	      			  + "set 1\n"//2
	      			  + "sense right friend else 6\n"//3
	      			  + "set 2\nset 3\n"//4-5
	      			  + "jump 6\n}"; //6
	        WorldInfo worldRight = gameInfo.simulate(21, 42, mapRight, brainARight, brainB);
	        WorldInfo worldAhead = gameInfo.simulate(21, 42, mapAhead, brainAAhead, brainB);
	        WorldInfo worldLeft = gameInfo.simulate(21, 42, mapLeft, brainALeft, brainB);
	        if(worldRight.getAnt(1).getRegister()[0]||worldRight.getAnt(1).getRegister()[1]||
	        		worldRight.getAnt(1).getRegister()[2]||worldRight.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	        if(worldLeft.getAnt(1).getRegister()[0]||worldRight.getAnt(1).getRegister()[1]||
	        		worldRight.getAnt(1).getRegister()[2]||worldRight.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	        if(worldAhead.getAnt(1).getRegister()[0]||worldRight.getAnt(1).getRegister()[1]||
	        		worldRight.getAnt(1).getRegister()[2]||worldRight.getAnt(1).getRegister()[3]) {
	        	fail("sense friend does not work for ant 1!");
	        }
	}

	@Override
	protected void test(GameInfo gameInfo) {
		testFriend(gameInfo);

	}

}
