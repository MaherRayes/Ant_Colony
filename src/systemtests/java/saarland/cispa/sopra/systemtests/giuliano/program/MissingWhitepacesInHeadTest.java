package saarland.cispa.sopra.systemtests.giuliano.program;

public class MissingWhitepacesInHeadTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Please use whitespaces between words.";
    }

    @Override
    public String getBrain() {
        return "brain\"dummy\" { \njump 0\n}";
    }
}
