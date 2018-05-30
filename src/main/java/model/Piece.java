package model;

import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;
import model.util.PieceToStringHelper;

/**
 * Represents a Piece with all attributes defined as fields.
 */
public class Piece {

    private final Hue hue;
    private final Height height;
    private final Fill fill;
    private final Shape shape;
    private final int bitmask;

    public Piece(final Hue hue, final Height height, final Fill fill, final Shape shape) {
        this.hue = hue;
        this.height = height;
        this.fill = fill;
        this.shape = shape;
        this.bitmask = generateBitmask();
    }

    public Shape getShape() {
        return shape;
    }

    public Hue getHue() {
        return hue;
    }

    public Height getHeight() {
        return height;
    }

    public Fill getFill() {
        return fill;
    }

    public int getBitmask() {
        return bitmask;
    }

    @Override
    public String toString() {
        return PieceToStringHelper.toString(this);
    }

    private int generateBitmask() {
        return (1 << (fill.ordinal())) +
                (1 << (2 + height.ordinal())) +
                (1 << (4 + shape.ordinal())) +
                (1 << (6 + hue.ordinal()));
    }

}