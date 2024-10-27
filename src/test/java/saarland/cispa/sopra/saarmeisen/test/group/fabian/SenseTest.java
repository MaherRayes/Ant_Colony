package saarland.cispa.sopra.saarmeisen.test.group.fabian;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.Game;
import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SenseTest {
    @Test
    public void senseFood() {
        GameInfo gameInfo = new Game();
        String map1 =
            "2\n" +
                "2\n" +
                ".1\n" +
                "BA\n";
        String brainA =
            "brain \"Smeller\"{\n" +
                "sense ahead food else 2\n" +
                "jump 1\n" +
                "jump 2\n" +
                "}";
        String brainB =
            "brain \"Useless\"{\n" +
                "jump 0\n" +
                "}";
        WorldInfo world1 = gameInfo.simulate(100, 1313, map1, brainA, brainB);
        AntInfo ant1 = world1.getAnt(1);
        assertEquals(1, ant1.getPc(), "Ameise A hat nicht das Futter gerochen");

        String map2 =
            "2\n" +
                "2\n" +
                ".2\n" +
                "BA\n";
        WorldInfo world2 = gameInfo.simulate(110, 13123, map2, brainA, brainB);
        AntInfo ant2 = world2.getAnt(1);
        assertEquals(1, ant2.getPc(), "Ameise A hat nicht die zwei Futter gerochen");
    }

    @Test
    public void senseFoeHome() {
        GameInfo gameInfo = new Game();
        String map =
            "2\n" +
                "2\n" +
                "A.\n" +
                "BB\n";
        String brain =
            "brain \"Gegnerriecher\"{\n" +
                "sense ahead foehome else 2\n" +
                "jump 1\n" +
                "jump 2\n" +
                "}";
        WorldInfo world = gameInfo.simulate(90, 132123, map, brain, brain);
        AntInfo ant0 = world.getAnt(0);
        AntInfo ant1 = world.getAnt(1);
        AntInfo ant2 = world.getAnt(2);
        assertEquals(1, ant0.getPc(), "Ameise A0 hat Basis von B nicht gerochen");
        assertEquals(1, ant1.getPc(), "Ameise B1 hat Basis von A nicht gerochen");
        assertEquals(2, ant2.getPc(), "Ameise A2 hat was falsches gerochen");
    }

    @Test
    public void foeMarker() {
        GameInfo gameInfo = new Game();
        String map =
            "2\n" +
                "2\n" +
                "B.\n" +
                "A.\n";
        String brainA =
            "brain \"enemyMarkSmeller\"{\n" +
                "jump 1\n" +
                "jump 2\n" +
                "sense ahead foemarker else 4\n" +
                "jump 3\n" +
                "jump 4\n" +
                "}";
        String brainB =
            "brain \"Marker\"{\n" +
                "mark 3\n" +
                "jump 1\n" +
                "}";
        WorldInfo world = gameInfo.simulate(20, 0, map, brainA, brainB);
        AntInfo antA = world.getAnt(1);
        assertEquals(3, antA.getPc(), "Ameise A hat feindliche Markierung nicht gerochen");
    }

    @Test
    public void antLionAndNeighbors() {
        GameInfo gameInfo = new Game();
        String map =
            "4\n" +
                "4\n" +
                "....\n" +
                ".=..\n" +
                "..B.\n" +
                "..AC\n";
        String brain =
            "brain \"LionSmeller\"{\n" +
                "sense ahead antlion else 2\n" +
                "jump 1\n" +
                "jump 2\n" +
                "}";
        WorldInfo world = gameInfo.simulate(20, -123, map, brain, brain, brain);
        AntInfo ant0 = world.getAnt(0);
        AntInfo ant1 = world.getAnt(1);
        AntInfo ant2 = world.getAnt(2);
        assertEquals(1, ant0.getPc(), "B hat Löwe nicht gerochen");
        assertEquals(1, ant1.getPc(), "A hat Löwennachbar nicht gerochen");
        assertEquals(2, ant2.getPc(), "C hat Löwe gerochen");
    }

    @Test
    public void foeFriendFood() {
        GameInfo gameInfo = new Game();
        String map =
            "4\n" +
                "4\n" +
                "....\n" +
                ".1B.\n" +
                ".AA.\n" +
                "....\n";
        String brainA =
            "brain \"FoodSmell\"{\n" +
                "sense ahead food else 4\n" +
                "move else 6\n" +
                "pickup else 6\n" +
                "jump 3\n" +    //Für Ameise mit ID 2 richtig
                "turn right\n" +
                "sense ahead friendfood else 7\n" +
                "jump 6\n" +   //Fehler
                "sense ahead friendfood else 7\n" +    //Hierher springen
                "jump 8\n" +    //Für Ameise mit ID 1 richtig
                "}";
        String brainB =
            "brain \"EnemySmeller\"{\n" +
                "turn left\n" +
                "sense ahead foefood else 3\n" +
                "jump 2\n" +
                "sense ahead foefood else 5\n" +
                "jump 4\n" +
                "sense ahead foefood else 5\n" +
                "jump 6\n" +    //Richtig
                "}";
        WorldInfo world = gameInfo.simulate(100, 23, map, brainA, brainB);
        AntInfo ant0 = world.getAnt(0);
        AntInfo ant1 = world.getAnt(1);
        AntInfo ant2 = world.getAnt(2);
        assertEquals(6, ant0.getPc(), "Ameise hat foeFood nicht richtig gerochen");
        assertEquals(8, ant1.getPc(), "Ameise hat friendfood nicht richtig gerochen");
        assertEquals(3, ant2.getPc(), "Ameise hat sich falsch bewegt");
    }
}
