package model;

public class QuartoGame {
    
    private final QuartoBoard board;
    private final QuartoPieces availablePieces;
    public final Player p1;
    public final Player p2;
    
    public QuartoGame() {
        this.board = new QuartoBoard();
        this.availablePieces = new QuartoPieces();
        this.p1 = new CliPlayer();
        this.p2 = new CliPlayer();
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

    public Player play() {
        Player currentPlayer = p1;
        QuartoPiece piece = null;

        piece = currentPlayer.selectPiece(availablePieces);
        currentPlayer = (currentPlayer == p1 ? p2 : p1);

        while (!winConditionMet()) {
            // current player places the piece chose by previous player
            // TODO: Could this be a 'validateMove()' function?
            while (true) {
                Move nextMove = currentPlayer.makeMove(piece, ImmutableQuartoBoard.copyOf(board));   // TODO: Do we need to pass board here? What about in player CTOR?
                if (!board.isOccupied(nextMove.getX(), nextMove.GetY()))
                    break;
                else
                    System.out.println("Cell occupied");
            }

            // current player chooses piece from available peices for next player
            // TODO: Could this be a 'validatePiece()' function?
            while (true) {
                piece = currentPlayer.selectPiece(availablePieces);
                if (availablePieces.contains(piece))
                    break;
                else
                    System.out.println("Piece unavailable");
            }

            currentPlayer = (currentPlayer == p1 ? p2 : p1);

            // TODO: Check if there no pieces left
        }

        return currentPlayer;
    }

}
