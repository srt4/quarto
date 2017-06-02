import model.QuartoBoard;
import model.QuartoPiece;
import model.QuartoPieces;
import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class TestQuartoBoard {

    private QuartoBoard board;

    @Before
    public void setup() {
        this.board = new QuartoBoard();
    }

    @Test
    public void testPopulateBoard() {
        final QuartoPieces pieces = new QuartoPieces();

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                board.placePiece(pieces.get().get(x + (4 * y)), x, y);
            }
        }

        System.out.println(board);
    }

    @Test
    public void testOccupiedSpaceIsOccupied() {
        board.placePiece(new QuartoPiece(Hue.LIGHT, Height.SHORT, Fill.HOLLOW, Shape.CUBE), 3, 2);
        Assert.assertTrue(board.isOccupied(3, 2));
    }

    @Test
    public void testUnoccupiedSpaceIsNotOccupied() {
        board.placePiece(new QuartoPiece(Hue.LIGHT, Height.SHORT, Fill.HOLLOW, Shape.CUBE), 3, 2);
        Assert.assertFalse(board.isOccupied(1, 1));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testOccupiedSpaceCannotPlace() {
        board.placePiece(new QuartoPiece(Hue.LIGHT, Height.SHORT, Fill.HOLLOW, Shape.CUBE), 3, 2);
        board.placePiece(new QuartoPiece(Hue.DARK, Height.SHORT, Fill.FILLED, Shape.CUBE), 3, 2);
    }

}