package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class KartenTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String brain  = getUselessBrain();
		String map15 = "";//Leerer String
		String map16 = "ewr2";//Zufällige Buchstaben
		String map17 = //3x3
			"3\n"
			+ "3\n"
			+ "A.A\n"
			+ "B..\n";
		String map18 = //Falsche Höhe
				"2\n"
				+ "3\n"
				+ "A.\n"
				+ ".B\n"
				+ "..\n";
		String map19 = //Negative Höhe
				"2\n"
				+ "-2\n"
				+ "A.\n"
				+ ".B\n";
		String map20 = //Nicht zusammenhängende Basen
				"4\n"
				+ "4\n"
				+ "..AA\n"
				+ "....\n"
				+ "A...\n"
				+ "...B\n";
		String map21 =  //Zwei Zeilenumbrüche am Ende
            "2\n" +
                "2\n" +
                "AB\n" +
                "..\n" +
                "\n";
		String map22 =  //Leerzeichen am Ende nach Zeilenumbruch
            "2\n" +
                "2\n" +
                "AB\n" +
                "..\n" +
                " ";
		String map23 =  //Punkt nach letztem Zeilenumbruch
            "2\n" +
                "2\n" +
                "AB\n" +
                "..\n" +
                ".";
		String map24 =  //Whitespace am Ende
            "2\n" +
                "2\n" +
                "AB\n" +
                ".. ";
		String map25 =  //Whitespace in Karte
            "2\n" +
                "2\n" +
                ". .\n" +
                "AB\n";
		String map26 =  //Whitespace am Ende der Line
            "2\n" +
                "2\n" +
                ".. \n" +
                "AB\n";
		String map27 =  //Whitespace am Anfang der Linie
            "2\n" +
                "2\n" +
                " ..\n" +
                "AB";
		String map28 =  //Whitespace am Anfang
            " 2\n" +
                "2\n" +
                "..\n" +
                "AB";
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map15, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map16, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map17, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map18, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map19, brain, brain));
		expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map20, brain, brain));
        expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map21, brain, brain));
        expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map22, brain, brain));
        expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map23, brain, brain));
        expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map24, brain, brain));
        expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map25, brain, brain));
        expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map26, brain, brain));
        expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map27, brain, brain));
        expect (IllegalArgumentException.class, ()-> gameInfo.simulate(7, -123, map28, brain, brain));



    }

}
