package saarland.cispa.sopra;

import saarland.cispa.sopra.saarmeisen.Game;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

public final class Main {

    private Main() {

    }


    public static void main(String args[]) {

        String protocolFile = null;
        String worldPath = null;
        String[] brains = null;
        int rounds = -1;
        long seed = -1;

        // read I/O (cmdline)
        try {
            for (int strIndex = 0; strIndex < args.length; strIndex++) {

                String current = args[strIndex];
                switch (current) {
                    case "--protocol":
                        protocolFile = args[++strIndex];
                        break;
                    case "--brains":
                        brains = args[++strIndex].split(",");
                        break;
                    case "--rounds":
                        rounds = Integer.parseInt(args[++strIndex]);
                        break;
                    case "--seed":
                        seed = Long.parseLong(args[++strIndex]);
                        break;
                    case "--world":
                        worldPath = args[++strIndex];
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid parameter " + current);
                }
            }
        } catch (NumberFormatException|IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("illegal parameters", e);
        }

        checkSanity(worldPath, brains, rounds, seed);

        Game game = new Game();
        if(protocolFile != null){
            game.setWriteLog(true);
        }

        File worldFile = new File(worldPath);
        File[] brainsFiles = Arrays.stream(brains).map(File::new).toArray(File[]::new);

        game.simulate(rounds, seed, worldFile, brainsFiles);

        game.printResults();


        writeProtocol(protocolFile, game);

    }

    private static void checkSanity(String worldPath, String[] brains, int rounds, long seed) {
        if(seed == -1 || rounds == -1 || worldPath == null || brains == null){
            throw new IllegalArgumentException("required parameter is missing!");
        }
    }

    private static void writeProtocol(String protocolFile, Game game){
        if(protocolFile == null)  {
            return;
        }
        // TODO gzip usw

        String logg = game.serialize();


        try {

            File logFile = new File(protocolFile);
            boolean res = logFile.createNewFile();
            if(!res){
                Logger.getAnonymousLogger().log(Level.FINEST, "I have overwritten this file");
            }


            OutputStream foss = Files.newOutputStream(Paths.get(logFile.getPath()));

            OutputStream finalOs = foss;
            if(protocolFile.endsWith(".gz")){
                finalOs = new GZIPOutputStream(foss);
            }

            BufferedWriter buffwrite = new BufferedWriter(new PrintWriter(finalOs, true, Charset.forName("UTF-8")));

            buffwrite.write(logg);
            buffwrite.flush();
            buffwrite.close();

            foss.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

}
