package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class KartenTest1 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String brain  = getUselessBrain();
		String map1 = //Höhe vergessen
				"2\n"
				+ "A.\n"
				+ "B.";
		String map2 = //Höhe falsch
				"2\n"
				+ "2\n"
				+ "AA\n"
				+ "B.\n"
				+ "..\n"
				+ "..\n";
		String map3 = //Höhe und Breite verwechselt
				"2\n"
				+ "4\n"
				+ "A...\n"
				+ "..B.\n";
		String map4 = //Zwischenbuchstabe fehlt
				"2\n"
				+ "2\n"
				+ "BA\n"
				+ "DE\n";
		String map5 =	//Erste Basis ist nicht A
				"2\n"
				+ "2\n"
				+ "B.\n"
				+ "C.\n";
		String map6 = //Falsche Breite
				"3\n"
				+ "4\n"
				+ "A..\n"
				+ "B..\n"
				+ "C..\n"
				+ "D..\n";
		String map7 = //Negative Breite
				"-4\n"
				+ "4\n"
				+ "A...\n"
				+ "..B.\n"
				+ "C...\n"
				+ "....\n";
		String map8 = //nur ein Schwarm
				"2\n"
				+ "2\n"
				+ "A.\n"
				+ "AA\n";
		String map9 = //1*1
				"1\n"
				+ "1\n"
				+ "A";
		String map10 = //0x0
				"0\n"
				+ "0\n";
		String map11 = //Leerzeichen drin
				"2\n"
				+ "2\n"
				+ ". A\n"
				+ ".B\n";
		String map12 = //Null essen
			"2\n"
			+ "2\n"
			+ "0A\n"
			+ ".B\n";
		String map13 = //kleinbuchstabe
			"2\n"
			+ "2\n"
			+ "Aa\n"
			+ "B.\n";
		String map14 =
				"2\n"
				+ "2\n"
				+ "A.\n"
				+ "b.\n";



		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(0, 123, map1, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(1, 4235, map2, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(2, -456, map3, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(3, 7, map4, brain, brain, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(4, -3462, map5, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(5, -2134, map6, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(6, 7462, map7, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map8, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map9, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map10, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map11, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map12, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map13, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map14, brain, brain));


	}

}
