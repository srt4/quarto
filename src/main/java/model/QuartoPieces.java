package model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

import java.util.*;
import java.util.function.Consumer;

public class QuartoPieces implements Iterable<QuartoPiece> {

    private final SortedSet<QuartoPiece> pieces;

    public QuartoPieces() {
        this.pieces = Sets.newTreeSet(new Comparator<QuartoPiece>() {
            @Override
            public int compare(QuartoPiece o1, QuartoPiece o2) {
                return o1.getBitmask() - o2.getBitmask();
            }
        });
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
                        pieces.add(new QuartoPiece(hue, height, fill, shape));
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

    @Override
    public Iterator<QuartoPiece> iterator() {
        return pieces.iterator();
    }

    @Override
    public void forEach(Consumer<? super QuartoPiece> action) {
        pieces.forEach(action);
    }

    @Override
    public Spliterator<QuartoPiece> spliterator() {
        return pieces.spliterator();
    }

}