package model;

public interface Player {

    QuartoPiece selectPiece();
    int selectCoord(String axis, int min, int max);

}
