package com.chess.engine.board.board.tiles.tiles;

import com.chess.engine.board.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int TileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES_CAHSE = createAllPossiblyEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossiblyEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0; i < 64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate, piece ) : EMPTY_TILES_CAHSE.get(tileCoordinate);
    }

    Tile(int TileCoordinate) {
        this.TileCoordinate = TileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();
}
