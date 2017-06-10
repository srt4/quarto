package controller;

import model.Coordinates;
import model.QuartoBoard;
import model.QuartoPiece;

import java.util.List;

public interface Player {

    QuartoPiece selectPiece(List<QuartoPiece> pieces, QuartoBoard board);
    Coordinates selectCoordinates(QuartoPiece piece, QuartoBoard board);

}
