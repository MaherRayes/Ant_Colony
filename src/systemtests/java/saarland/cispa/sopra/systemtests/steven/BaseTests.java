package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
public class BaseTests extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map1 = "2\n4\n"
				+ "A.\n"
				+ "..\n"
				+ "..\n"
				+ ".B";
		String map2 = "4\n2\n"
				+ "A...\n"
				+ "...B";
		String brain = "brain \"mark\" {\nturn left\njump 0\n}";


		try {
			gameInfo.simulate(1, 42, map1, brain, brain);
			gameInfo.simulate(1, 42, map2, brain, brain);
			//gameInfo.simulate(1, 42, map3, brain, brain);
			//gameInfo.simulate(1, 42, map4, brain, brain);
		}catch(IllegalArgumentException e) {
			fail("A Valid base has been rejected!");
		}

	}

}
