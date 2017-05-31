package model;

public class QuartoGame {
    
    private final QuartoBoard board;
    private final QuartoPieces availablePieces;
    // TODO: Implement player class
    // public final Player p1;
    // public final Player p2;
    
    public QuartoGame() {
        this.board = new QuartoBoard();
        this.availablePieces = new QuartoPieces();
    }

    public void makeTurn(final QuartoPiece piece, final int x, final int y) {
        if (!availablePieces.contains(piece)) {
            throw new IllegalArgumentException("Piece cannot be played as it is not available.");
        }

        if (board.isOccupied(x, y)) {
            throw new IllegalArgumentException("Piece cannot be played as space is occupied. Occupant=" + board.getPieceAtCell(x, y));
        }
        
        board.placePiece(piece, x, y);
        availablePieces.remove(piece);
    }

}
