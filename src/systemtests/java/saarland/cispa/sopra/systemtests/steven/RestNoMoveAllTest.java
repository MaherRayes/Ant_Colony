package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class RestNoMoveAllTest extends SystemTest {
	private void testThis(WorldInfo world) {
		if(world.getAnt(0).getRestTime()!=0) {
			fail("The resting time got triggered by a non move instruction!");
		}
	}
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AB\n" +
            "..";
        String brainARight = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainAMark = "brain \"sample\" {\nmark 0\njump 0\n}";
        String brainAUnmark = "brain \"sample\" {\nunmark 0\njump 0\n}";
        String brainASet = "brain \"sample\" {\nset 0\njump 0\n}";
        String brainAUnset = "brain \"sample\" {\nunset 0\njump 0\n}";
        String brainATest = "brain \"sample\" {\ntest 0 else 0\njump 0\n}";
        String brainASenseMarker = "brain \"sample\" {\nsense here marker 0 else 0\njump 0\n}";
        String brainASenseHere = "brain \"sample\" {\nsense here rock else 0\njump 0\n}";
        String brainAPickup = "brain \"sample\" {\npickup else 0\njump 0\n}";
        String brainADrop = "brain \"sample\" {\ndrop else 0\njump 0\n}";
        String brainAFlip = "brain \"sample\" {\nflip 3 else 0\njump 0\n}";
        String brainAJump = "brain \"sample\" {\njump 0\njump 0\n}";
        String brainADirection = "brain \"sample\" {\ndirection east else 0\njump 0\n}";

        String brainB = "brain \"sample\" {\nturn left\njump 0\n}";
        WorldInfo worldRightR = gameInfo.simulate(1, 42, map, brainARight, brainB);
        WorldInfo worldMarkR = gameInfo.simulate(1, 42, map, brainAMark, brainB);
        WorldInfo worldUnmarkR = gameInfo.simulate(1, 42, map, brainAUnmark, brainB);
        WorldInfo worldSetR = gameInfo.simulate(1, 42, map, brainASet, brainB);
        WorldInfo worldUnsetR = gameInfo.simulate(1, 42, map, brainAUnset, brainB);
        WorldInfo worldTestR = gameInfo.simulate(1, 42, map, brainATest, brainB);
        WorldInfo worldSenseMarkerR = gameInfo.simulate(1, 42, map, brainASenseMarker, brainB);
        WorldInfo worldSenseHereR = gameInfo.simulate(1, 42, map, brainASenseHere, brainB);
        WorldInfo worldPickupR = gameInfo.simulate(1, 42, map, brainAPickup, brainB);
        WorldInfo worldDropR = gameInfo.simulate(1, 42, map, brainADrop, brainB);
        WorldInfo worldFlipR = gameInfo.simulate(1, 42, map, brainAFlip, brainB);
        WorldInfo worldJumpR = gameInfo.simulate(1, 42, map, brainAJump, brainB);
        WorldInfo worldDirectionR = gameInfo.simulate(1, 42, map, brainADirection, brainB);

        testThis(worldRightR);
        testThis(worldMarkR);
        testThis(worldUnmarkR);
        testThis(worldSetR);
        testThis(worldUnsetR);
        testThis(worldTestR);
        testThis(worldSenseMarkerR);
        testThis(worldSenseHereR);
        testThis(worldPickupR);
        testThis(worldDropR);
        testThis(worldFlipR);
        testThis(worldJumpR);
        testThis(worldDirectionR);

    }
}
