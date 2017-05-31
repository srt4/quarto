package model;

import java.util.Arrays;

/**
 *
 * @author Spencer Thomas (srt4@uw.edu)
 */
public class QuartoBoard {

    private final QuartoPiece[][] board;

    public QuartoBoard() {
        this.board = new QuartoPiece[4][4];
    }

    public QuartoPiece[][] getBoard() {
        return Arrays.copyOf(board, board.length);
    }

    public QuartoPiece getPieceAtCell(final int x, final int y) {
        return isOccupied(x, y) ? board[x][y] : null;
    }

    public boolean isOccupied(final int x, final int y) {
        return board[x][y] != null;
    }

    public void placePiece(final QuartoPiece piece, final int x, final int y) {
        board[x][y] = piece;
    }

}
