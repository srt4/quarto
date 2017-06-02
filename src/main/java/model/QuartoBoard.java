package model;

import com.google.common.base.Strings;

import java.util.Arrays;

public class QuartoBoard {

    private final QuartoPiece[][] board;
    private final int dimensionX;
    private final int dimensionY;

    public QuartoBoard() {
        this.dimensionX = 4;
        this.dimensionY = 4;
        this.board = new QuartoPiece[dimensionX][dimensionY];
    }

    public QuartoPiece[][] getBoard() {
        return Arrays.copyOf(board, board.length);
    }

    public QuartoPiece getPieceAtCell(final int x, final int y) {
        return board[x][y];
    }

    public boolean isOccupied(final int x, final int y) {
        return board[x][y] != null;
    }

    public void placePiece(final QuartoPiece piece, final int x, final int y) {
        board[x][y] = piece;
    }

    public String printBoard() {
        final StringBuilder sb = new StringBuilder();
        sb.append("  ").append(Strings.repeat("-", 19)).append("\n");
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                sb.append(" | ").append(board[y][x]);
                if (x == board[y].length - 1) {
                    sb.append(" | ");
                }
            }
            sb.append("\n  ").append(Strings.repeat("-", 19)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "QuartoBoard<" + hashCode() + ">\n" + printBoard();
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

}
