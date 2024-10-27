package saarland.cispa.sopra.systemtests.giuliano.program;


public class InvalidJumpNegativeTest extends SimpleProgramTest {

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Jump to a negative pc.";
    }

    @Override
    public String getBrain() {
        return generateBrain("jump -1");
    }
}
