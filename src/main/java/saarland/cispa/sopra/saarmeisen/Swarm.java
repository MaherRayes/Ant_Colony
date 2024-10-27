package saarland.cispa.sopra.saarmeisen;

import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Swarm {
    private int score;
    private final char name;
    private int ants;
    private final Program program;

    public Swarm(char name, int ants, Program program) {
        if(ants < 0) {
            throw new IllegalArgumentException();
        }
        if(!('A' <= name && name <= 'Z')) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.ants = ants;
        this.program = program;
        this.score = 0;
    }

    public void addScore(int score) {

        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void setAnts(int ants) {
        if(ants < 0) {
            throw new IllegalArgumentException();
        }
        this.ants = ants;
    }

    public void removeAnt() {
        this.ants--;
    }

    public char getName() {
        return name;
    }

    public int getAnts() {
        return ants;
    }

    public Program getProgram() {
        return program;
    }

    public JsonObject serialize(JsonBuilderFactory factory) {
        JsonObjectBuilder builder = factory.createObjectBuilder();
        builder.add("swarm_id", new String(new char[] {name})).add("score", score).add("ants", ants);
        return builder.build();
    }
}
