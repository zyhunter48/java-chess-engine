package com.chess.engine.board.board.tiles;

import com.chess.engine.board.pieces.Piece;

public final class EmptyTile extends Tile {

    public EmptyTile(final int coordinate) {
        super(coordinate);
    }

    @Override
    public boolean isTileOccupied() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
