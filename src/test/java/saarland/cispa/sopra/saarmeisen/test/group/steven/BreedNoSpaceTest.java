package saarland.cispa.sopra.saarmeisen.test.group.steven;

import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.*;
import saarland.cispa.sopra.saarmeisen.field.BaseField;
import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.field.RockField;
import saarland.cispa.sopra.saarmeisen.instruction.Instruction;
import saarland.cispa.sopra.saarmeisen.instruction.JumpInstruction;
import saarland.cispa.sopra.saarmeisen.instruction.BreedInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.icu.impl.Assert.fail;

public class BreedNoSpaceTest {
    @Test
    public void testBreedNoSpace(){
        List<Ant> antsBreed = new ArrayList<Ant>();
        Field[][] fieldsBreed = new Field[4][4];
        Map<Character, Swarm> mapBreed = new HashMap<Character, Swarm>();
        BreedInstruction brInsBreed = new BreedInstruction(0);
        JumpInstruction jInsBreed = new JumpInstruction(0);
        List<Instruction> instructs0Breed = new ArrayList<Instruction>();
        instructs0Breed.add(brInsBreed);
        List<Instruction> instructs1Breed = new ArrayList<Instruction>();
        instructs1Breed.add(jInsBreed);
        Program prog1Breed = new Program(instructs1Breed, "prog1",'A');
        //Program prog2Breed = new Program(instructs0Breed, "prog2",'A');
        Swarm swarm0Breed = new Swarm('A', 2, prog1Breed);
        //Swarm swarm1Breed = new Swarm('B', 1, prog2Breed);
        mapBreed.put('A', swarm0Breed);
      //  mapBreed.put('B', swarm0Breed);
        Brain brainA = new Brain();
        Brain brainB = new Brain();
        Ant antA = new Ant(fieldsBreed[0][0],0, true, swarm0Breed, 0, brainA, Direction.east);
        Ant antA2 = new Ant(fieldsBreed[1][0],1, true, swarm0Breed, 0, brainB, Direction.west);
        for(int xCoord=0; xCoord<4; xCoord++){
            for(int yCoord=0; yCoord<4; yCoord++){
                fieldsBreed[xCoord][yCoord] = new RockField(1,0, 1);
            }
        }
        fieldsBreed[0][0] = new BaseField(0,0, antA, 2, swarm0Breed);
        fieldsBreed[1][0] = new BaseField(1,1, antA2, 2, swarm0Breed);

        antA.setField(fieldsBreed[0][0]);
        antA2.setField(fieldsBreed[1][0]);

        antsBreed.add(antA);
        antsBreed.add(antA2);
        World world = new World(2,2, antsBreed, fieldsBreed, mapBreed);
        Game game = new Game();
        game.setWorld(world);

        brInsBreed.run(world, antA);
        if(brInsBreed.getAffectedAnt()!=null){
            fail("You have failed");
        }

        if(world.getAntObjects().size()!=2){
            fail("Ant was bred even though there was no space");
        }
        int antCounter = 0;
        for(int xCoord=0; xCoord<4; xCoord++){
            for(int yCoord=0; yCoord<4; yCoord++){
                if(fieldsBreed[xCoord][yCoord].getAntObject()!=null){
                    antCounter++;
                }
            }
        }
        if(antCounter!=2){
            fail("Ant was bred but there was no space!It was: "+ antCounter);
        }
        if(!antA.hasFood() || !antA2.hasFood()){
            fail("An ant has lost its food even though there was no breeding!It was:(for A1 A2) "+antA.hasFood()+"  "+antA2.hasFood());
        }
        if(swarm0Breed.getAnts()!=2){
            fail("Ant has been breed without available space!It was: "+swarm0Breed.getAnts());
        }
    }
}
