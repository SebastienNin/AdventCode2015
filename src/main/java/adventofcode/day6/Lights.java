package adventofcode.day6;

import lombok.Getter;
import lombok.Setter;

public class Lights {

    @Getter
    @Setter
    int[][] lights = new int[1000][1000]; // Utiliser un tableau d'entiers pour la luminosité
    @Getter
    @Setter
    long brightness = 0;

    public Lights() {
        // Initialiser toutes les lumières à 0 (éteint)
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                this.lights[i][j] = 0;
            }
        }
    }

    public void lightInstruction(String instruction) {
        String[] instructions = instruction.split(" ");
        String startingInstruction = instructions[0];

        int posXStart = 0;
        int posXEnd = 0;
        int posYStart = Integer.parseInt(instructions[instructions.length - 1].split(",")[0]);
        int posYEnd = Integer.parseInt(instructions[instructions.length - 1].split(",")[1]);

        if (startingInstruction.equals("turn")) {
            posXStart = Integer.parseInt(instructions[2].split(",")[0]);
            posXEnd = Integer.parseInt(instructions[2].split(",")[1]);

            if (instructions[1].equals("on")) {
                processMultipleLights(posXStart, posYStart, posXEnd, posYEnd, "on");
            } else {
                processMultipleLights(posXStart, posYStart, posXEnd, posYEnd, "off");
            }
        } else {
            posXStart = Integer.parseInt(instructions[1].split(",")[0]);
            posXEnd = Integer.parseInt(instructions[1].split(",")[1]);

            processMultipleLights(posXStart, posYStart, posXEnd, posYEnd, "toggle");
        }
    }

    public void processMultipleLights(int posXStart, int posYStart, int posXEnd, int posYEnd, String process) {
        for (int i = posXStart; i <= posYStart; i++) {
            for (int j = posXEnd; j <= posYEnd; j++) {
                if (process.equals("on")) {
                    turnOnLight(i, j);
                } else if (process.equals("off")) {
                    turnOffLight(i, j);
                } else {
                    toggleLight(i, j);
                }
            }
        }
    }

    public void turnOnLight(int posX, int posY) {
        this.lights[posX][posY]++;
        this.brightness++;
    }

    public void turnOffLight(int posX, int posY) {
        if (this.lights[posX][posY] > 0) {
            this.lights[posX][posY]--;
            this.brightness--;
        }
    }

    public void toggleLight(int posX, int posY) {
        this.lights[posX][posY] += 2;
        this.brightness += 2;
    }
}