package base.model1;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public static final int ROWS = 8;

	public static final int COLS = 8;

	public static final char BLACK_SQUARE = '*';

	public static final char WHITE_SQUARE = ' ';

	public static final char WHITE_CHECKER = 'w';

	public static final char BLACK_CHECKER = 'b';

	public static final char WHITE_QUEEN = 'W';

	public static final char BLACK_QUEEN = 'B';

	//	private final char[][] board = new char[ROWS][COLS];

	private final Square[][] squares = new Square[ROWS][COLS];

	//	private List<Piece> pieces

	protected void initBoard() {
		for (int row = 0; row < ROWS; row ++) {
			for (int col = 0; col < COLS; col ++) {
				if (row % 2 == 0 ^ col % 2 == 0) {
					//					board[row][col] = BLACK_SQUARE;
					Square square = new Square(BLACK_SQUARE);
					squares[row][col] = square;

					// Black squares may contain pieces.
					if (row < 3) {
						square.setPiece(new BlackPiece(row, col));
					} else if (row > 4) {
						square.setPiece(new WhitePiece(row, col));
					}

				} else {
					//					board[row][col] = WHITE_SQUARE;
					squares[row][col] = new Square(WHITE_SQUARE);
				}
			}
		}
	}

	protected final int getRow(String code) {
		return 8 - Integer.parseInt(code.charAt(1) + "");
	}

	protected final int getCol(String code) {
		return Math.abs(97 - (int)code.charAt(0));
	}	

	protected boolean isSquareEmpty(int row, int col) {
		return squares[row][col].isEmpty();
	}

	protected boolean isBlackPiece(int row, int col) {
		return squares[row][col].isBlackPiece();
	}

	protected boolean isWhitePiece(int row, int col) {
		return squares[row][col].isWhitePiece();
	}

	protected void removePiece(int row, int col) {
		squares[row][col].setPiece(null);
	}

	protected void setPiece(Piece piece) {
		squares[piece.row][piece.col].setPiece(piece);
	}

	protected boolean move(String code) {
		String [] fromTo = code.split("[-:]");
		int rowFrom = getRow(fromTo[0]);
		int colFrom = getCol(fromTo[0]);
		int rowTo = getRow(fromTo[1]);
		int colTo = getCol(fromTo[1]);
//		System.out.println(rowFrom + " " + colFrom);
		return squares[rowFrom][colFrom].getPiece().move(rowTo, colTo, this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < ROWS; row ++) {
			sb.append(String.valueOf(8 - row)).append(' ');
			for (int col = 0; col < COLS; col ++) {
				sb.append(squares[row][col]).append(' ');
			}
			sb.setLength(sb.length() - 1); // Remove last white space.
			sb.append('\n');
		}
		sb.append(' ').append(' ');
		for (int i = 97; i < 105; i ++) {
			sb.append((char)i).append(' ');
		}
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		return sb.toString();
	}

}
