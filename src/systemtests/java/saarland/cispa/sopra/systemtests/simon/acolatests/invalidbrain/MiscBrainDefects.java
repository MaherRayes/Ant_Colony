package saarland.cispa.sopra.systemtests.simon.acolatests.invalidbrain;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MiscBrainDefects extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();

        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("sense 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("mark left", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("unmark ant0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("set testo", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("set right", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("set ahead", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("unset set", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("test 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("turn 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("turn left else 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("sense foe else 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("sense ahead else 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("sense ahead marker else 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("sense here marker 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("sense here rock 0 else 0", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("pickup", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("drop", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("flip 100", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("flip left 1", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("direction east", "jump 0"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("mark 1"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("brain \"a\" { \njump 0\n}"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("\"a\" { \njump 0\n}"), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, map, createNewBrain("brai \"a\" { \njump 0\n}"), trivialBrain()));

    }
}
