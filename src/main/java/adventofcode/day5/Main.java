package adventofcode.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<ExerciceString> list = new ArrayList<>();
        String fileName = "src/main/java/Day5/input.txt";

        Integer finalAnswer1 = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                ExerciceString exerciceString = new ExerciceString(line);
                if(exerciceString.isNiceString()){
                    finalAnswer1++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(finalAnswer1);

    }

}
