package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class NegativeField extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "-4\n-4\n";
        String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück

        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, brain, brain));
    }
}