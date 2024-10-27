package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class FaultyMapSwarmStartB extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map1 = "2\n2\n"
				+ "BC\n"
				+ "..";
		String brain = "brain \"mark\" {\nturn left\njump 0\n}";


		expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map1, brain, brain));

	}

}
