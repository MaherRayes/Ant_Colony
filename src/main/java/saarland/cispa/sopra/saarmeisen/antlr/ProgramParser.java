package saarland.cispa.sopra.saarmeisen.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import saarland.cispa.sopra.antlr.AcolaLexer;
import saarland.cispa.sopra.antlr.AcolaParser;
import saarland.cispa.sopra.saarmeisen.Brain;
import saarland.cispa.sopra.saarmeisen.Program;
import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.instruction.*;

import java.util.List;
import java.util.Random;

public class ProgramParser {


    public static final int PROGRAM_MAX_SIZE = 2500;
    private static final String[] identifiers = {"brain", "else", "mark", "unmark", "set", "unset", "test", "turn", "move", "sense", "pickup", "drop",
        "flip", "jump", "direction", "breed", "foe", "food", "rock", "home", "friend", "foehome", "foemarker", "friendfood", "foefood", "antlion",
        "northwest", "northeast", "east", "southeast", "southwest", "west", "left", "right", "here", "ahead"};


    public Program parseProgram(String codee, Random random, char swarm) {
        String code = filterString(codee);
        CharStream charStream = CharStreams.fromString(code);
        AcolaLexer lexer = new AcolaLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        AcolaParser parser = new AcolaParser(tokenStream);
        parser.setErrorHandler(new MyErrorStrategy());
        MyAcolaListener listener = new MyAcolaListener(random);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parser.brain());
        String name = listener.getName();
        List<Instruction> instructions = listener.getInstructions();
        checkValidity(name, instructions);
        return new Program(instructions, name, swarm);
    }

    private String filterString(String code) {
        if(code.length() < 5 || !"brain".equals(code.substring(0, 5))) {
            throw new IllegalArgumentException("Brain doesent start with \"brain\".");
        }
        /*
        String filtered = code.replaceAll("\r", "\n");
        filtered = filtered.replaceAll("\\/\\*.*?\\n.*?\\*\\/", "\n");
        return filtered.replaceAll("\\/\\*.*?\\*\\/", " ");
        */
        return code.replaceAll("\r", "\n");
    }

    private void checkValidity(String name, List<Instruction> instructions) {
        checkNameNoIdentifier(name);
        checkProgramSize(instructions);
        checkEndsWithJump(instructions);
        checkPcIndices(instructions);
        checkSetIndices(instructions);
        checkSenseIndices(instructions);
        checkTestIndices(instructions);
        checkMarkIndices(instructions);
        checkFlipParameter(instructions);
    }

    private void checkNameNoIdentifier(String name) {
        for(String identifier : identifiers) {
            if(identifier.equals(name)) {
                throw new IllegalArgumentException("Program name \"" + name + "\" is invalid due to it is a keyword");
            }
        }
    }

    private void checkProgramSize(List<Instruction> instructions) {
        if(instructions.size() > PROGRAM_MAX_SIZE) {
            throw new IllegalArgumentException("Program was larger than 2500 instructions.");
        }
    }

    private void checkEndsWithJump(List<Instruction> instructions) {
        if(!(instructions.get(instructions.size() - 1) instanceof JumpInstruction)) {
            throw new IllegalArgumentException("Program did not end with an Jump instruction.");
        }
    }

    private void checkPcIndices(List<Instruction> instructions) {
        int failIndex;
        for(Instruction instruction : instructions) {
            if(instruction instanceof FailableInstruction) {
                failIndex = ((FailableInstruction) instruction).getFailIndex();
                if(!(failIndex >= 0 && failIndex < instructions.size())) {
                    throw new IllegalArgumentException("The instruction  \"" + instruction.serialize() + "\" has an invalid jump index.");
                }
            }
        }
    }

    private void checkSetIndices(List<Instruction> instructions) {
        int registerIndex;
        for(Instruction instruction : instructions) {
            if(instruction instanceof SetInstruction) {
                registerIndex = ((SetInstruction) instruction).getRegister();
                if(!(registerIndex >= 0 && registerIndex < Brain.REGISTER_AMOUNT)) {
                    throw new IllegalArgumentException("The instruction \"" + instruction.serialize() + "\" has an invalid register index.");
                }
            }
        }
    }

    private void checkTestIndices(List<Instruction> instructions) {
        int registerIndex;
        for(Instruction instruction : instructions) {
            if(instruction instanceof TestInstruction) {
                registerIndex = ((TestInstruction) instruction).getRegisterIndex();
                if(!(registerIndex >= 0 && registerIndex < Brain.REGISTER_AMOUNT)) {
                    throw new IllegalArgumentException("The instruction \"" + instruction.serialize() + "\" has an invalid register index.");
                }
            }
        }
    }

    private void checkMarkIndices(List<Instruction> instructions) {
        int markerIndex;
        MarkInstruction markInstruction;
        for(Instruction instruction : instructions) {
            if(instruction instanceof MarkInstruction) {
                markInstruction = (MarkInstruction) instruction;
                markerIndex = markInstruction.getIndex();
                if(!(markerIndex >= 0 && markerIndex < Field.MARKER_AMOUNT)) {
                    throw new IllegalArgumentException("The instruction   \"" + instruction.serialize() + "\" has an invalid marker index.");
                }
            }
        }
    }

    private void checkSenseIndices(List<Instruction> instructions) {
        int markerIndex;
        SenseInstruction senseInstruction;
        for(Instruction instruction : instructions) {
            if(instruction instanceof SenseInstruction) {
                senseInstruction = (SenseInstruction) instruction;
                if(senseInstruction.getSensableObject() == SensableObject.marker) {
                    markerIndex = senseInstruction.getMarkerIndex();
                    if(!(markerIndex >= 0 && markerIndex < Field.MARKER_AMOUNT)) {
                        throw new IllegalArgumentException("The instruction   \"" + instruction.serialize() + "\" has an invalid marker index.");
                    }
                }
            }
        }
    }

    private void checkFlipParameter(List<Instruction> instructions) {
        FlipInstruction flipInstruction;
        for(Instruction instruction : instructions) {
            if(instruction instanceof FlipInstruction) {
                flipInstruction = (FlipInstruction) instruction;
                if(flipInstruction.getMax() < 0) {
                    throw new IllegalArgumentException("The instruction \"" + instruction.serialize() + "\" has an invalid flip max.");
                }
            }
        }
    }
}
