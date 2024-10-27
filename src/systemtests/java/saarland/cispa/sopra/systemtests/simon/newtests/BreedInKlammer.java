package saarland.cispa.sopra.systemtests.simon.newtests;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.BaseTest;

public class BreedInKlammer extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        simulate(10, 42, "4\n4\nAAAA\nABBA\nAAAA\nAAAA", trivialBrain(), createNewBrain("breed else 1", "jump 1"));

        if (getWorldInfo().getFieldAt(1, 1).getAnt().isPresent() || getWorldInfo().getFieldAt(2, 1).getAnt().isPresent()) {
            fail("Ant didnt die");
        }

    }
}
