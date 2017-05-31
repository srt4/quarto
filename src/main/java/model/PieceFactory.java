package model;

import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

/**
 *
 * @author Spencer Thomas (srt4@uw.edu)
 */
public class PieceFactory {

    public static QuartoPiece createPiece(final Shape shape, final Fill fill, final Height height, final Hue hue) {
        switch (shape) {
            case CYLINDER:
                return new Cylinder(hue, height, fill);
            case CUBE:
                return new Cube(hue, height, fill);
            default:
                throw new IllegalArgumentException("Cannot create a " + shape);
        }
    }

}