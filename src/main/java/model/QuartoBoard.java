package model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Spencer Thomas (srt4@uw.edu)
 */
public class QuartoBoard {

    private final Set<QuartoPiece> availablePieces;
    private final QuartoPiece[][] board;

    public QuartoBoard() {
        this.availablePieces = Sets.newHashSet();
        this.board = new QuartoPiece[4][4];
    }

    public List<QuartoPiece> getAvailablePieces() {
        return ImmutableList.copyOf(availablePieces);
    }

    public QuartoPiece[][] getBoard() {
        return Arrays.copyOf(board, board.length);
    }

    public void makeTurn(final QuartoPiece piece, final int x, final int y) {
        if (!availablePieces.contains(piece)) {
            throw new IllegalArgumentException("Piece cannot be played as it is not available.");
        }

        if (board[x][y] != null) {
            throw new IllegalArgumentException("Piece cannot be played as space is occupied. Occupant=" + board[x][y]);
        }
        
        board[x][y] = piece;
        availablePieces.remove(piece);
    }

}