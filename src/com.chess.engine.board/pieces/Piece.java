package com.chess.engine.board.pieces;

import com.chess.engine.board.Alliance;
import com.chess.engine.board.board.tiles.Board;
import com.chess.engine.board.board.tiles.Move;

import java.util.List;

public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAllience;

    Piece(final int piecePosition, final Alliance pieceAllience){
        this.pieceAllience = pieceAllience;
        this.piecePosition = piecePosition;
    }

    public Alliance getPieceAllience() {
        return this.pieceAllience;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);
}
