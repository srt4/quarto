package model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

import java.util.Arrays;
import java.util.Iterator;
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
        this.availablePieces = Sets.newHashSet(createAllPieces());
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

    private List<QuartoPiece> createAllPieces() {
        final List<QuartoPiece> pieces = Lists.newLinkedList();
        for (final Fill fill : Fill.values()) {
            for (final Height height : Height.values()) {
                for (final Hue hue : Hue.values()) {
                    for (final Shape shape : Shape.values()) {
                        pieces.add(PieceFactory.createPiece(shape, fill, height, hue));
                    }
                }
            }
        }
        return pieces;
    }

}