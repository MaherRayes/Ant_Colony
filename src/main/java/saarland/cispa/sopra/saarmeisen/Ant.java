package saarland.cispa.sopra.saarmeisen;

import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.instruction.Instruction;
import saarland.cispa.sopra.systemtests.AntInfo;

import javax.json.*;
import java.util.Objects;

public class Ant implements AntInfo {
    private Field field;
    private int antId;
    private boolean food;
    private Swarm swarm;
    private int restTime;
    private Brain brain;
    private Direction direction;
    private boolean alive;

    //TODO reduce constructor
    public Ant(Field field, int antId, boolean hasFoodIntern, Swarm swarm, int restTime, Brain brain, Direction direction) {
        if(antId < 0) {
            throw new IllegalArgumentException();
        }
        if(restTime < 0) {
            throw new IllegalArgumentException();
        }
        this.field = field;
        this.antId = antId;
        this.food = hasFoodIntern;
        this.swarm = swarm;
        this.restTime = restTime;
        this.brain = brain;
        this.direction = direction;
        this.alive = true;
    }

    public void setPc(int programCounter) {
        if(programCounter < 0) {
            throw new IllegalArgumentException();
        }
        brain.setPc(programCounter);
    }

    public void incPc() {
        brain.incPc();
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public char getSwarm() {
        return swarm.getName();
    }

    @Override
    public boolean hasFood() {
        return food;
    }

    @Override
    public boolean[] getRegister() {
        return getBrain().getRegisters();
    }

    @Override
    public int getPc() {
        return getBrain().getPc();
    }

    @Override
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public int getId() {
        return antId;
    }

    public void setAntId(int antId) {
        if(antId < 0) {
            throw new IllegalArgumentException();
        }
        this.antId = antId;
    }

    public void setHasFood(boolean hasFoodIntern) {
        this.food = hasFoodIntern;
    }

    public Swarm getSwarmObject() {
        return swarm;
    }

    public void setSwarm(Swarm swarm) {
        this.swarm = swarm;
    }

    @Override
    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }

    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        this.brain = brain;
    }

    public Direction getDirectionObject() {
        return direction;
    }

    @Override
    public String getDirection() {
        return direction.toString();
    }

    public Instruction getNextInstruction() {
        return getSwarmObject().getProgram().get(getBrain().getPc());
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public JsonObject serialize() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObjectBuilder builder = factory.createObjectBuilder();

        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();

        for(boolean bBbBoolean : getBrain().getRegisters()) {
            arrayBuilder.add(bBbBoolean);
        }

        builder.add("id", getId()).add("program_counter", getPc()).add("swarm_id", new String(new char[] {getSwarm()})).add("carries_food", hasFood())
            .add("direction", getDirection()).add("rest_time", getRestTime()).add("register", arrayBuilder);

        return builder.build();
    }

    @Override
    public boolean equals(Object another) {
        if(this == another) {
            return true;
        }
        if(another == null || getClass() != another.getClass()) {
            return false;
        }
        Ant antt = (Ant) another;
        return antId == antt.antId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(antId);
    }
}
