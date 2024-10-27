package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class BrainName2SymbolsTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AB\n" +
            "..";
        String brain = "brain \"s\" {\nturn right\njump 0\n}";
       expect(IllegalArgumentException.class, () -> gameInfo.simulate(0, 42, map, brain, brain));
    }
}
