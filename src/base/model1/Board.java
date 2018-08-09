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

	private final Square[][] squares = new Square[ROWS][COLS];

	private final List<Piece> pieces = new ArrayList<>();
	
	private final List<Square> listSquares = new ArrayList<>();

	protected void initBoard() {
		for (int row = 0; row < ROWS; row ++) {
			for (int col = 0; col < COLS; col ++) {
				if (row % 2 == 0 ^ col % 2 == 0) {
					Square square = new Square(BLACK_SQUARE);
					squares[row][col] = square;

					// Black squares may contain pieces.
					Piece piece;
					if (row < 3) {
						square.setPiece(piece = new BlackPiece(row, col));
						pieces.add(piece);
					} else if (row > 4) {
						square.setPiece(piece = new WhitePiece(row, col));
						pieces.add(piece);
					}


				} else { // TODO delete?
					squares[row][col] = new Square(WHITE_SQUARE);
				}
			}
		}
	}
	
	/*
	 * Sample position:
	 * b4,a1;c5,e5
	 */
	protected void initBoard(String position) {
		String [] sides = position.split(";");
		String [] whites = sides[0].split(",");
		String [] blacks = sides[1].split(",");
		
	}

	protected boolean isInRange(int row, int col) {
		return row >= 0 && row < ROWS && col >= 0 && col < COLS;
	}

	protected final int getRow(String code) {
		return 8 - Integer.parseInt(code.charAt(1) + "");
	}

	protected final int getCol(String code) {
		return Math.abs(97 - (int)code.charAt(0));
	}	

	protected boolean isSquareEmpty(int row, int col) {
		if (!isInRange(row, col)) {
			return false;
		}
		return squares[row][col].isEmpty();
	}

	protected boolean isBlackPiece(int row, int col) {
		if (!isInRange(row, col)) {
			return false;
		}
		return squares[row][col].isBlackPiece();
	}

	protected boolean isWhitePiece(int row, int col) {
		if (!isInRange(row, col)) {
			return false;
		}
		return squares[row][col].isWhitePiece();
	}

	protected void removePiece(int row, int col) {
		pieces.remove(squares[row][col].getPiece());
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
		if (squares[rowFrom][colFrom].getPiece() == null) {
			return false;
		}
		return squares[rowFrom][colFrom].getPiece().move(rowTo, colTo, this);
	}

	protected boolean canWhiteCapture() {
		for (Piece piece: pieces) {
			if ((piece.getMark() == WHITE_CHECKER || piece.getMark() == WHITE_QUEEN) &&
					piece.canCapture(this)) {
				return true;
			}
		}
		return false;
	}

	protected boolean canBlackCapture() {
		for (Piece piece: pieces) {
			if ((piece.getMark() == BLACK_CHECKER || piece.getMark() == BLACK_QUEEN) &&
					piece.canCapture(this)) {
				return true;
			}
		}
		return false;
	}

	protected boolean canWhiteMove() {
		return pieces.stream().filter(p -> 
		(p.getMark() == WHITE_CHECKER || p.getMark() == WHITE_QUEEN) && 
		p.canMove(this)).findAny().isPresent();
	}

	protected boolean canBlackMove() {
		return pieces.stream().filter(p -> 
		(p.getMark() == BLACK_CHECKER || p.getMark() == BLACK_QUEEN) && 
		p.canMove(this)).findAny().isPresent();
	}
	
	protected boolean isCapture(String code) {
		String [] fromTo = code.split("[-:]");
		int rowFrom = getRow(fromTo[0]);
		int rowTo = getRow(fromTo[1]);
		return Math.abs(rowFrom - rowTo) >= 2;
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
