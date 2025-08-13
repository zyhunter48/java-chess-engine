package common.chess.engine.pieces;

import common.chess.engine.Alliance;
import common.chess.engine.board.Board;
import common.chess.engine.pieces.moves.Move;

import java.util.Collection;

public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAllience;
    protected final boolean isFirstMove;

    Piece(final int piecePosition, final Alliance pieceAllience){
        this.pieceAllience = pieceAllience;
        this.piecePosition = piecePosition;
        this.isFirstMove = false;
    }

    public int getPiecePosition() {
        return this.piecePosition;
    }

    public Alliance getPieceAllience() {
        return this.pieceAllience;
    }

    public boolean isFirstMove(){
        return this.isFirstMove;
    }

    public abstract Collection<Move> calculateLegalMoves(final Board board);

    public enum PieceType {

        PAWN("P"),
        ROOK("R"),
        KNIGHT("N"),
        BISHOP("B"),
        KING("K"),
        QUEEN("Q");

        private String pieceName;

        PieceType(final String pieceName){
            this.pieceName = pieceName;
        }

        @Override
        public String toString(){
            return this.pieceName;
        }
    }

}
