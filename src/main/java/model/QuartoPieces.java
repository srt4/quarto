package model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

import java.util.List;
import java.util.Set;
import java.util.Iterator;

public class QuartoPieces {

    private final Set<QuartoPiece> pieces;

    public QuartoPieces() {
        this.pieces = Sets.newHashSet();
        this.pieces.addAll(createAllPieces());
    }

    public List<QuartoPiece> get() {
        return ImmutableList.copyOf(pieces);
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

    public void remove(final QuartoPiece piece) {
        pieces.remove(piece);
    }

    public boolean contains(final QuartoPiece piece) {
        return pieces.contains(piece);
    }

}
