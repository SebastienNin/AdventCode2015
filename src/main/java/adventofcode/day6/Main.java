package adventofcode.day6;

import adventofcode.day5.ExerciceString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Lights light = new Lights();
        String fileName = "src/main/java/adventofcode/day6/input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                light.lightInstruction(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(light.getBrightness());

    }

}
