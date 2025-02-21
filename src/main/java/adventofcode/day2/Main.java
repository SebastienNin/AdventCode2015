package adventofcode.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Paper> list = new ArrayList<>();
        String fileName = "src/main/java/adventofcode/day2/ribbon.txt";

        Integer finalAnswer1 = 0;
        Integer finalAnswer2 = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Paper loopPaper = new Paper(Integer.parseInt(line.split("x")[0]),
                        Integer.parseInt(line.split("x")[1]),
                        Integer.parseInt(line.split("x")[2]));
                list.add(loopPaper);
                finalAnswer1 = finalAnswer1 + loopPaper.getAnswer();
                finalAnswer2 = finalAnswer2 + loopPaper.Ribbon;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(finalAnswer1);
        System.out.println(finalAnswer2);


    }

}
