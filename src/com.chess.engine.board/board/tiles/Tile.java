package com.chess.engine.board.board.tiles;

import com.chess.engine.board.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int TileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossiblyEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossiblyEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0; i < 64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return emptyTileMap;
    }

    Tile(int TileCoordinate) {
        this.TileCoordinate = TileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();
}
