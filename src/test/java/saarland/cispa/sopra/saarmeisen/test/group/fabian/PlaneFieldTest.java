package saarland.cispa.sopra.saarmeisen.test.group.fabian;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.field.PlaneField;

import static org.junit.jupiter.api.Assertions.*;


public class PlaneFieldTest {
    @Test
    public void initialTest() {
        Field field = new PlaneField(3, 1, null, 7, 2);
        assertTrue(field.getX() == 3 && field.getY() == 1 && field.isTraversable() && field.getType() == '.', "Initiale Zeug falsch");
        assertNull(field.getAntObject(), "Wie auch immer, aber am Anfang war eine Ameise auf dem Feld");
        assertEquals(7, field.getFood(), "Field.getFood ist initial falsch");
    }

    @Test
    public void foodTest() {
        Field field = new PlaneField(1, 1, null, 3, 2);
        assertFalse(field.wasChanged(), "Initiale Field.wasChanged ist True");
        assertTrue(field.pickupFood(), "PickupFood gab false zurück, obwohl Futter da war");
        assertEquals(2, field.getFood(), "Futter sollte schon aufgehoben sein");
        field.addFood(4);
        assertEquals(6, field.getFood(), "Futter wurde nicht richtig hinzugefügt");
        if (!field.pickupFood()) {
            fail("Obwohl Futter da war, konnte es nicht aufgehoben werden");
        }
    }

    @Test
    public void antTest() {
        Ant ant = new Ant(null, 0, false, null, 0, null, null);
        Field field = new PlaneField(1, 1, ant, 0, 2);
        Ant ant2 = field.getAntObject();
        assertEquals(ant, ant2, "Equals stimmt nicht oder das getAntObject");
        assertTrue(field.getAnt().isPresent(), "Ameise war nicht present");
    }
}
