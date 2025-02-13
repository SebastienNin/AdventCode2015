package Day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaperTest {

    private Paper paperOne = new Paper(2, 3, 4);
    private Paper paperTwo = new Paper(1, 1, 10);

    @Test
    void calculateAreaHeightWidth() {

        assertEquals(6, paperOne.calculateArea(paperOne.getHeight(), paperOne.getWidth()));
        assertEquals(1, paperTwo.calculateArea(paperTwo.getHeight(), paperTwo.getWidth()));

    }

    @Test
    void calculateAreaHeightLength() {

        assertEquals(12, paperOne.calculateArea(paperOne.getHeight(), paperOne.getLength()));
        assertEquals(10, paperTwo.calculateArea(paperTwo.getHeight(), paperTwo.getLength()));

    }

    @Test
    void calculateAreaWidthLength() {

        assertEquals(8, paperOne.calculateArea(paperOne.getWidth(), paperOne.getLength()));
        assertEquals(10, paperTwo.calculateArea(paperTwo.getWidth(), paperTwo.getLength()));

    }

    @Test
    void calculateExtraPaper() {

        assertEquals(6, paperOne.getExtraPaper());
        assertEquals(1, paperTwo.getExtraPaper());
    }

    @Test
    void calculateAnswer1(){

        assertEquals(58, paperOne.getAnswer());
        assertEquals(43, paperTwo.getAnswer());
    }

    @Test
    void calculateSmallestPerimeter() {
        assertEquals(10, paperOne.getSmallestPerimeter());
        assertEquals(4, paperTwo.getSmallestPerimeter());
    }

    @Test
    void calculateAnswer2(){

        assertEquals(34, paperOne.getRibbon());
        assertEquals(14, paperTwo.getRibbon());
    }


}