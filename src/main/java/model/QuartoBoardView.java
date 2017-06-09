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
        // TODO make a copy of this
        return source.getBoard();
    }

    @Override
    public QuartoPiece getPieceAtCell(final int x, final int y) {
        return source.getPieceAtCell(x, y);
    }

    @Override
    public boolean isOccupied(final int x, final int y) {
        return source.isOccupied(x, y);
    }

    @Override
    public void placePiece(final QuartoPiece piece, final int x, final int y) {
        throw new UnsupportedOperationException("Cannot modify state of board");
    }

}