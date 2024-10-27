package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class MoveOrderTestAdvanced extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "4\n4\n" +
	            	 "....\n"
	            	+"AB..\n"
	            	+"....\n"
	            	+"....";
		String brainB = "brain \"sample\" {\n"
				+ "turn left\nturn left\nturn left\nturn left\nturn left\nturn left\n" //6
				+ "turn left\nturn left\nturn left\nturn left\nturn left\nturn left\n" //12
				+ "turn left\nturn left\nturn left\nturn left\nturn left\nturn left\n" //18
				+ "turn left\nturn left\nturn left\nturn left\nturn left\nturn left\n" //24
				+ "turn left\nturn left\nturn left\nturn left\nturn left\nturn left\n" //30
				+ "mark 0\nmark 0\nmark 0\nmark 0\n" //34
				+ "move else 0\njump 0\n}";
		String brainA = "brain \"sample\" {\nturn right\nturn right\nturn right\nmove else 9\nturn left\n"//0-4
										+ "move else 9\nturn left\nturn left\nmove else 9\njump 9\n}";//5-9 //move bei 35
		WorldInfo world = gameInfo.simulate(37, 42, map, brainA, brainB);
		if(world.getAnt(0).getField().getX()!=2 || world.getAnt(0).getField().getY()!=2) {
			fail("Ants are not moving in ID order!");
		}

	}

}
