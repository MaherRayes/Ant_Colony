package saarland.cispa.sopra.systemtests.giuliano.register;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public abstract class RegisterTest extends BaseTest {

    private int rounds = 1;

    public WorldInfo getWorld(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(4, 4);
        builder.set(0,0,'#');
        builder.set(0, 1, 'A').set(1, 1, 'A');
        builder.set(1, 2, 'B').set(2, 2, 'B');
        return gameInfo.simulate(rounds, 0, builder.export(), getBrainA(), getBrainB());
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public abstract String getBrainA();

    public abstract String getBrainB();
}
