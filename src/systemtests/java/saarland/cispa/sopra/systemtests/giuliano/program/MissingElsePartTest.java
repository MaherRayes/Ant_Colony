package saarland.cispa.sopra.systemtests.giuliano.program;

public class MissingElsePartTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Move instruction must have an else part.";
    }

    @Override
    public String getBrain() {
        return generateBrain("move", "jump 1");
    }
}
