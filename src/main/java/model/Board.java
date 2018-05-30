package model;

import com.google.common.base.Strings;

public class Board {

    private final Piece[][] board;
    private final int dimensionX;
    private final int dimensionY;

    public Board() {
        this.dimensionX = 4;
        this.dimensionY = 4;
        this.board = new Piece[dimensionX][dimensionY];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Piece getPieceAtCell(final Coordinates coordinates) {
        checkCoordinates(coordinates);
        return board[coordinates.getX() - 1][coordinates.getY() - 1];
    }

    public boolean isOccupied(final Coordinates coordinates) {
        checkCoordinates(coordinates);
        return board[coordinates.getX() - 1][coordinates.getY() - 1] != null;
    }

    public void placePiece(final Piece piece, final Coordinates coordinates) {
        checkCoordinates(coordinates);
        if (isOccupied(coordinates)) {
            throw new IllegalArgumentException("Space is occupied");
        }
        board[coordinates.getX() - 1][coordinates.getY() - 1] = piece;
    }

    public String printBoard() {
        return printBoard(board);
    }

    protected String printBoard(final Piece[][] quartoBoard) {
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
        return "Board<" + hashCode() + ">\n" + printBoard();
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
