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

public class Pieces implements Iterable<Piece> {

    private final SortedSet<Piece> pieces;

    public Pieces() {
        this.pieces = Sets.newTreeSet(new Comparator<Piece>() {
            @Override
            public int compare(Piece o1, Piece o2) {
                return o1.getBitmask() - o2.getBitmask();
            }
        });
        this.pieces.addAll(createAllPieces());
    }

    public List<Piece> get() {
        return ImmutableList.copyOf(pieces);
    }

    private List<Piece> createAllPieces() {
        final List<Piece> pieces = Lists.newLinkedList();
        for (final Fill fill : Fill.values()) {
            for (final Height height : Height.values()) {
                for (final Hue hue : Hue.values()) {
                    for (final Shape shape : Shape.values()) {
                        pieces.add(new Piece(hue, height, fill, shape));
                    }
                }
            }
        }
        return pieces;
    }

    public void remove(final Piece piece) {
        pieces.remove(piece);
    }

    public boolean contains(final Piece piece) {
        return pieces.contains(piece);
    }

    @Override
    public Iterator<Piece> iterator() {
        return pieces.iterator();
    }

    @Override
    public void forEach(Consumer<? super Piece> action) {
        pieces.forEach(action);
    }

    @Override
    public Spliterator<Piece> spliterator() {
        return pieces.spliterator();
    }

}