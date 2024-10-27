package saarland.cispa.sopra.systemtests.giuliano.program;

public class InvalidFlipParameterTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Flip argument must be non negative.";
    }

    @Override
    public String getBrain() {
        return generateBrain("flip -1 else 0","jump 0");
    }
}
