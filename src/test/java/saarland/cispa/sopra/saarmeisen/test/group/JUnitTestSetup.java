package saarland.cispa.sopra.saarmeisen.test.group;


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

public class JUnitTestSetup {

    @Test
    public void test() {
        List<Ant> ants = new ArrayList<Ant>();
        Field[][] fields = new Field[2][2];
        Map<Character, Swarm> map = new HashMap<Character, Swarm>();
        JumpInstruction jIns = new JumpInstruction(0);
        List<Instruction> instructs0 = new ArrayList<Instruction>();
        instructs0.add(jIns);
        List<Instruction> instructs1 = new ArrayList<Instruction>();
        instructs1.add(jIns);
        Program prog1 = new Program(instructs1, "prog1",'A');
        Program prog2 = new Program(instructs0, "prog2",'B');
        Swarm swarm0 = new Swarm('A', 1, prog1);
        Swarm swarm1 = new Swarm('B', 1, prog2);
        map.put('A', swarm0);
        map.put('B', swarm1);
        Brain brainA = new Brain();
        Brain brainB = new Brain();
        Ant antA = new Ant(fields[0][0],0, false, swarm0, 0, brainA, Direction.northwest);
        Ant antB = new Ant(fields[0][1],1, false, swarm1, 0, brainB, Direction.northwest);
        fields[0][0] = new BaseField(0,0, antA, 2, swarm0);
        fields[1][0] = new PlaneField(1,0, 0, 2);
        fields[0][1] = new BaseField(0,1, antB, 2, swarm1);
        fields[1][1] = new PlaneField(1,1, 0, 2);
        antA.setField(fields[0][0]);
        antB.setField(fields[0][1]);

        ants.add(antA);
        ants.add(antB);
        World world = new World(2,2, ants, fields, map);
        world.getAnt(0);
    }
}
