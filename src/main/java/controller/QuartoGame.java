package controller;

import model.Coordinates;
import model.QuartoBoard;
import model.QuartoBoardView;
import model.QuartoPiece;
import model.QuartoPieces;

import java.util.Scanner;

public class QuartoGame {

    private final QuartoBoard board;
    private final QuartoPieces availablePieces;
    private final Player p1;
    private final Player p2;

    public QuartoGame(final Player player1, final Player player2) {
        this.board = new QuartoBoard();
        this.availablePieces = new QuartoPieces();
        this.p1 = player1;
        this.p2 = player2;
    }

    public QuartoGame() {
        this.board = new QuartoBoard();
        this.availablePieces = new QuartoPieces();
        this.p1 = new CliPlayer(new Scanner(System.in), "P1"); // TODO: Is there where you'd have a factory?
        this.p2 = new DillyPlayer();
    }

    public void play() {
        Player currentPlayer = p1;
        Player previousPlayer = p2;

        /**
         * Flow of a move:
         *  - Previous player selects piece for current player
         *  - Current player places piece on board
         */
        while (!winConditionMet()) {
            final QuartoPiece selectedPiece = selectPiece(availablePieces, QuartoBoardView.of(board), previousPlayer);

            final Coordinates move = selectCoordinates(selectedPiece, QuartoBoardView.of(board), currentPlayer);
            board.placePiece(selectedPiece, move);
            availablePieces.remove(selectedPiece);

            Player swap = currentPlayer;
            currentPlayer = previousPlayer;
            previousPlayer = swap;
        }

        System.out.println("Winning player is " + (previousPlayer == p1 ? "P1!" : "P2!"));
    }

    private Coordinates selectCoordinates(final QuartoPiece piece, final QuartoBoard board, final Player player) {
        Coordinates coordinates;

        while (board.isOccupied((coordinates = player.selectCoordinates(piece, QuartoBoardView.of(board))))) {
            System.out.println("Coordinates occupied");
        }

        return coordinates;
    }

    private QuartoPiece selectPiece(final QuartoPieces pieces, final QuartoBoard board, final Player player) {
        QuartoPiece piece;

        while (!pieces.contains((piece = player.selectPiece(pieces.get(), board)))) {
            System.out.println("Piece unavailable");
        }

        return piece;
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

                sum &= quartoBoard[x][y].getBitmask();
            }

            if (sum > 0) {
                return true;
            }
        }

        return false;
    }

}
