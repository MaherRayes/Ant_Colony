package saarland.cispa.sopra.saarmeisen;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Brain {

    public static final int REGISTER_AMOUNT = 6;

    private int programCounter;
    private boolean[] registers = new boolean[REGISTER_AMOUNT];

    public Brain() {
        this.programCounter = 0;
    }

    public int getPc() {
        return programCounter;
    }

    public void setPc(int programCounter) {
        if(programCounter < 0) {
            throw new IllegalArgumentException();
        }
        this.programCounter = programCounter;
    }

    public void incPc() {
        this.programCounter++;
    }

    public boolean[] getRegisters() {
        return registers.clone();
    }

    public void setRegister(int index, boolean value) {
        if(!(index >= 0 && index < 6)) {
            throw new IllegalArgumentException();
        }
        this.registers[index] = value;
    }

    public JsonObject serialize() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObjectBuilder builder = factory.createObjectBuilder();

        return builder.build();
    }
}
