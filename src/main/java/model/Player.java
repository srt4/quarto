package model;

import java.util.List;

public interface Player {

    QuartoPiece selectPiece(List<QuartoPiece> pieces, QuartoBoard board);
    Coordinates selectCoordinates(QuartoPiece piece, QuartoBoard board);

}
