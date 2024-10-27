package saarland.cispa.sopra.systemtests.giuliano.program;

public class TooLargeFlipParamater extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Flip parameter was too large";
    }

    @Override
    public String getBrain() {
        return generateBrain("flip 21474836482147483648 else 0", "jump 0");
    }
}
