package saarland.cispa.sopra.saarmeisen.test.group.maher;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.Direction;
import saarland.cispa.sopra.saarmeisen.Game;
import saarland.cispa.sopra.saarmeisen.World;
import saarland.cispa.sopra.saarmeisen.field.*;
import saarland.cispa.sopra.systemtests.WorldInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;




public class GetTargetFieldTest {



    @Test
    public void testTargetField(){

        String map = "4\n4\n"+
            "A#.1\n"+
            "...B\n" +
            "....\n" +
            "=..#";
        String brain = "brain \"sample\" {\n jump 0\n}";

        Game game = new Game();

        WorldInfo world = game.simulate(0, 42, map, brain, brain);

        World w0 = (World)world;

        Ant a0 = w0.getAnt(0);

        Field f0 = a0.getField();


        assertTrue(w0.getTargetField(Direction.southeast,f0) instanceof PlaneField && w0.getTargetField(Direction.southeast,f0).getFood() == 0,"it should find a PlaneField with no food at (0,1)");
        assertTrue(w0.getTargetField(Direction.southwest,f0) instanceof BaseField,"it should find a BaseField at (3,1)");
        assertTrue(w0.getTargetField(Direction.west,f0) instanceof PlaneField && w0.getTargetField(Direction.west,f0).getFood() == 1,"it should find a PlaneField with 1 piece of food at (3,0)");

    }

    @Test
    public void testTargetField2(){

        String map = "4\n4\n"+
            "A#.1\n"+
            "...B\n" +
            "....\n" +
            "=..#";
        String brain = "brain \"sample\" {\n jump 0\n}";

        Game game = new Game();

        WorldInfo world = game.simulate(0, 42, map, brain, brain);

        World w1 = (World)world;

        Ant a1 = w1.getAnt(0);

        Field f1 = a1.getField();

        assertTrue(w1.getTargetField(Direction.northwest,f1) instanceof RockField,"it should find a RockField at (3,3)");
        assertTrue(w1.getTargetField(Direction.northeast,f1) instanceof AntLionField,"it should find an AntLionField at (0,3)");
        assertTrue(w1.getTargetField(Direction.east,f1) instanceof RockField, "it should find a RockField at (1,0)");

    }

}
