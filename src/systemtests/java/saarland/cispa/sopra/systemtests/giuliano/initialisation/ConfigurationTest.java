package saarland.cispa.sopra.systemtests.giuliano.initialisation;

import saarland.cispa.sopra.systemtests.WorldInfo;

public class ConfigurationTest extends InitialisationTest {
    @Override
    public void run(WorldInfo world) {
        if(world.getHeight() <= 0 || world.getWidth() <= 0 || world.getHeight() % 2 != 0 || world.getWidth() % 2 != 0) {
            fail(String.format("The values of height (%d) and width (%d) must be positive and even.", world.getHeight(), world.getWidth()));
        }
        if(world.getScore('A') != 0 || world.getScore('B') != 0) {
            fail("The score of swarms bust be 0 initially.");
        }
    }
}
