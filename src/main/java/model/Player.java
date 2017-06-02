package model;

public interface Player {

    QuartoPiece selectPiece(QuartoPieces pieces);
    Coordinates selectCoordinates(QuartoPiece piece, QuartoBoard board);

}
