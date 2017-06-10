package model;

import java.util.Arrays;

/**
 * A view of a QuartoBoard with no modifications possible.
 */
public class QuartoBoardView extends QuartoBoard {

    private final QuartoBoard source;

    public static QuartoBoardView of(final QuartoBoard source) {
        return new QuartoBoardView(source);
    }

    private QuartoBoardView(final QuartoBoard source) {
        this.source = source;
    }

    @Override
    public QuartoPiece[][] getBoard() {
        return Arrays.copyOf(source.getBoard(), source.getBoard().length);
    }

    @Override
    public QuartoPiece getPieceAtCell(final Coordinates coordinates) {
        return source.getPieceAtCell(coordinates);
    }

    @Override
    public boolean isOccupied(final Coordinates coordinates) {
        return source.isOccupied(coordinates);
    }

    @Override
    public void placePiece(final QuartoPiece piece, final Coordinates coordinates) {
        throw new UnsupportedOperationException("Cannot modify state of board");
    }

    @Override
    public String printBoard() {
        return printBoard(source.getBoard());
    }

}