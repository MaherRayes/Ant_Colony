package saarland.cispa.sopra.systemtests.giuliano.program;

public class AcceptValidProgram1Test extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return true;
    }

    @Override
    public String failMessage() {
        return "A valid program has been refused";
    }

    @Override
    public String getBrain() {
        return "brain \"dummy\" {jump 0\n}";
    }
}
