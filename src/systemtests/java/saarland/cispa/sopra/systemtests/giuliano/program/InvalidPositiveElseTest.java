package saarland.cispa.sopra.systemtests.giuliano.program;

public class InvalidPositiveElseTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Else to pc larger than program.";
    }

    @Override
    public String getBrain() {
        return generateBrain("move else 2", "jump 0");
    }
}
