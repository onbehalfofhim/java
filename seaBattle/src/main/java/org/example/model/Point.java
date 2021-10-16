package org.example.model;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Point {
    private static final String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private static final Random random = new Random();
    private int x;  //хранится от 0 до 9
    private int y;  //хранится от 0 до 9


    public Point(int x, int y) throws InvalidDataException {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws InvalidDataException {
        if (x < 0 || x > 9) {
            throw new InvalidDataException("Invalid column's value");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws InvalidDataException {
        if (y < 0 || y > 9) {
            throw new InvalidDataException("Invalid raw's value");
        }
        this.y = y;
    }

    public static Point fromString(String coordinate) throws InvalidDataException {
        int tempX = Arrays.asList(letters).indexOf(coordinate.substring(0, 1));
        int tempY = Integer.parseInt(coordinate.substring(1));
        return new Point(tempX, tempY - 1);
    }

    public static Point createRandom() {
        int tempX = random.nextInt(9 - 0 + 1) + 0;
        int tempY = random.nextInt(9 - 0 + 1) + 0;
        try {
            return new Point(tempX, tempY);
        } catch (InvalidDataException ide) {
            return null; //never happens :)))
        }
    }

    public static void main(String[] args) throws InvalidDataException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter coordinates");
        String coord = input.nextLine();
        Point point = fromString(coord);
        System.out.println(point.getX() + ", " + point.getY());
        Point point1 = createRandom();
        System.out.println(point1.getX() + ", " + point1.getY());
    }
}
