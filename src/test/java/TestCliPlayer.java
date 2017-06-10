import controller.CliPlayer;
import model.Coordinates;
import model.QuartoBoard;
import model.QuartoPiece;
import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

public class TestCliPlayer {

    private QuartoPiece piece;
    private QuartoBoard board;

    @Before
    public void setup() {
        this.piece = new QuartoPiece(Hue.LIGHT, Height.SHORT, Fill.HOLLOW, Shape.CUBE);
        this.board = new QuartoBoard();
    }

    @Test
    public void testSelectCoordinates() {
        String input = "B\n1\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CliPlayer player = new CliPlayer(scanner, "P1");

        Coordinates selectedCoordinates = player.selectCoordinates(piece, board);
        Assert.assertEquals(2, selectedCoordinates.getX());
        Assert.assertEquals(1, selectedCoordinates.getY());
    }

}
