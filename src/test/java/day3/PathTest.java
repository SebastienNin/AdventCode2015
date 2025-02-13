package day3;

import adventofcode.day3.Path;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathTest {

    Path path1 = new Path(">");
    Path path2 = new Path("^>v<");
    Path path3 = new Path("^v^v^v^v^v");
    Path path4 = new Path("^v");

    @Test
    public void getDifferentHouse(){

        assertEquals(2, path1.getNumberOfDifferentHouses());
        assertEquals(4, path2.getNumberOfDifferentHouses());
        assertEquals(2, path3.getNumberOfDifferentHouses());
    }

    @Test
    public void getHouses(){

        assertEquals(2, path1.getNumberOfHouses());
        assertEquals(5, path2.getNumberOfHouses());
        assertEquals(11, path3.getNumberOfHouses());

    }

    @Test
    public void getSantaHouseNumber(){

        assertEquals(2, path4.getSantaNumberOfHouses());
        assertEquals(2, path2.getSantaNumberOfHouses());
        assertEquals(6, path3.getSantaNumberOfHouses());

    }

    @Test
    public void getRobotSantaHouseNumber(){

        assertEquals(2, path4.getRobotSantaNumberOfHouses());
        assertEquals(2, path2.getRobotSantaNumberOfHouses());
        assertEquals(6, path3.getRobotSantaNumberOfHouses());

    }

    @Test
    public void getSantaPlusRobotSantaHouseNumber(){

        /*assertEquals(3, path1.getSantaNumberOfHouses() + path1.getRobotSantaNumberOfHouses());
        assertEquals(3, path2.getSantaNumberOfHouses() + path2.getRobotSantaNumberOfHouses());
        assertEquals(11, path3.getSantaNumberOfHouses() + path3.getRobotSantaNumberOfHouses());*/

        assertEquals(3, path4.getSantaPlusRobotSantaNumberOfHouses());
        assertEquals(3, path2.getSantaPlusRobotSantaNumberOfHouses());
        assertEquals(11, path3.getSantaPlusRobotSantaNumberOfHouses());

    }

}
