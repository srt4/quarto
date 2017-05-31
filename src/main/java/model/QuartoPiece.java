package model;

import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

/**
 * Represents a QuartoPiece with all attributes defined as fields.
 *
 * @author Spencer Thomas (srt4@uw.edu)
 */
public abstract class QuartoPiece {

    private final Hue hue;
    private final Height height;
    private final Fill fill;

    public QuartoPiece(final Hue hue, final Height height, final Fill fill) {
        this.hue = hue;
        this.height = height;
        this.fill = fill;
    }

    public abstract Shape getShape();

    public Hue getHue() {
        return hue;
    }

    public Height getHeight() {
        return height;
    }

    public Fill getFill() {
        return fill;
    }

}