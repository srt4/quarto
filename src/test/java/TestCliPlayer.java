import model.Board;
import player.interactive.CliPlayer;
import model.Coordinates;
import model.Piece;
import model.attribute.Fill;
import model.attribute.Height;
import model.attribute.Hue;
import model.attribute.Shape;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

public class TestCliPlayer {

    private Piece piece;
    private Board board;

    @Before
    public void setup() {
        this.piece = new Piece(Hue.LIGHT, Height.SHORT, Fill.HOLLOW, Shape.CUBE);
        this.board = new Board();
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
