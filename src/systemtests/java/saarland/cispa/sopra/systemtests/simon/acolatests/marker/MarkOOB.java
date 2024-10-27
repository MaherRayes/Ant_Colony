package saarland.cispa.sopra.systemtests.simon.acolatests.marker;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MarkOOB extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();

        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("mark -1", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("unmark -1", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("mark 7", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("unmark 7", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("mark 1000000", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("unmark 1000000", "jump 0"), trivialBrain()));

        // initial direction: northwest
    }
}
