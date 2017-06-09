package model;

import com.google.common.base.Preconditions;
import model.attribute.Hue;
import model.attribute.Height;
import model.attribute.Fill;
import model.attribute.Shape;


import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CliPlayer implements Player {

    private final Scanner sc;
    private final String playerName;

    public CliPlayer(Scanner scanner, String playerName) {
        this.sc = scanner;
        this.playerName = playerName;
    }

    public QuartoPiece selectPiece(List<QuartoPiece> pieces, QuartoBoard board) {
        System.out.println(board.printBoard() + "\n");
        printMessage("Select piece: ");

        int i = 0;
        for (final QuartoPiece piece : pieces) {
            System.out.println(" - [" + ++i + "] " + piece);
        }

        return pieces.get(getIntInBounds(1, i) - 1);
    }

    public Coordinates selectCoordinates(QuartoPiece piece, QuartoBoard board) {
        int x = 0, y = 0;

        System.out.println(board.printBoard());
        printMessage(String.format("Select coordinates for %s piece: x, y", piece.toString()));
        x = getIntInBounds(1, board.getDimensionX());
        y = getIntInBounds(1, board.getDimensionY());

        return new Coordinates(x, y);
    }

    private int getIntInBounds(int min, int max) {
        Integer value = null;

        do {
            printMessage("Please enter a number between " +
                        min + " and " + max + ": ");
            try {
                value = sc.nextInt();
            }
            catch (Exception e) {
                printMessage("Please enter a number: ");
            }
        } while (value != null && !(value >= min || value <= max));

        return Preconditions.checkNotNull(value);
    }

    private void printMessage(final String message) {
        System.out.println("[" + playerName + "]: " + message);
    }

}
