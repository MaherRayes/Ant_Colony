package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class BrainTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = getCheapMap();
		String brain1 =	//Kein Jumpbefehl am Ende
				"brain \"NoJump\"{\n"
				+ "jump 1\n"
				+ "jump 0\n"
				+ "move else 0\n"
				+ "}";
		String brain2 = //Schreibfehler
				"brajn \"gEnIe\"{\n"
				+ "jump 0\n"
				+ "}";
		String brain3 = //Befehl falsch geschrieben
				"brain \"Dumbo\"{\n"
				+ "jump 1\n"
				+ "Jump 0\n"
				+ "}";
		String brain4 = //Zu großer else Fall
				"brain \"Weitblicker\"{\n"
				+ "jump 1\n"
				+ "move else 3\n"
				+ "jump 1\n"
				+ "}";
		String brain5 =  //Kein Zeilenumbruch
			"brain \"Lueckie\"{\n"
			+ "jump 1 "
			+ "jump 0\n"
			+ "}";
		String brain6 = //Kein Leerzeichen
				"brain \"Kleber\"{\n"
				+ "jump0\n"
				+ "}";
		String brain7 = //Klammer vergessen
				"brain \"Klammerlos\"\n"
				+ "jump 0\n"
				+ "}";
		String brain8 = //Andere Klammer vergessen
				"brain \"Klammerhater\"{\n"
				+ "jump 0\n";
		String brain9 = //Schlüsselwort als Name
				"brain \"brain\"{\n"
				+ "jump 0\n"
				+ "}";
		String brain10 = //bei direction kein/falsches Schlüsselwort
				"brain \"Gucker\"{\n"
				+ "turn northwest\n"
				+ "jump 1\n"
				+ "}";

		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain1, brain1));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain3, brain3));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain5, brain5));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain7, brain7));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain9, brain9));

		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain2, brain2));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain4, brain4));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain6, brain6));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain8, brain8));
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(0, 42, map, brain10, brain10));

	}

}
