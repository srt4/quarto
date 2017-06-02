package model;

public class Move {

    private final QuartoPiece piece;
    private final int x;
    private final int y;

    public Move(final QuartoPiece piece, final int x, final int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }
}
