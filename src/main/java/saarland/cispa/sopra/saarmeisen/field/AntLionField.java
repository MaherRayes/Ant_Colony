package saarland.cispa.sopra.saarmeisen.field;

public class AntLionField extends Field {
    public AntLionField(int xCoord, int yCoord, int teams) {
        super(xCoord, yCoord, null, 0, teams);
    }

    @Override
    public char getType() {
        return '=';
    }

    // TODO isTraversible override?

    @Override
    public void addFood(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException();
        }
        //this method is supposed to do nothing
    }
}
