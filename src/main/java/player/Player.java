package player;

import model.Coordinates;
import model.Piece;
import model.Board;

import java.util.List;

public interface Player {

    Piece selectPiece(List<Piece> pieces, Board board);
    Coordinates selectCoordinates(Piece piece, Board board);

}
