package adventofcode.day7;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Circuit {

    @Getter
    @Setter
    private ArrayList<String> instructions = new ArrayList<>();
    @Getter
    private Map<String, Integer> wires = new HashMap<>();
    @Getter
    @Setter
    private ArrayList<Integer> usedIndexes = new ArrayList<>();

    public void processInstructions(ArrayList<String> instructions) {
        Pattern pattern = Pattern.compile("([a-z0-9]+)? ?(AND|OR|LSHIFT|RSHIFT|NOT)? ?([a-z0-9]+)? -> ([a-z]+)");
        boolean progress = true;

        while (progress) {
            progress = false;
            for (int i = 0; i < instructions.size(); i++) {
                if (usedIndexes.contains(i)) continue;

                String instruction = instructions.get(i);
                Matcher matcher = pattern.matcher(instruction);
                if (matcher.matches()) {
                    String input1 = matcher.group(1);
                    String operation = matcher.group(2);
                    String input2 = matcher.group(3);
                    String output = matcher.group(4);

                    if (operation == null) {
                        if (isValueAvailable(input1)) {
                            int value = getValue(input1);
                            wires.put(output, value);
                            usedIndexes.add(i);
                            progress = true;
                        }
                    } else if ("NOT".equals(operation) && isValueAvailable(input2)) {
                        int value = ~getValue(input2) & 0xFFFF;
                        wires.put(output, value);
                        usedIndexes.add(i);
                        progress = true;
                    } else if (operation != null && isValueAvailable(input1) && isValueAvailable(input2)) {
                        int value = 0;
                        switch (operation) {
                            case "AND":
                                value = getValue(input1) & getValue(input2);
                                break;
                            case "OR":
                                value = getValue(input1) | getValue(input2);
                                break;
                            case "LSHIFT":
                                value = getValue(input1) << getValue(input2);
                                break;
                            case "RSHIFT":
                                value = getValue(input1) >> getValue(input2);
                                break;
                        }
                        wires.put(output, value);
                        usedIndexes.add(i);
                        progress = true;
                    }
                }
            }
        }
    }

    private boolean isValueAvailable(String wire) {
        return wire != null && (wire.matches("\\d+") || wires.containsKey(wire));
    }

    public int getValue(String wire) {
        if (wire == null) {
            return 0; // ou une autre valeur par défaut appropriée
        }
        if (wire.matches("\\d+")) {
            return Integer.parseInt(wire);
        }
        return wires.getOrDefault(wire, 0);
    }

    public void displayWires() {
        for (Map.Entry<String, Integer> entry : wires.entrySet()) {
            System.out.println("Clé: " + entry.getKey() + ", Valeur: " + entry.getValue());
        }
    }
}