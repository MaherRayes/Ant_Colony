package saarland.cispa.sopra.systemtests;

import java.util.NoSuchElementException;

public class SampleTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\nturn left\njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);

        // Diesen Snapshot kann man nun auf Fehler testen
        String dir0 = world.getAnt(0).getDirection();
        if (!"west".equals(dir0)) {
            fail(String.format("Ant 0 faces %s instead of west!", dir0));
        }
        String dir1 = world.getAnt(1).getDirection();
        if (!"west".equals(dir1)) {
            fail(String.format("Ant 1 faces %s instead of west!", dir1));
        }
        expect(NoSuchElementException.class, () -> world.getAnt(42));
    }
}
