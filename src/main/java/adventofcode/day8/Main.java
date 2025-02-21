package adventofcode.day8;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());

        String fileName = "src/main/java/adventofcode/day8/input.txt";

        ArrayList<String> strings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int totalCodeChars = 0;
        int totalStringChars = 0;

        for (String text : strings) {
            int codeChars = text.length();
            int stringChars = 0;

            for (int i = 1; i < text.length() - 1; i++) { // Ignore les guillemets de début et de fin
                char c = text.charAt(i);
                if (c == '\\') {
                    if (i + 1 < text.length()) {
                        char nextChar = text.charAt(i + 1);
                        if (nextChar == '\"' || nextChar == '\\') {
                            stringChars++;
                            i++; // Saute le caractère échappé
                        } else if (nextChar == 'x' && i + 3 < text.length()) {
                            stringChars++;
                            i += 3; // Saute les caractères de l'échappement hexadécimal
                        }
                    }
                } else {
                    stringChars++;
                }
            }

            totalCodeChars += codeChars;
            totalStringChars += stringChars;
        }

// Affiche les résultats
        logger.info("Total de caractères de code : " + totalCodeChars);
        logger.info("Total de caractères dans les données de la chaîne : " + totalStringChars);
        logger.info("Résultat: " + (totalCodeChars - totalStringChars));


    }
}