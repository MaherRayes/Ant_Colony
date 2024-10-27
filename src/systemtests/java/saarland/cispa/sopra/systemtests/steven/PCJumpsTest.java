package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class PCJumpsTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AB\n" +
            "##";
        String brainATurnLeft = "brain \"sample\" {\nturn left\njump 0\n}"; //pc ==1
        String brainATurnRight = "brain \"sample\" {\nturn right\njump 0\n}";//1
        String brainAMark = "brain \"sample\" {\nmark 0\njump 0\n}";//1
        String brainAUnmark = "brain \"sample\" {\nunmark 0\njump 0\n}";//1
        String brainASet = "brain \"sample\" {\nset 0\njump 0\n}";//1
        String brainAUnset = "brain \"sample\" {\nunset 0\njump 0\n}";//1

        String brainATest = "brain \"sample\" {\ntest 0 else 0\njump 0\n}"; //0
        String brainAMove = "brain \"sample\" {\nmove else 0\njump 0\n}"; //0
        String brainASense = "brain \"sample\" {\nsense ahead friend else 0\njump 0\n}"; //0
        String brainAPickup = "brain \"sample\" {\npickup else 0\njump 0\n}"; //0
        String brainADrop = "brain \"sample\" {\ndrop else 0\njump 0\n}"; //0
        String brainAJump = "brain \"sample\" {\njump 0\njump 1\n}"; //0
        String brainADirection = "brain \"sample\" {\ndirection east else 0\njump 0\n}"; //0
        String brainB = "brain \"sample\" {\nturn left\njump 0\n}";

        WorldInfo worldTurnLeft = gameInfo.simulate(1, 42, map, brainATurnLeft, brainB);
        WorldInfo worldTurnRight = gameInfo.simulate(1, 42, map, brainATurnRight, brainB);
        WorldInfo worldMark = gameInfo.simulate(1, 42, map, brainAMark, brainB);
        WorldInfo worldUnmark = gameInfo.simulate(1, 42, map, brainAUnmark, brainB);
        WorldInfo worldSet = gameInfo.simulate(1, 42, map, brainASet, brainB);
        WorldInfo worldUnset = gameInfo.simulate(1, 42, map, brainAUnset, brainB);

        WorldInfo worldTest = gameInfo.simulate(1, 42, map, brainATest, brainB);
        WorldInfo worldMove = gameInfo.simulate(1, 42, map, brainAMove, brainB);
        WorldInfo worldSense = gameInfo.simulate(1, 42, map, brainASense, brainB);
        WorldInfo worldPickup = gameInfo.simulate(1, 42, map, brainAPickup, brainB);
        WorldInfo worldDrop = gameInfo.simulate(1, 42, map, brainADrop, brainB);
        WorldInfo worldJump = gameInfo.simulate(1, 42, map, brainAJump, brainB);
        WorldInfo worldDirection = gameInfo.simulate(1, 42, map, brainADirection, brainB);

        if(worldTurnLeft.getAnt(0).getPc()!=1 || worldTurnRight.getAnt(0).getPc()!=1 || worldMark.getAnt(0).getPc()!=1||
        	worldUnmark.getAnt(0).getPc()!=1 || worldSet.getAnt(0).getPc()!=1 || worldUnset.getAnt(0).getPc()!=1) {
        	fail("Pc has not been set correctly for ant 0 after 1 round!");
        }
        if(worldTest.getAnt(0).getPc() !=0|| worldMove.getAnt(0).getPc() !=0|| worldSense.getAnt(0).getPc() !=0|| worldPickup.getAnt(0).getPc()!=0||
        		worldDrop.getAnt(0).getPc() !=0||worldJump.getAnt(0).getPc() !=0|| worldDirection.getAnt(0).getPc()!=0) {
        	fail("Pc has not been set correctly after 1 round!");
        }
    }
}
