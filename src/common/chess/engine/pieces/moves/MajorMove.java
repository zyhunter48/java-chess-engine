package common.chess.engine.pieces.moves;

import common.chess.engine.board.Board;
import common.chess.engine.pieces.Piece;

public final class MajorMove extends Move{

    public MajorMove(final Board board,
                     final Piece movedPiece,
                     final int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }
}