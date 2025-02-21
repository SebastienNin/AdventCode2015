package day7;

import adventofcode.day7.Circuit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    Circuit circuit = new Circuit();
    String[] instructionsList = new String[]{
            "123 -> x",
            "456 -> y",
        "x AND y -> d",
        "x OR y -> e",

        "x LSHIFT 2 -> f",
        "y RSHIFT 2 -> g",
        "NOT x -> h",
        "NOT y -> i"
    };
    ArrayList<String> instructions = new ArrayList<>();

    @Test
    void getResults(){

        for(String instruction : instructionsList){
            instructions.add(instruction);

        }

        circuit.setInstructions(instructions);

        circuit.processInstructions(circuit.getInstructions());

        assertEquals(72, circuit.getValue("d"));
        assertEquals(507, circuit.getValue("e"));
        assertEquals(492, circuit.getValue("f"));
        assertEquals(114, circuit.getValue("g"));
        assertEquals(65412, circuit.getValue("h"));
        assertEquals(65079, circuit.getValue("i"));
        assertEquals(123, circuit.getValue("x"));
        assertEquals(456, circuit.getValue("y"));

    }

}