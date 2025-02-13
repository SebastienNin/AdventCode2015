package day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheminTest {

    private final Chemin chemin = new Chemin();

    @Test
    void getChemins() {

        chemin.setChemins("(())");
        assertEquals("(())", chemin.getChemins());

    }

    @Test
    void etageFinal() {

        chemin.setChemins("((())");
        assertEquals(1, chemin.etageFinal());
    }

    @Test
    void positionBasement(){

        chemin.setChemins("()())");
        chemin.etageFinal();
        assertEquals(5, chemin.getPremierBasement());

    }
}