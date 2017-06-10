package controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import model.Coordinates;
import model.QuartoBoard;
import model.QuartoPiece;


import java.util.List;
import java.util.Scanner;

public class CliPlayer implements Player {

    private final Scanner sc;
    private final String playerName;

    public CliPlayer(Scanner scanner, String playerName) {
        this.sc = scanner;
        this.playerName = playerName;
    }

    public QuartoPiece selectPiece(List<QuartoPiece> pieces, QuartoBoard board) {
        System.out.println();
        System.out.println(board.printBoard());
        printMessage("Select piece for next player: ");

        int i = 0;
        for (final QuartoPiece piece : pieces) {
            System.out.print(" [" + (++i < 10 ? " " + i : i) + "] " + piece + "    ");

            // print four pieces per line, and after last piece
            if (i % 4 == 0 || i == pieces.size()) {
                System.out.println();
            }
        }

        return pieces.get(getIntInBounds(1, i) - 1);
    }

    public Coordinates selectCoordinates(QuartoPiece piece, QuartoBoard board) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(board.printBoard());

        printMessage(String.format("Select coordinates for %s piece: x, y", piece.toString()));
        int x = getIntByLetterInBounds(1, board.getDimensionX());
        int y = getIntInBounds(1, board.getDimensionY());

        return new Coordinates(x, y);
    }

    private int getIntInBounds(int min, int max) {
        Integer value = null;

        do {
            printMessage("Please enter a number between " + min + " and " + max + ": ");
            try {
                value = sc.nextInt();
            }
            catch (Exception e) {
                /* do nothing */
            }
        } while (value == null || !(value >= min && value <= max));

        return Preconditions.checkNotNull(value);
    }

    private int getIntByLetterInBounds(int min, int max) {
        Integer value = null;

        do {
            printMessage("Please enter a letter between " + (char)('A' + min - 1) + " and " + (char)('A' + max - 1)
                    + ": ");
            try {
                final String line = sc.next();
                if (line.length() != 1) {
                    continue;
                }
                value = (int)line.toUpperCase().charAt(0) - (int)'A' + 1;
            }
            catch (Exception e) {
                /* do nothing */
            }
        }
        while (value == null || !(value >= min && value <= max));

        return Preconditions.checkNotNull(value);
    }

    private void printMessage(final String message) {
        System.out.println("[" + playerName + "]: " + message);
    }

}
