package saarland.cispa.sopra.saarmeisen.test.group.maher;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.*;
import saarland.cispa.sopra.saarmeisen.field.BaseField;
import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.field.PlaneField;
import saarland.cispa.sopra.saarmeisen.instruction.BreedInstruction;
import saarland.cispa.sopra.saarmeisen.instruction.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BreedTests {

    @Test
    public void test() {
        Field[][] fields = new Field[2][2];
        List<Ant> ants = new ArrayList<Ant>();
        BreedInstruction bIns = new BreedInstruction(0);
        List<Instruction> instructs0 = new ArrayList<Instruction>();
        List<Instruction> instructs1 = new ArrayList<Instruction>();
        instructs1.add(bIns);
        instructs0.add(bIns);
        Program program2 = new Program(instructs0, "prog2",'B');
        Program program1 = new Program(instructs1, "prog1",'A');

        Swarm swarm0 = new Swarm('A', 1, program1);
        Swarm swarm1 = new Swarm('B', 1, program2);
        Map<Character, Swarm> map = new HashMap<Character, Swarm>();
        map.put('B', swarm1);

        map.put('A', swarm0);
        Brain brainB = new Brain();
        Brain brainA = new Brain();
        Ant antB = new Ant(fields[0][1],1, true, swarm1, 0, brainB, Direction.northwest);
        Ant antA = new Ant(fields[0][0],0, true, swarm0, 0, brainA, Direction.southeast);
        fields[0][1] = new BaseField(0,1, antB, 2, swarm1);
        fields[0][0] = new BaseField(0,0, antA, 2, swarm0);
        fields[1][1] = new PlaneField(1,1, 0, 2);
        fields[1][0] = new PlaneField(1,0,null,0,2);
        antB.setField(fields[0][1]);
        antA.setField(fields[0][0]);


        ants.add(antA);
        ants.add(antB);
        World world = new World(2,2, ants, fields, map);
        Instruction ins = antB.getNextInstruction();

        //ins.run(world,antB);

        assertNull(world.getFieldAt(1,0).getAntObject(),"The ants are from different swarms, They can't breed");

        Game game = new Game();
        game.setWorld(world);

        Brain brainA2 = new Brain();
        Ant antA2 = new Ant(fields[1][1],2, true, swarm0, 0, brainA2, Direction.northwest);
        fields[1][1].setAnt(antA2);
        world.addAnt(antA2);



        Brain brainA3 = new Brain();
        Ant antA3 = new Ant(fields[1][0],3, true, swarm0, 0, brainA3, Direction.northwest);
        fields[1][0].setAnt(antA3);
        world.addAnt(antA3);



        game.checkForAntDeaths(antB);

        assertEquals(fields[0][1].getAntObject(),null,"The Ant B should have died");

        //ins.run(world,antA2);
        assertEquals(ins.getAffectedAnt(),null,"LOL");



        ins.run(world,antA2);
        assertNotEquals(ins.getAffectedAnt(),null,"it doesnt work");

    }

}
