package chess.pieces;

import board.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    //Nome da peça no tabuleiro
    @Override
    public String toString(){
        return "R";
    }
}
