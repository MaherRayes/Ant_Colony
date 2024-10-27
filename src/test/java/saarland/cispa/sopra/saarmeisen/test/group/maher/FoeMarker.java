package saarland.cispa.sopra.saarmeisen.test.group.maher;


import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.*;
import saarland.cispa.sopra.saarmeisen.field.BaseField;
import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.field.PlaneField;
import saarland.cispa.sopra.saarmeisen.instruction.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class FoeMarker {

    @Test
    public void test() {
        List<Ant> ants = new ArrayList<Ant>();
        Field[][] ifields = new Field[2][2];
        Map<Character, Swarm> map = new HashMap<Character, Swarm>();
        SenseInstruction sIns = new SenseInstruction(10, SensableObject.foemarker, RelativeDirection.ahead);
        MarkInstruction mIns = new MarkInstruction(1,true);
        List<Instruction> iinstructs0 = new ArrayList<Instruction>();
        iinstructs0.add(sIns);
        List<Instruction> iinstructs1 = new ArrayList<Instruction>();
        iinstructs1.add(mIns);
        Program prog1 = new Program(iinstructs1, "prog1",'A');
        Program prog2 = new Program(iinstructs0, "prog2",'B');
        Swarm iswarm0 = new Swarm('A', 1, prog1);
        Swarm iswarm1 = new Swarm('B', 1, prog2);
        map.put('A', iswarm0);
        map.put('B', iswarm1);
        Brain ibrainA = new Brain();
        Brain ibrainB = new Brain();
        Ant antA = new Ant(ifields[0][0],0, false, iswarm0, 0, ibrainA, Direction.northwest);
        Ant antB = new Ant(ifields[0][1],1, false, iswarm1, 0, ibrainB, Direction.northwest);
        ifields[0][0] = new BaseField(0,0, antA, 2, iswarm0);
        ifields[1][0] = new PlaneField(1,0, 0, 2);
        ifields[0][1] = new BaseField(0,1, antB, 2, iswarm1);
        ifields[1][1] = new PlaneField(1,1, 0, 2);
        antA.setField(ifields[0][0]);
        antB.setField(ifields[0][1]);

        ants.add(antA);
        ants.add(antB);
        World world = new World(2,2, ants, ifields, map);

        mIns.run(world,world.getAnt(0));
        sIns.run(world,world.getAnt(1));
        boolean bo = 1 == world.getAnt(1).getPc();
        assertTrue(bo,"the foemarker sense should have worked");

        MarkInstruction mmIns = new MarkInstruction(1,false);
        mmIns.run(world,world.getAnt(0));


        antA.setSwarm(iswarm1);
        mIns.run(world,world.getAnt(0));
        sIns.run(world,world.getAnt(1));

        boolean bo2 = 10 == world.getAnt(1).getPc();

        assertTrue(bo2,"the foemarker shouldn't work");

        SenseInstruction ssIns = new SenseInstruction(10,SensableObject.marker,RelativeDirection.ahead,1);
        ssIns.run(world,world.getAnt(1));

        boolean bo3 = 11 == world.getAnt(1).getPc();

        assertTrue(bo3,"the marker should have worked");

    }
}
