package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public abstract class Instruction {

    private Ant affectedAnt;

	public abstract void run(World world, Ant executor);

	public abstract String serialize();

	public boolean checkSideEffectKill(){
	    return false;
    }

    public Ant getAffectedAnt() {
        return affectedAnt;
    }

    protected void setAffectedAnt(Ant affectedAnt) {
        this.affectedAnt = affectedAnt;
    }
}
