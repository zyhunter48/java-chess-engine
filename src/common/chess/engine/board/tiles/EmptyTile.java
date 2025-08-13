package common.chess.engine.board.tiles;

import common.chess.engine.pieces.Piece;

public final class EmptyTile extends Tile {

    public EmptyTile(final int coordinate) {
        super(coordinate);
    }

    @Override
    public String toString() {
        return "-";
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
