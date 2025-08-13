package common.chess.engine.pieces.moves;

import common.chess.engine.board.Board;
import common.chess.engine.pieces.Piece;

public abstract class Move {

    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;


    protected Move(final Board board,
         final Piece movedPiece,
         final int destinationCoordinate){
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }
}
