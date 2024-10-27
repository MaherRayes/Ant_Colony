package saarland.cispa.sopra.saarmeisen.test.group.steven;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.*;
import saarland.cispa.sopra.saarmeisen.field.BaseField;
import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.field.PlaneField;
import saarland.cispa.sopra.saarmeisen.field.RockField;
import saarland.cispa.sopra.saarmeisen.instruction.Instruction;
import saarland.cispa.sopra.saarmeisen.instruction.BreedInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.icu.impl.Assert.fail;

public class BreedSpaceSecondAntTest {
    @Test
    public void testNoBreedNoSpace(){
        List<Ant> antsNoBreed = new ArrayList<Ant>();
        Field[][] fieldsNoBreed = new Field[4][4];
        Map<Character, Swarm> mapNoBreed = new HashMap<Character, Swarm>();
        BreedInstruction brInsNoBreed = new BreedInstruction(0);
        List<Instruction> instructs0NoBreed = new ArrayList<Instruction>();
        instructs0NoBreed.add(brInsNoBreed);

        Program prog1NoBreed = new Program(instructs0NoBreed, "prog1",'A');
        Swarm swarm0NoBreed = new Swarm('A', 2, prog1NoBreed);
        mapNoBreed.put('A', swarm0NoBreed);
        Brain brainA = new Brain();
        Brain brainB = new Brain();
        Ant antA = new Ant(fieldsNoBreed[0][0],0, true, swarm0NoBreed, 0, brainA, Direction.east);
        Ant antA2 = new Ant(fieldsNoBreed[1][0],1, true, swarm0NoBreed, 0, brainB, Direction.west);
        for(int xCoord=0; xCoord<4; xCoord++){
            for(int yCoord=0; yCoord<4; yCoord++){
                fieldsNoBreed[xCoord][yCoord] = new RockField(xCoord,yCoord, 1);
            }
        }
        fieldsNoBreed[0][0] = new BaseField(0,0, antA, 2, swarm0NoBreed);
        fieldsNoBreed[1][0] = new BaseField(1,0, antA2, 2, swarm0NoBreed);
        fieldsNoBreed[1][1] = new PlaneField(1,1,0, 1);

        antA.setField(fieldsNoBreed[0][0]);
        antA2.setField(fieldsNoBreed[1][0]);

        antsNoBreed.add(antA);
        antsNoBreed.add(antA2);
        World world = new World(4,4, antsNoBreed, fieldsNoBreed, mapNoBreed);
        Game game = new Game();
        game.setWorld(world);

        brInsNoBreed.run(world, antA);


        int antCounter = 0;
        for(int xCoord=0; xCoord<4; xCoord++){
            for(int yCoord=0; yCoord<4; yCoord++){
                if(world.getFields()[xCoord][yCoord].getAntObject()!=null){
                    antCounter++;

                }

            }
        }
        if(antCounter!=3){
            fail("Ant was not bred even though there was space!There were: "+ antCounter+ " ants!");
        }
        if(brInsNoBreed.getAffectedAnt()==null){
            fail("You have failed. It was: "+brInsNoBreed.getAffectedAnt());
        }

        if(world.getAntObjects().size()!=3){
            fail("Ant was bred even though there was no space");
        }

        if(antA.hasFood() || antA2.hasFood()){
            fail("An ant has lost its food even though there was no NoBreeding!It was:(for A1 A2) "+antA.hasFood()+"  "+antA2.hasFood());
        }
        if(swarm0NoBreed.getAnts()!=3){
            fail("Ant has been NoBreed without available space!It was: "+swarm0NoBreed.getAnts());
        }
    }
}
