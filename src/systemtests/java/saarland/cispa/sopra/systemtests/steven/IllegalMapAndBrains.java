package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class IllegalMapAndBrains extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map1 = "2\n2\n"
				+ "AB\n"
				+ "D.\n";
		String map2 = "2\n2\n"
				+ "AB\n"
				+ "C.\n";
		String map3 = "2\n2\n"
				+ "AB\n"
				+ "..\n";
		String map4 = "2\n2\n"
				+ "A.\n"
				+ "..\n";
		String brain = "brain \"mark\" {\nturn left\njump 0\n}";
		expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map1, brain, brain, brain));
		expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map2, brain, brain, brain, brain));
		expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map3, brain, brain, brain));
		expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map4, brain));
	}

}
