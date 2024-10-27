package saarland.cispa.sopra.systemtests.simon.acolatests.invalidbrain;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class BrainInvalidNames extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();

        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("turn", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("sense", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("left", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("right", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("mark", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("unmark", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("set", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("test", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("ahead", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("here", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("friend", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("foehome", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("marker", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("flip", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("jump", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrainWithName("direction", "jump 0"), trivialBrain()));

    }
}
