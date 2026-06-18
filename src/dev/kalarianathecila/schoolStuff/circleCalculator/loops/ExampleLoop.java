package dev.kalarianathecila.schoolStuff.circleCalculator.loops;

public class ExampleLoop {

    public void simpleLoop() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
    }

    public void numbers0() {
        for (int i = 1; i <= 13; i += 2) {
            System.out.print(i + " | ");
        }
    }

    public void numbers1() {
        for (int i = 20; i >= 0; i -= 5) {
            System.out.print(i + " | ");
        }
    }

    public void lf() {
        System.out.println();
    }
    public void emptyLine() {
        System.out.println();
        System.out.println();
    }

    public void line(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
    }

    public void tripleLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print("X");
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
    }

    public void block(int diagonalLength) {
        for (int i = 0; i < diagonalLength; i++) {
            int j = i;
            lf();
            for (j = 0; j < diagonalLength; j++) {
                System.out.print("#");
            }
        }
    }

    public void triangle(int layerCount) {
        for (int i = 0; i < layerCount; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public void triangle2(int layerCount) {
        for (int i = layerCount; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public void triangle3(int layerCount) {
        for (int i = 0; i < layerCount; i++) {
            for (int j = 0; j < layerCount - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public void triangle4(int layerCount) {
        for (int i = 0; i < layerCount; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < layerCount - i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public void triangle5(int layerCount) {
        for (int i = 0; i < layerCount; i++) {
            for (int j = 0; j < layerCount - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public void hourglass(int layerCount) {
        for (int i = 0; i < layerCount; i++) {
            int spaces = Math.min(i, layerCount - 1 - i);
            int hashes = layerCount - 2 * spaces;
            for (int j = 0; j < spaces; j++) System.out.print(" ");
            for (int j = 0; j < hashes; j++) System.out.print("#");
            System.out.println();
        }
    }


    public void rotatedSquare(int layerCount) {
        for (int i = 0; i < layerCount; i++) {
            int spaces = Math.abs(i - (layerCount - 1) / 2);
            int hashes = layerCount - 2 * spaces;
            for (int j = 0; j < spaces; j++) System.out.print(" ");
            for (int j = 0; j < hashes; j++) System.out.print("#");
            System.out.println();
        }
    }

}
