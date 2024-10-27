package saarland.cispa.sopra.saarmeisen.antlr;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;

public class MyErrorStrategy extends DefaultErrorStrategy {
    @Override
    public void reportError(Parser recognizer, RecognitionException error) {
        super.reportError(recognizer, error);
        throw new IllegalArgumentException(error);
    }
}
