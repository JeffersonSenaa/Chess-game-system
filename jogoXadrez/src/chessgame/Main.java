package chessgame;

import chess.ChessMath;

public class Main {

	public static void main(String[] args) {
		ChessMath chessMath = new ChessMath();
		UI.printBoard(chessMath.getPieces());

	}

}
