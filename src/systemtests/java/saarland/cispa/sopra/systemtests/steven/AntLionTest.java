package saarland.cispa.sopra.systemtests.steven;

import java.util.NoSuchElementException;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AntLionTest extends SystemTest {
    private static final String map0 = "2\n2\n" +
                                "A=\n" +
                                ".B" ;
    private void testJump(GameInfo gameInfo){
        String brain = "brain \"sample\" {\njump 0\n}";
        WorldInfo world = gameInfo.simulate(1, 42, map0, brain, brain);
        try{
            world.getAnt(0);
            world.getAnt(1);
            world.getFieldAt(0,0).getAnt();
            world.getFieldAt(1,1).getAnt();
        }catch(NoSuchElementException e){
            fail("An ant has been removed (neighbour to antlion) even though there was no breed or move isntruction executed!");
        }
    }
    private void testBreedDeath(GameInfo gameInfo){
        String map1 = "4\n4\n" +
            "..11\n" +
            "..AA\n" +
            "...B\n" +
            "..=." ;
        String map2 = "4\n4\n" +
            "..11\n" +
            "..AA\n" +
            "...B\n" +
            "...=" ;
        String brainA = "brain \"sample\" {\nmove else 0\nturn left\nbreed else 0\njump 0\n}"; //17
        String brainB = "brain \"sample\" {\njump 0\n}";
        WorldInfo world1 = gameInfo.simulate(17, 42, map1, brainA, brainB);
        WorldInfo world2 = gameInfo.simulate(17, 42, map2, brainA, brainB);
        expect(NoSuchElementException.class, () ->world1.getAnt(3));
        expect(NoSuchElementException.class, () ->world2.getAnt(3));
        if(world1.getFieldAt(2,3).getAnt().isPresent()){
            fail("Did not remove bred ant 3 from field after death to antlion!");
        }
        if(world2.getFieldAt(2,3).getAnt().isPresent()){
            fail("Did not remove bred ant 3 from field after death to antlion!");
        }
        if(world1.getFieldAt(2,3).getFood()!=0){
            fail("Did not remove food from antlion field after bred ant died!");
        }
        if(world2.getFieldAt(2,3).getFood()!=1){
            fail("Did not leave only 1 food on antlion neighbour field after bred ant died!");
        }

    }
    private void testMoveDeath(GameInfo gameInfo){
        String brainA = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainB = "brain \"sample\" {\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(1, 42, map0, brainA, brainB);
        expect(NoSuchElementException.class, () ->world.getAnt(1));
        if(world.getAnt(0)==null) {
            fail("Ant 0 has been removed from list!");
        }
        if(world.getFieldAt(1, 0).getFood()!=0){
            fail("Food on AntLionField @ 1,0 has not been removed after Ant death!");
        }
    }
    private void testFailedMoveDeath(GameInfo gameInfo){
        String mapFailed = "2\n2\n" +
            "A=\n" +
            "#B" ;
        String brainA = "brain \"samA\" {\nmove else 0\njump 0\n}";
        String brainB = "brain \"samB\" {\nturn right\njump 0\n}";
        WorldInfo world = gameInfo.simulate(1, 42, mapFailed, brainA, brainB);
        expect(NoSuchElementException.class, () ->world.getAnt(0));
        if(world.getAnt(1)==null) {
            fail("Ant 1 has been removed from list!");
        }
        if(world.getFieldAt(0, 0).getFood()!=1){
            fail("Food on AntLionNeighbourField @ 0,0 has not been set to 1 after Ant death!");
        }
    }
    private void testMoveDeathNeighbour(GameInfo gameInfo){
        String map0 = "2\n2\n" +
            "=.\n" +
            "AB" ;
        String brainA = "brain \"sampleA\" {\nturn left\njump 0\n}";
        String brainB = "brain \"sampleB\" {\nmove else 0\njump 0\n}";
        WorldInfo world = gameInfo.simulate(1, 42, map0, brainA, brainB);
        expect(NoSuchElementException.class, () ->world.getAnt(1));
        if(world.getAnt(0)==null) {
            fail("Ant 0 has been removed from list!");
        }
        if(world.getFieldAt(1, 0).getFood()!=1){
            fail("Food on AntLionNeighbourField @ 1,0 has not been set to 1 after Ant death!");
        }
    }
    @Override
    public void test(GameInfo gameInfo) {
       testJump(gameInfo);
       testMoveDeath(gameInfo);

    }
}
