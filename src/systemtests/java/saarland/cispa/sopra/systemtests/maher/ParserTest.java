package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class ParserTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "4\n4\n"+
            "AAA.\n"+
            "B...\n" +
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\n /*/*/ turn left\njump 0\n}";

        gameInfo.simulate(1,42,map,brain,brain);

    }
}
