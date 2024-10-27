package saarland.cispa.sopra.saarmeisen.test.group.fabian;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.Game;
import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreedTest {

    @Test
    public void breedBreakTest() {
        //Testet, ob neu gebrütete Ameise Pause macht
        GameInfo gameInfo = new Game();
        String map =
            "2\n" +
                "4\n" +
                "11\n" +
                "AA\n" +
                ".B\n" +
                "..\n";
        String brainA =
            "brain \"breedIt\"{\n" +
                "move else 5\n" +
                "pickup else 5\n" +
                "turn left\n" +
                "breed else 5\n" +
                "jump 4\n" +    //Erfolg
                "jump 5\n" +    //Kein Erfolg
                "}";
        String brainB =
            "brain \"Useless\"{\n" +
                "jump 0\n" +
                "}";
        WorldInfo world = gameInfo.simulate(17, 2, map, brainA, brainB);
        AntInfo ant3 = world.getAnt(3);
        assertEquals(0, ant3.getPc(), "Neu gebrütete Ameise macht direkt einen Zug, obwphl sie es nicht machen sollte");
    }
}
