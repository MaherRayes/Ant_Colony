package saarland.cispa.sopra.saarmeisen.field;

import saarland.cispa.sopra.saarmeisen.Ant;

public class PlaneField extends Field {
    public PlaneField(int xCoord, int yCoord, Ant ant, int food, int teams) {
        super(xCoord, yCoord, ant, food, teams);
    }
    public PlaneField(int xCoord, int yCoord, int food, int teams) {
        super(xCoord, yCoord, null, food, teams);
    }

    @Override
    public char getType() {
        return '.';
    }
}
