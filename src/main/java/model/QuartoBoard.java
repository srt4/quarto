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
        return board;
    }

    public QuartoPiece getPieceAtCell(final Coordinates coordinates) {
        checkCoordinates(coordinates);
        return board[coordinates.getX() - 1][coordinates.getY() - 1];
    }

    public boolean isOccupied(final Coordinates coordinates) {
        checkCoordinates(coordinates);
        return board[coordinates.getX() - 1][coordinates.getY() - 1] != null;
    }

    public void placePiece(final QuartoPiece piece, final Coordinates coordinates) {
        checkCoordinates(coordinates);
        if (isOccupied(coordinates)) {
            throw new IllegalArgumentException("Space is occupied");
        }
        board[coordinates.getX() - 1][coordinates.getY() - 1] = piece;
    }

    public String printBoard() {
        return printBoard(board);
    }

    protected String printBoard(final QuartoPiece[][] quartoBoard) {
        final StringBuilder sb = new StringBuilder();
        sb.append("     A    B    C    D\n");
        sb.append("    ").append(Strings.repeat("-", 19)).append("\n");
        for (int y = 0; y < quartoBoard.length; y++) {
            sb.append(y + 1).append(" ");
            for (int x = 0; x < quartoBoard[y].length; x++) {
                sb.append(" | ").append(quartoBoard[x][y] ==  null ? "  " : quartoBoard[x][y]);
                if (x == quartoBoard[y].length - 1) {
                    sb.append(" | ");
                }
            }
            sb.append("\n    ").append(Strings.repeat("-", 19)).append("\n");
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

    private void checkCoordinates(final Coordinates coordinates) {
        if (coordinates == null || coordinates.getX() > board.length || coordinates.getY() > board[0].length
                || coordinates.getX() < 1 || coordinates.getY() < 1) {
            throw new IllegalArgumentException("Invalid coordinates passed");
        }
    }

}
