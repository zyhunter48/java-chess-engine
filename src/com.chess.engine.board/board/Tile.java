package com.chess.engine.board.board;

import com.chess.engine.board.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile{

    protected final int TileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPosiblyEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPosiblyEmptyTiles() {
        final  Map<Integer, EmptyTile>  emptyTileMap = new HashMap<>();

        for(int i = 0; i < 64; i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return null;
    }

    Tile(int TileCoordinate){
        this.TileCoordinate = TileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile{

        public EmptyTile(final int coordinate) {
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Piece getPiece(){
            return null;
        }
    }
    public static final class OccupiedTile extends Tile{

        private final Piece pieceOnTile;

        public OccupiedTile(int TileCoordinate, Piece pieceOnTile) {
            super(TileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }

        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }
}
