package chess.pieces;

import board.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    //Letra da peça no tabuleiro
    @Override
    public String toString() {
        return "K";
    }
}
