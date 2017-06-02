package model;

import model.attribute.Hue;
import model.attribute.Height;
import model.attribute.Fill;
import model.attribute.Shape;


import java.util.Scanner;
import java.util.InputMismatchException;

public class CliPlayer implements Player {

    private final Scanner sc;

    public CliPlayer() {
        this.sc = new Scanner(System.in);
    }

    public QuartoPiece selectPiece() {
        System.out.println("Select piece: ");
        //TODO: Use a function to map an integer to available pieces
        //return someMapFunction(sc.nextInt());
        return new QuartoPiece(Hue.LIGHT, Height.TALL, Fill.HOLLOW, Shape.CUBE);
    }

    public int selectCoord(String axis, int min, int max) {
        int value = -1;

        while (value == -1) {
            System.out.println("Select '" + axis + "' coordinate: ");
            try {
                value = sc.nextInt();
                if (value < min || value > max)
                    throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println(String.format("'%s' must be in range: [%s - %s]", axis, min, max));
            }
        }

        return value;
    }

}