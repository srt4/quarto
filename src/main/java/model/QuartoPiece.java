package model;

import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

/**
 * Represents a QuartoPiece with all attributes defined as fields.
 */
public class QuartoPiece {

    private final Hue hue;
    private final Height height;
    private final Fill fill;
    private final Shape shape;
    private final int bitmask;

    public QuartoPiece(final Hue hue, final Height height, final Fill fill, final Shape shape) {
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
        return (height.ordinal()) +
                        (fill.ordinal() << 1) +
                        (hue.ordinal() << 2) +
                        (shape.ordinal() << 3);
    }

}