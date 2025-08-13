package common.chess.engine.pieces;

import common.chess.engine.Alliance;
import common.chess.engine.board.Board;
import common.chess.engine.board.BoardUtils;
import common.chess.engine.board.tiles.Tile;
import common.chess.engine.pieces.moves.AttackMove;
import common.chess.engine.pieces.moves.MajorMove;
import common.chess.engine.pieces.moves.Move;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece{

    private final static int[] CANDIDATE_MOVE_COORDINATES = {7, 8, 9, 16};

    public Pawn(final Alliance pieceAllience,
                final int piecePosition) {
        super(piecePosition, pieceAllience);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> legalMoves =  new ArrayList<>();

        for(final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {

            final int candidateDestinationCoordinate = this.piecePosition + (this.pieceAllience.getDirection() * currentCandidateOffset);

            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                continue;
            }

            if (currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {

                legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));

            } else if (currentCandidateOffset == 16 && isFirstMove() &&
                    (BoardUtils.SECOND_ROW[this.piecePosition] && this.getPieceAllience().isBlack()) ||
                    (BoardUtils.SEVENTH_ROW[this.piecePosition] && this.getPieceAllience().isWhite())) {

                final int behindCandidateDestinationCoordinate = this.piecePosition + (this.pieceAllience.getDirection() * 8);

                if (!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied() &&
                        !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {

                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));

                }
            } else if (currentCandidateOffset == 7 &&
                    !((BoardUtils.EIGHT_COLUMN[this.piecePosition] && this.pieceAllience.isWhite()) ||
                            (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAllience.isBlack()))) {

                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {

                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();

                    if (this.pieceAllience != pieceOnCandidate.getPieceAllience()) {
                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    }
                }
            } else if (currentCandidateOffset == 9 &&
                    !((BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAllience.isWhite()) ||
                            (BoardUtils.EIGHT_COLUMN[this.piecePosition] && this.pieceAllience.isBlack()))) {

                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {

                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();

                    if (this.pieceAllience != pieceOnCandidate.getPieceAllience()) {
                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
    @Override
    public String toString(){
        return PieceType.PAWN.toString();
    }
}