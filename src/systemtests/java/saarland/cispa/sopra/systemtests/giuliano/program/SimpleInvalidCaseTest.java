package saarland.cispa.sopra.systemtests.giuliano.program;

public class SimpleInvalidCaseTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Invalid case.";
    }

    @Override
    public String getBrain() {
        return generateBrain("direction WEST else 0", "jump 0");
    }
}
