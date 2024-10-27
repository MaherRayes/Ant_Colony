package saarland.cispa.sopra.systemtests.giuliano.program;

public class InvalidElseNegativeTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Else to negative pc.";
    }

    @Override
    public String getBrain() {
        return generateBrain("move else -1", "jump 0");
    }
}
