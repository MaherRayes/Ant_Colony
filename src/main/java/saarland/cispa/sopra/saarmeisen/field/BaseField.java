package saarland.cispa.sopra.saarmeisen.field;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.Swarm;

public class BaseField extends Field {

    private final Swarm swarm;

    public BaseField(int xCoord, int yCoord, Ant ant, int teams, Swarm swarm) {
        super(xCoord, yCoord, ant, 0, teams);
        this.swarm = swarm;
    }

    public Swarm getSwarm() {
        return swarm;
    }

    @Override
    public char getType() {
        return swarm.getName();
    }

    @Override
    public void addFood(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException();
        }
        swarm.addScore(amount);
    }

}
