package common.chess.engine.board;

import common.chess.engine.Alliance;
import common.chess.engine.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public class Builder {

    Map<Integer, Piece> boardConfig;
    Alliance nextMoveMaker;

    public Builder(){
        this.boardConfig = new HashMap<>();
    }

    public Builder setPiece(final Piece piece){
        this.boardConfig.put(piece.getPiecePosition(), piece);
        return this;
    }

    public Builder setMoveMaker(final Alliance nextMoveMaker){
        this.nextMoveMaker = nextMoveMaker;
        return this;
    }

    public Board build(){
        return new Board(this);
    }
}
