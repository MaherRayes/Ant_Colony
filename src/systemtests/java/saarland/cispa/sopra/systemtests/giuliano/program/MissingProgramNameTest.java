package saarland.cispa.sopra.systemtests.giuliano.program;

public class MissingProgramNameTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Please specify a program name.";
    }

    @Override
    public String getBrain() {
        return "brain {\njump 0\n}";
    }
}
