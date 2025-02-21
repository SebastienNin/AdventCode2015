package day6;

import adventofcode.day6.Lights;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    Lights lights2 = new Lights();
    Lights lights3 = new Lights();

    @Test
    public void brightness(){

        lights2.lightInstruction("turn on 0,0 through 0,0");

        assertEquals(1, lights2.getBrightness());

        lights3.lightInstruction("toggle 0,0 through 999,999");

        assertEquals(2000000, lights3.getBrightness());

    }

}
