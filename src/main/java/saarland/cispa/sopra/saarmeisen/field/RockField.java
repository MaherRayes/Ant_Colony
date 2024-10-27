package saarland.cispa.sopra.saarmeisen.field;

public class RockField extends Field {
    public RockField(int xCoord, int yCoord, int teams) {
        super(xCoord, yCoord, null, 0, teams);
    }

    @Override
    public boolean isTraversable() {
        return false;
    }

    @Override
    public char getType() {
        return '#';
    }
}
