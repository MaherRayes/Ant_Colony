package saarland.cispa.sopra.saarmeisen.test.group.fabian;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.field.AntLionField;
import saarland.cispa.sopra.saarmeisen.field.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AntLionFieldTest {

    @Test
    public void antLiontest() {
        Field field = new AntLionField(3, 3, 2);
        assertFalse(field.getAnt().isPresent(), "Auf Antlion war eine Ameise");
        field.addFood(1);
        assertEquals(0, field.getFood(), "Direkt auf Ameisenlöwe war Futter");
        assertEquals('=', field.getType(), "Falscher Feldtyp zurückgegeben");
        assertTrue(field.isTraversable(), "Ameise sollte begehbar sein");
    }
}
