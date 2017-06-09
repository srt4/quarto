package model;

import java.util.Scanner;

public class QuartoGame {
    
    private final QuartoBoard board;
    private final QuartoPieces availablePieces;
    private final Player p1;
    private final Player p2;
    
    public QuartoGame() {
        this.board = new QuartoBoard();
        this.availablePieces = new QuartoPieces();
        this.p1 = new CliPlayer(new Scanner(System.in), "P1"); // TODO: Is there where you'd have a factory?
        this.p2 = new CliPlayer(new Scanner(System.in), "P2");
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

    public int play() {
        Player currentPlayer = p1;
        QuartoPiece piece = null;
        Coordinates coords;

        piece = currentPlayer.selectPiece(availablePieces.get(), (board));
        currentPlayer = (currentPlayer == p1 ? p2 : p1);

        while (!winConditionMet()) {
            // current player places the piece chose by previous player
            // TODO: Could this be a 'validateMove()' function?
            // TODO: What if the player just keeps making the same move? Cap
            // the number of tries? Mayb
            while (true) {
                coords = currentPlayer.selectCoordinates(piece, (board));
                if (!board.isOccupied(coords.getX(), coords.getY()))
                    break;
                else
                    System.out.println("Coordinates occupied");
            }

            // current player chooses piece from available peices for next player
            // TODO: Could this be a 'validatePiece()' function?
            while (true) {
                piece = currentPlayer.selectPiece(availablePieces.get(), (board));
                if (availablePieces.contains(piece))
                    break;
                else
                    System.out.println("Piece unavailable");
            }

            board.placePiece(piece, coords.getX(), coords.getY());
            availablePieces.remove(piece);

            currentPlayer = (currentPlayer == p1 ? p2 : p1);

            // TODO: Check if there no pieces left
        }

        return 0;
    }

    private boolean winConditionMet() {
        QuartoPiece[][] quartoBoard = board.getBoard();
        // left to right
        for (int y = 0; y < quartoBoard[0].length; y++) {
            int sum = 0b1111111;

            for (int x = 0; x < quartoBoard.length; x++) {
                if (quartoBoard[x][y] == null) {
                    sum = 0;
                    break;
                }

                sum &= quartoBoard[x][y].getBitmask();
            }

            if (sum > 0) {
                System.out.println("Win found");
                return true;
            }
        }
        // top to bottom
        for (int x = 0 ; x < quartoBoard.length; x++) {
            int sum = 0b1111111;

            for (int y = 0; y < quartoBoard[x].length; y++) {
                if (quartoBoard[x][y] == null) {
                    sum = 0;
                    break;
                }

                sum &= quartoBoard[x][y].getBitmask();
            }

            if (sum > 0) {
                System.out.println("Win found");
                return true;
            }
        }
        // diagonally
        {
            int sum = 0b1111111;
            for (int x = 0, y = 0; x < quartoBoard.length && y < quartoBoard[0].length; x++, y++) {
                if (quartoBoard[x][y] == null) {
                    sum = 0;
                    break;
                }

                sum &= quartoBoard[x][y].getBitmask();
            }

            if (sum > 0) {
                System.out.println("Win found");
                return true;
            }
        }
        {
            int sum = 0b1111111;
            for (int x = 0, y = quartoBoard[0].length - 1; x < quartoBoard.length && y >= 0; x++, y--) {
                if (quartoBoard[x][y] == null) {
                    sum = 0;
                    break;
                }

                System.out.println("Testing diagonal: ");
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println(quartoBoard[x][y]);
                sum &= quartoBoard[x][y].getBitmask();
            }

            if (sum > 0) {
                System.out.println("Win found");
                return true;
            }
        }

        return false;
    }

}
