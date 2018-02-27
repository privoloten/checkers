package base.model;

import java.util.Arrays;

public class Board {
	
	private final int ROWS = 8;

	private final int COLS = 8;
	
	private final char BLACK_SQUARE = '*';
	
	private final char WHITE_SQUARE = ' ';
	
	private final char WHITE_CHECKER = 'w';
	
	private final char BLACK_CHECKER = 'b';

	private char [][] board;
	
	public Board() {
		board = new char[ROWS][COLS];
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
    	for (int row = 0; row < ROWS; row ++) {
			for (int col = 0; col < COLS; col ++) {
				if (row % 2 == 0 ^ col % 2 == 0 && row < 3) {
					board[row][col] = BLACK_CHECKER;
				} else if (row % 2 != 0 ^ col % 2 != 0 && row > 4) {
					board[row][col] = WHITE_CHECKER;
				}
			}
    	}
    }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < ROWS; row ++) {
			for (int col = 0; col < COLS; col ++) {
				sb.append(board[row][col]).append(' ');
			}
			sb.setLength(sb.length() - 1); // Remove last white space.
			sb.append('\n');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		
		Board b = new Board();
		b.initBoard();
		b.initCheckers();
		System.out.println(b);

	}

}
