package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class BreedInFightTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        String map1 =
                "4\n" +
                "4\n" +
                "#BB#\n" +
                "B.11\n" +
                "ABBA\n" +
                "###C\n";
        String brainA1 =
            "brain \"breedInFight\"{\n" +
                "move else 6\n" +
                "pickup else 6\n" +
                "turn right\n" +
                "turn right\n" +
                "breed else 6\n" +
                "jump 5\n" +
                "jump 6\n" +
                "}";
        String brainB1 = getUselessBrain();
        String brainC1 = getBrainMove();
        WorldInfo world1 = gameInfo.simulate(100, 986, map1, brainA1, brainB1, brainC1);
        expect(NoSuchElementException.class, () -> world1.getAnt(8));
        assertTrue("Futter wurde nicht richtig fallengelassen", 3 == world1.getFieldAt(1, 1).getFood());

        //Gebrütete tötet
        String map2 =
            "6\n" +
                "4\n" +
                "##A###\n" +
                "#AB.##\n" +
                "##AA11\n" +
                "###AAA\n";
        String brainA2 =
            "brain \"breedFighter\"{\n" +
                "move else 6\n" +
                "pickup else 6\n" +
                "turn right\n" +
                "turn right\n" +
                "breed else 6\n" +
                "jump 5\n" +    //Brüter Ameise
                "jump 6\n" +  //Nixmacher Ameisen
                "}";
        String brainB2 = getUselessBrain();
        WorldInfo world = gameInfo.simulate(100, 13, map2, brainA2, brainB2);
        expect(NoSuchElementException.class, () -> world.getAnt(2));
        world.getAnt(8);
    }
}
