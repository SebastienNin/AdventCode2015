package day5;

import adventofcode.day5.ExerciceString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciceStringTest {

    ExerciceString string6 = new ExerciceString("qjhvhtzxzqqjkmpb");
    ExerciceString string7 = new ExerciceString("xxyxx");
    ExerciceString string8 = new ExerciceString("uurcxstgmygtbstg");
    ExerciceString string9 = new ExerciceString("ieodomkazucvgmuy");

    @Test
    public void getNiceString() {

        assertTrue(string6.isNiceString());
        assertTrue(string7.isNiceString());
        assertFalse(string8.isNiceString());
        assertFalse(string9.isNiceString());

    }

}
