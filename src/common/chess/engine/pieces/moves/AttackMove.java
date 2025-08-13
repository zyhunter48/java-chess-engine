package common.chess.engine.pieces.moves;

import common.chess.engine.board.Board;
import common.chess.engine.pieces.Piece;

public final class AttackMove extends Move{

    final Piece attackedPiece;

    public AttackMove(final Board board,
               final Piece movedPiece,
               final int destinationCoordinate,
               final Piece attackedPiece) {
        super(board, movedPiece, destinationCoordinate);
        this.attackedPiece = attackedPiece;
    }
}