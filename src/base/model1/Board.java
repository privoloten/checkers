package base.model1;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private final char BLACK_SQUARE = '*';

	private final char WHITE_SQUARE = ' ';
	
	public static final char WHITE_CHECKER = 'w';

	public static final char BLACK_CHECKER = 'b';
	
	public static final char WHITE_QUEEN = 'W';

	public static final char BLACK_QUEEN = 'B';

	private final List<Piece> pieces = new ArrayList<>();

	public List<Piece> getPieces() {
		return pieces;
	}
	
	private final char[][] board = new char[8][8];
	
	public boolean isSquareEmpty(int row, int col) {
		return board[row][col] == BLACK_SQUARE;
	}
	
	public boolean isBlackPiece(int row, int col) {
		return board[row][col] == BLACK_CHECKER || board[row][col] == BLACK_QUEEN;
	}
	
	public void remove(int row, int col) {
		board[row][col] = BLACK_SQUARE;
	}
	
	public void setPiece(Piece piece) {
		board[piece.row][piece.col] = piece.getMark();
	}
	
}
