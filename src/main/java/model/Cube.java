package model;

import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

/**
 * @author Spencer Thomas (srt4@uw.edu)
 */
public class Cube extends QuartoPiece {

    public Cube(Hue hue, Height height, Fill fill) {
        super(hue, height, fill);
    }

    @Override
    public Shape getShape() {
        return Shape.CUBE;
    }

}
