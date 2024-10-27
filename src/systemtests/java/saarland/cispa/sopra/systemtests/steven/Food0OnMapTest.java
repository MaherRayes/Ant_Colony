package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class Food0OnMapTest extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String mapNoFood = "2\n2\n"
				+ "A.\n"
				+ "0B";
		String brainNoFood = "brain \"mark\" {\nturn left\njump 0\n}";
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(1, 42, mapNoFood, brainNoFood, brainNoFood));

	}

}
