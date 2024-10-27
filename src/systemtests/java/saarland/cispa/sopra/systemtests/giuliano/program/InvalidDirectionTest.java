package saarland.cispa.sopra.systemtests.giuliano.program;

public class InvalidDirectionTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "direction instruction became invalid direction parameter.";
    }

    @Override
    public String getBrain() {
        return generateBrain("direction north else 0", "jump 1");
    }
}
