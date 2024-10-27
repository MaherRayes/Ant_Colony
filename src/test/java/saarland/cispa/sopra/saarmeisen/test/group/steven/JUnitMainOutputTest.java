package saarland.cispa.sopra.saarmeisen.test.group.steven;


import org.junit.jupiter.api.Test;


import saarland.cispa.sopra.saarmeisen.field.BaseField;

import saarland.cispa.sopra.saarmeisen.*;

import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.field.PlaneField;
import saarland.cispa.sopra.saarmeisen.instruction.Instruction;
import saarland.cispa.sopra.saarmeisen.instruction.JumpInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JUnitMainOutputTest {

    @Test
    public void test() {
        List<Ant> antsNew = new ArrayList<Ant>();
        Field[][] fieldsNew = new Field[2][2];
        Map<Character, Swarm> mapNew = new HashMap<Character, Swarm>();
        JumpInstruction jInsNew = new JumpInstruction(0);
        List<Instruction> instructs0New = new ArrayList<Instruction>();
        instructs0New.add(jInsNew);
        List<Instruction> instructs1New = new ArrayList<Instruction>();
        instructs1New.add(jInsNew);
        Program prog1New = new Program(instructs1New, "prog1",'A');
        Program prog2New = new Program(instructs0New, "prog2",'B');
        Swarm swarm0New = new Swarm('A', 1, prog1New);
        Swarm swarm1New = new Swarm('B', 1, prog2New);
        mapNew.put('A', swarm0New);
        mapNew.put('B', swarm1New);
        Brain brainA = new Brain();
        Brain brainB = new Brain();
        Ant antA = new Ant(fieldsNew[0][0],0, false, swarm0New, 0, brainA, Direction.northwest);
        Ant antB = new Ant(fieldsNew[0][1],1, false, swarm1New, 0, brainB, Direction.northwest);
        fieldsNew[0][0] = new BaseField(0,0, antA, 2, swarm0New);
        fieldsNew[1][0] = new PlaneField(1,0, 0, 2);
        fieldsNew[0][1] = new BaseField(0,1, antB, 2, swarm1New);
        fieldsNew[1][1] = new PlaneField(1,1, 0, 2);


        antsNew.add(antA);
        antsNew.add(antB);
        World world = new World(2,2, antsNew, fieldsNew, mapNew);
        Game game = new Game();
        game.setWorld(world);
        //testAWinsFood
        testAWinsFood(swarm0New);
        game.printResults();
        //testBWinsFood
        testBWinsFood(swarm1New);
        game.printResults();
        //testAWinsAnts
        testAWinsAnts(swarm0New, swarm1New);
        game.printResults();
        //testBWinsAnts
        testBWinsAnts(swarm0New, swarm1New);
        game.printResults();
        //Draw
        testDraw(swarm0New);
        game.printResults();

    }
    private void testAWinsFood(Swarm swarmA){
        swarmA.addScore(1);
    }
    private void testBWinsFood(Swarm swarmB){
        swarmB.addScore(2);
    }
    private void testAWinsAnts(Swarm swarmA,Swarm swarmB){
        swarmA.addScore(1);
        swarmB.removeAnt();
    }
    private void testBWinsAnts(Swarm swarmA, Swarm swarmB){
        swarmA.removeAnt();
        swarmB.setAnts(1);
    }
    private void testDraw(Swarm swarmA){
        swarmA.setAnts(1);
    }
}
