package model;

import model.attribute.Hue;
import model.attribute.Height;
import model.attribute.Fill;
import model.attribute.Shape;


import java.util.Scanner;
import java.util.InputMismatchException;

public class CliPlayer implements Player {

    private final Scanner sc;

    public CliPlayer(Scanner scanner) {
        this.sc = scanner;
    }

    public QuartoPiece selectPiece(QuartoPieces pieces) {
        System.out.println("Select piece: ");
        //TODO: Use a function to map an integer to available pieces
        //return someMapFunction(sc.nextInt());
        return new QuartoPiece(Hue.LIGHT, Height.TALL, Fill.HOLLOW, Shape.CUBE);
    }

    public Coordinates selectCoordinates(QuartoPiece piece, QuartoBoard board) {
        int x = 0, y = 0;

        System.out.println(String.format("Select coordinates for %s piece: x, y\n", piece.toString()));
        x = getIntInBounds(0, board.getDimensionX());
        y = getIntInBounds(0, board.getDimensionY());

        return new Coordinates(x, y);
    }

    private int getIntInBounds(int min, int max) {
        int value = sc.nextInt();
        if (value < min || value > max)
            throw new InputMismatchException(String.format("Coordinate must be in range: [%d - %d]", min, max));
        else
            return value;
    }

}
