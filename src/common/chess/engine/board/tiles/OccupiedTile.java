package common.chess.engine.board.tiles;

import common.chess.engine.pieces.Piece;

public final class OccupiedTile extends Tile {

    private final Piece pieceOnTile;

    public OccupiedTile(int TileCoordinate, final Piece pieceOnTile) {
        super(TileCoordinate);
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public String toString(){
        return getPiece().getPieceAllience().isBlack() ? getPiece().toString().toLowerCase() :
               getPiece().toString();
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
