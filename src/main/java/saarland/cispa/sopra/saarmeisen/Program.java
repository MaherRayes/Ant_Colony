package saarland.cispa.sopra.saarmeisen;

import saarland.cispa.sopra.saarmeisen.instruction.Instruction;

import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.List;

public class Program {
    private final List<Instruction> instructions;
    private final String name;
    private final char swarm;

    public Program(List<Instruction> instructions, String name, char swarm) {
        this.instructions = instructions;
        this.name = name;
        this.swarm = swarm;
    }

    public char getSwarm() {
        return swarm;
    }

    public Instruction get(int index) {
        if(index < 0) {
            throw new IllegalArgumentException();
        }
        return instructions.get(index);
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public String getName() {
        return name;
    }

    public JsonObject serialize(JsonBuilderFactory factory) {
        JsonObjectBuilder builder = factory.createObjectBuilder();

        JsonArrayBuilder instructionBuilder = factory.createArrayBuilder();

        instructions.stream().map(Instruction::serialize).forEach(instructionBuilder::add);

        builder.add("name", name);
        builder.add("swarm_id", new String(new char[] {swarm}));
        builder.add("instructions", instructionBuilder);

        return builder.build();
    }
}
