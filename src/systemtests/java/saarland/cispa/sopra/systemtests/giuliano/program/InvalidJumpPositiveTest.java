package saarland.cispa.sopra.systemtests.giuliano.program;

public class InvalidJumpPositiveTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Jump to a pc larger than program size.";
    }

    @Override
    public String getBrain() {
        return generateBrain("jump 1");
    }
}
