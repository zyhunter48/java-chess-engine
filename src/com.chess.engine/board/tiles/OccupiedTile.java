package com.chess.engine.board.tiles;

import com.chess.engine.pieces.Piece;

public final class OccupiedTile extends Tile {

    private final Piece pieceOnTile;

    public OccupiedTile(int TileCoordinate, final Piece pieceOnTile) {
        super(TileCoordinate);
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public boolean isTileOccupied() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return this.pieceOnTile;
    }
}
