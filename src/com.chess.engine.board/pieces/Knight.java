package com.chess.engine.board.pieces;

import com.chess.engine.board.Alliance;
import com.chess.engine.board.board.tiles.Board;
import com.chess.engine.board.board.tiles.Move;
import com.chess.engine.board.board.tiles.tiles.Tile;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    Knight(final int piecePosition,final Alliance pieceAllience) {
        super(piecePosition, pieceAllience);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {

        int candidateDestinationCoordinate;

        final List<Move> legalMoves =  new ArrayList<>();

        for(final int currentCandidate : CANDIDATE_MOVE_COORDINATES){

            candidateDestinationCoordinate = this.piecePosition + currentCandidate;

            if(isValidTileCoordinate(candidateDestinationCoordinate)){

                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                if(!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new Move());

                }else{

                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAllience();

                    if(this.pieceAllience != pieceAlliance){
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    private boolean isValidTileCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }
}
