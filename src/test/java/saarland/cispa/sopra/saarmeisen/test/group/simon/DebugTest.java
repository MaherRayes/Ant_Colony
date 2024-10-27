package saarland.cispa.sopra.saarmeisen.test.group.simon;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.Game;


public class DebugTest {

    @Test
    public void test() {
        Game game = new Game();
        //Ameise brütet neue Ameise in den Tod
        String map1 =
            "4\n" +
                "4\n" +
                ".=..\n" +
                "....\n" +
                ".11.\n" +
                "BAA.\n";
        String brain1 = "brain \"ehlo\" {\n" +
            "jump 0\rjump 1\n" +
            "}";


        game.simulate(200, 123, map1, brain1, brain1);

    }

}
