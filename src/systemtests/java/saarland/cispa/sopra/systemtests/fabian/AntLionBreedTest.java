package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.FieldInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class AntLionBreedTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        //Ameise brütet neue Ameise in den Tod
        String map1 =
            "4\n" +
                "4\n" +
                ".=..\n" +
                "....\n" +
                ".11.\n" +
                "BAA.\n";
        String brainB1 = getUselessBrain();
        String brainA1 =
            "brain \"KinderMoerder\"{\n" +
                "move else 5\n" +
                "pickup else 5\n" +
                "sense ahead antlion else 6\n" +
                "turn left\n" +
                "breed else 5\n" +
                "jump 4\n" +        //erfolgreich gebreedet
                "jump 5\n" +        //Error
                "jump 6\n" +
                "}";         //Breedparnter macht erfolgreich nichts
        WorldInfo world1 = gameInfo.simulate(200, 123, map1, brainA1, brainB1);
        expect (NoSuchElementException.class, () -> world1.getAnt(3));
        FieldInfo field1 = world1.getFieldAt(1,1);
        assertTrue (String.format("Ameise hat nicht ein Futter fallen gelassen, sondern %d",field1.getFood()),
            field1.getFood() == 1);


        //Ameise ist initial beim Antlion und versucht breed
        String map2 = "2\n" +
            "2\n" +
            "=A\n" +
            ".B\n";
        String brainA2 = "brain \"VerzweifelteBrueter\"{\n" +
            "breed else 2\n" +
            "jump 1\n" +    //Falsch
            "jump 2\n" +    //Richtig
            "}";
        String brainB2 = getUselessBrain();
        WorldInfo world2 = gameInfo.simulate(1, 123, map2, brainA2, brainB2);
        world2.getAnt(0);
        world2.getAnt(1);
    }
}
