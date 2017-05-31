package model;

import model.QuartoPiece;
import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

/**
 *
 * @author Spencer Thomas (srt4@uw.edu)
 */
public class Cylinder extends QuartoPiece {

    public Cylinder(Hue hue, Height height, Fill fill) {
        super(hue, height, fill);
    }

    @Override
    public Shape getShape() {
        return Shape.CYLINDER;
    }

}
