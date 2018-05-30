package player.robotic;

import model.Coordinates;
import model.Piece;
import model.Board;
import player.Player;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

/**
 * This player selects and places pieces randomly.
 */
public class ChaosPlayer implements Player {

    private final Random random = new SecureRandom();

    @Override
    public Piece selectPiece(final List<Piece> pieces, final Board board) {
        final Piece decision = pieces.get(random.nextInt(pieces.size() - 1));
        System.out.println("[ChaosPlayer] I'm playing this piece: " + decision);
        return decision;
    }

    @Override
    public Coordinates selectCoordinates(final Piece piece, final Board board) {
        Coordinates coordinates;
        while (board.isOccupied((coordinates =
                new Coordinates(random.nextInt(3) + 1, random.nextInt(3) + 1))));
        System.out.println("[ChaosPlayer] I'm selecting these coordinates: " + coordinates);
        return coordinates;
    }

}