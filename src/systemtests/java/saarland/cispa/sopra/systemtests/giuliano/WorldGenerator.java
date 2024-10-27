package saarland.cispa.sopra.systemtests.giuliano;

import saarland.cispa.sopra.systemtests.WorldInfo;

public interface WorldGenerator {
    WorldInfo run(int turns);
}
