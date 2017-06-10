package controller;

import model.Coordinates;
import model.QuartoBoard;
import model.QuartoPiece;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

/**
 * This player selects and places pieces randomly.
 */
public class DillyPlayer implements Player {

    private final Random random = new SecureRandom();

    @Override
    public QuartoPiece selectPiece(final List<QuartoPiece> pieces, final QuartoBoard board) {
        return pieces.get(random.nextInt(pieces.size() - 1));
    }

    @Override
    public Coordinates selectCoordinates(final QuartoPiece piece, final QuartoBoard board) {
        Coordinates coordinates;
        while (board.isOccupied((coordinates = new Coordinates(random.nextInt(3) + 1, random.nextInt(3) + 1))));
        return coordinates;
    }

}