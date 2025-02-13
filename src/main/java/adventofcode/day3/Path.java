package adventofcode.day3;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class Path {

    @Getter
    @Setter
    private String path;
    @Getter
    @Setter
    private Set<String> visitedHouses = new HashSet<>();
    @Getter
    @Setter
    private Set<String> santaNumberOfVisitedHouses = new HashSet<>();
    @Getter
    @Setter
    private Set<String> robotSantaNumberOfVisitedHouses = new HashSet<>();
    @Getter
    @Setter
    private Set<String> santaPlusRobotSantaNumberOfVisitedHouses = new HashSet<>();
    @Getter
    @Setter
    private Integer numberOfDifferentHouses;
    @Getter
    @Setter
    private Integer numberOfHouses;
    @Getter
    @Setter
    private Integer santaNumberOfHouses;
    @Getter
    @Setter
    private Integer robotSantaNumberOfHouses;
    @Getter
    @Setter
    private Integer santaPlusRobotSantaNumberOfHouses;

    public Path(String path) {
        this.path = path;
        this.numberOfHouses = 0;
        this.presentDelivery();
        this.santaPlusRobotSantaNumberOfVisitedHouses.addAll(this.santaNumberOfVisitedHouses);
        this.santaPlusRobotSantaNumberOfVisitedHouses.addAll(this.robotSantaNumberOfVisitedHouses);
        this.santaPlusRobotSantaNumberOfHouses = santaPlusRobotSantaNumberOfVisitedHouses.size();
    }

    public void presentDelivery(){

        Integer x = 0;
        Integer y = 0;
        Integer santaX = 0;
        Integer santaY = 0;
        Integer robotSantaX = 0;
        Integer robotSantaY = 0;

        this.visitedHouses = addPath(this.visitedHouses, x, y);
        this.santaNumberOfVisitedHouses = addPath(this.santaNumberOfVisitedHouses, santaX, santaY);
        this.robotSantaNumberOfVisitedHouses = addPath(this.robotSantaNumberOfVisitedHouses, robotSantaX, robotSantaY);
        this.numberOfHouses++;

        for (int i = 0; i < this.path.length(); i++) {
            char direction = this.path.charAt(i);

            switch (direction) {
                case '^': y++; break;
                case 'v': y--; break;
                case '>': x++; break;
                case '<': x--; break;
            }

            this.visitedHouses = addPath(this.visitedHouses, x, y);
            this.numberOfHouses++;

            //if(i >= 1){

                if(i%2 == 0) {

                    switch (direction) {
                        case '^': santaY++; break;
                        case 'v': santaY--; break;
                        case '>': santaX++; break;
                        case '<': santaX--; break;
                    }

                    this.santaNumberOfVisitedHouses = addPath(this.santaNumberOfVisitedHouses, santaX, santaY);

                }else{

                    switch (direction) {
                        case '^': robotSantaY++; break;
                        case 'v': robotSantaY--; break;
                        case '>': robotSantaX++; break;
                        case '<': robotSantaX--; break;
                    }

                    this.robotSantaNumberOfVisitedHouses = addPath(this.robotSantaNumberOfVisitedHouses, robotSantaX, robotSantaY);

                }

            //}

        }

        this.numberOfDifferentHouses = this.visitedHouses.size();
        this.santaNumberOfHouses = this.santaNumberOfVisitedHouses.size();
        this.robotSantaNumberOfHouses = this.robotSantaNumberOfVisitedHouses.size();

    }

    public Set<String> addPath(Set<String> path, Integer x, Integer y){

        path.add(x + "," + y);
        return path;

    }

}
