package saarland.cispa.sopra.systemtests.giuliano.program;

public class MissingWhitespacedBodyTest extends SimpleProgramTest {

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Please use whitespaces between worlds.";
    }

    @Override
    public String getBrain() {
        return "brain \"dummy\" {\n jump0\n}";
    }
}
