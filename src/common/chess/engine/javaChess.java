package common.chess.engine;

import common.chess.engine.board.Board;

public class javaChess {

    public static void main(String[] args){

        Board board = Board.createStandardBoard();

        System.out.println(board);
    }
}
