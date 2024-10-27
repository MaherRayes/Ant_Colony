package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class NoInstructionDuringRestTime extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map = "2\n2\n" +
	            "..\n" +
	            "AB";
	        String brainB = "brain \"sample\" {\nmove else 0\nturn left\njump 0\n}";
	        String brainA = "brain \"sample\" {\nturn left\njump 0\n}";
	        WorldInfo world2 = gameInfo.simulate(2, 42, map, brainA, brainB);
	        WorldInfo world10 =gameInfo.simulate(10, 42, map, brainA, brainB);
	        WorldInfo world14 =gameInfo.simulate(14, 42, map, brainA, brainB);
	        if(!"northwest".equals(world2.getAnt(1).getDirection())) {
	        	fail("An instruction has been done during rest time!");
	        }
	        if(!"northwest".equals(world10.getAnt(1).getDirection())) {
	        	fail("An instruction has been done during rest time!");
	        }
	        if(!"northwest".equals(world14.getAnt(1).getDirection())) {
	        	fail("An instruction has been done during rest time!");
	        }
	        WorldInfo world15 = gameInfo.simulate(15, 42, map, brainA, brainB);
	        if("northwest".equals(world15.getAnt(1).getDirection())) {
	        	fail("Rest time is too long!");
	        }

    }
}

