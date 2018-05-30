package model;

import java.util.Arrays;

/**
 * A view of a Board with no modifications possible.
 */
public class BoardView extends Board {

    private final Board source;

    public static BoardView of(final Board source) {
        return new BoardView(source);
    }

    private BoardView(final Board source) {
        this.source = source;
    }

    @Override
    public Piece[][] getBoard() {
        return Arrays.copyOf(source.getBoard(), source.getBoard().length);
    }

    @Override
    public Piece getPieceAtCell(final Coordinates coordinates) {
        return source.getPieceAtCell(coordinates);
    }

    @Override
    public boolean isOccupied(final Coordinates coordinates) {
        return source.isOccupied(coordinates);
    }

    @Override
    public void placePiece(final Piece piece, final Coordinates coordinates) {
        throw new UnsupportedOperationException("Cannot modify state of board");
    }

    @Override
    public String printBoard() {
        return printBoard(source.getBoard());
    }

}