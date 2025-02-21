package adventofcode.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String fileName = "src/main/java/adventofcode/day7/input.txt";

        Circuit circuit = new Circuit();
        ArrayList<String> instructions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                instructions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        circuit.setInstructions(instructions);
        circuit.processInstructions(circuit.getInstructions());

        // Vérifier si le fil 'a' est présent
        if (circuit.getWires().containsKey("a")) {
            int signalA = circuit.getWires().get("a");
            System.out.println(signalA);

            // Affecter ce signal au fil b et réinitialiser les autres fils
            /*circuit.getWires().clear();
            circuit.getWires().put("b", signalA);
            circuit.displayWires();
            circuit.getUsedIndexes().clear();

            // Recalculer le signal sur le fil a
            circuit.processInstructions(circuit.getInstructions());*/

            if (circuit.getWires().containsKey("a")) {
                int newSignalA = circuit.getWires().get("a");
                System.out.println("Le nouveau signal sur le fil a est : " + newSignalA);
            } else {
                System.out.println("Le fil 'a' n'a pas été calculé après réinitialisation.");
            }
        } else {
            System.out.println("Le fil 'a' n'a pas été calculé.");
        }
    }
}