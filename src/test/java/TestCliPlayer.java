import model.CliPlayer;
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

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    // TODO: Discuss exception based unit tests
    @Test(expected=InputMismatchException.class)
    public void testSelectCoordinatesThrowsIfBelowLowerBound() {
        String input = "-1,1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        CliPlayer player = new CliPlayer(scanner); // Can't put in 'setup()' -- needs input stream in CTOR

        player.selectCoordinates(piece, board);
    }

}
