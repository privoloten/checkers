package base.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Board {

	private final int ROWS = 8;

	private final int COLS = 8;

	private final char BLACK_SQUARE = '*';

	private final char WHITE_SQUARE = ' ';

	public static final char WHITE_CHECKER = 'w';

	public static final char BLACK_CHECKER = 'b';

	private char [][] board;

	private List<Checker> checkers;

	public Board() {
		board = new char[ROWS][COLS];
		initBoard();
		initCheckers();
		updateBoard();
	}
	
	public Board(List<Checker> checkers) {
		this.checkers = checkers;
		board = new char[ROWS][COLS];
		initBoard();
		updateBoard();
	}

	public void initBoard() {
		for (int row = 0; row < ROWS; row ++) {
			for (int col = 0; col < COLS; col ++) {
				if (row % 2 == 0 ^ col % 2 == 0) {
					board[row][col] = BLACK_SQUARE;
				} else {
					board[row][col] = WHITE_SQUARE;
				}
			}
		}
	}

	public void initCheckers() {
		checkers = new ArrayList<>(Arrays.asList(				
				new WhiteChecker(7, 0, Board.WHITE_CHECKER),
				new WhiteChecker(7, 2, Board.WHITE_CHECKER),
				new WhiteChecker(7, 4, Board.WHITE_CHECKER),
				new WhiteChecker(7, 6, Board.WHITE_CHECKER),
				new WhiteChecker(6, 1, Board.WHITE_CHECKER),
				new WhiteChecker(6, 3, Board.WHITE_CHECKER),
				new WhiteChecker(6, 5, Board.WHITE_CHECKER),
				new WhiteChecker(6, 7, Board.WHITE_CHECKER),
				new WhiteChecker(5, 0, Board.WHITE_CHECKER),
				new WhiteChecker(5, 2, Board.WHITE_CHECKER),
				new WhiteChecker(5, 4, Board.WHITE_CHECKER),
				new WhiteChecker(5, 6, Board.WHITE_CHECKER),
				new BlackChecker(0, 1, Board.BLACK_CHECKER),
				new BlackChecker(0, 3, Board.BLACK_CHECKER),
				new BlackChecker(0, 5, Board.BLACK_CHECKER),
				new BlackChecker(0, 7, Board.BLACK_CHECKER),
				new BlackChecker(1, 0, Board.BLACK_CHECKER),
				new BlackChecker(1, 2, Board.BLACK_CHECKER),
				new BlackChecker(1, 4, Board.BLACK_CHECKER),
				new BlackChecker(1, 6, Board.BLACK_CHECKER),
				new BlackChecker(2, 1, Board.BLACK_CHECKER),
				new BlackChecker(2, 3, Board.BLACK_CHECKER),
				new BlackChecker(2, 5, Board.BLACK_CHECKER),
				new BlackChecker(2, 7, Board.BLACK_CHECKER)
				));
	}
	
	public void updateBoard() {
		checkers.forEach(checker -> board[checker.getRow()][checker.getCol()] = checker.getMark());
	}
	
	public void removeChecker(Checker checker) {
		checkers.remove(checker);
	}
	
	/**
	 * This method searches for the first checker on the captured path from
	 * 'from' to 'to'.
	 * 
	 * @param rowFrom the start row
	 * @param colFrom the start column
	 * @param rowTo the end row
	 * @param colTo the end column
	 * @return {@link Checker} object if found, otherwise null
	 */
	public Checker getCapturedChecker(int rowFrom, int colFrom, int rowTo, int colTo) {
		if (!checkBounds(rowFrom, colFrom, rowTo, colTo)) {
			return null;
		}
		int steps = Math.abs(rowFrom - rowTo);
		for (int i = 0; i < steps - 1; i ++) {
			int curRow = rowFrom > rowTo ? -- rowFrom: ++ rowFrom;
			int curCol = colFrom > colTo ? -- colFrom: ++ colFrom;
			if (isChecker(curRow, curCol)) {
				return getChecker(curRow, curCol);
			}
		}
		return null;
	}
	
	public boolean adjacentPieces(int rowFrom, int colFrom, int rowTo, int colTo) {
		if (!checkBounds(rowFrom, colFrom, rowTo, colTo)) {
			return true; // Just returns true to forbid queen moving/capturing, but of course
			// the exception should be thrown in this case (for future).
		}
		
		int steps = Math.abs(rowFrom - rowTo);
		int adjPieces = 0;
		for (int i = 0; i < steps; i ++) {
			int curRow = rowFrom > rowTo ? -- rowFrom: ++ rowFrom;
			int curCol = colFrom > colTo ? -- colFrom: ++ colFrom;
			if (isChecker(curRow, curCol)) {
				adjPieces ++;
			} else {
				adjPieces = 0;
			}
			if (adjPieces == 2) {
				return true;
			}
		}
		return false;		
	}
	
	public int numPieces(int rowFrom, int colFrom, int rowTo, int colTo) {
		if (!checkBounds(rowFrom, colFrom, rowTo, colTo)) {
			return -1;
		}
		int steps = Math.abs(rowFrom - rowTo);
		int count = 0;
		for (int i = 0; i < steps - 1; i ++) {
			int curRow = rowFrom > rowTo ? -- rowFrom: ++ rowFrom;
			int curCol = colFrom > colTo ? -- colFrom: ++ colFrom;
			if (isChecker(curRow, curCol)) {
				count ++;
			}
		}
		return count;
	}
	
	public boolean checkBounds(int ...coord) {
		for (int i: coord) {
			if (i < 0 || i >= board.length) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < ROWS; row ++) {
			sb.append(String.valueOf(8 - row)).append(' ');
			for (int col = 0; col < COLS; col ++) {
				sb.append(board[row][col]).append(' ');
			}
			sb.setLength(sb.length() - 1); // Remove last white space.
			sb.append('\n');
		}
		sb.append(' ').append(' ');
		for (int i = 97; i < 105; i ++) {
			sb.append((char)i).append(' ');
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
	
	public boolean isValid(int row, int col) {
		return checkBounds(row, col) && board[row][col] == BLACK_SQUARE;
	}
	
	public boolean isChecker(int row, int col) {
		return board[row][col] == WHITE_CHECKER || board[row][col] == BLACK_CHECKER;
	}
	
	public Checker getChecker(int row, int col) {
		Optional<Checker> opt = checkers.stream().filter(c -> c.getRow() == row && c.getCol() == col).findFirst();
		return opt != null ? opt.get() : null;
	}

	public void move(String move) {
		int rowFrom = 8 - Integer.parseInt(move.charAt(1) + "");
		int colFrom = Math.abs(97 - (int)move.charAt(0));
		int rowTo = 8 - Integer.parseInt(move.charAt(4) + "");
		int colTo = Math.abs(97 - (int)move.charAt(3));
		board[rowTo][colTo] = board[rowFrom][colFrom];
		board[rowFrom][colFrom] = BLACK_SQUARE;
	}

	public static void main(String[] args) {

		Board b = new Board();

		System.out.println(b);

	}

	public void setCheckers(List<Checker> checkers) {
		this.checkers = checkers;
	}

}
