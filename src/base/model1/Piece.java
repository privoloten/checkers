package base.model1;

public abstract class Piece {

	protected int row;
	
	protected int col;
	
	protected Piece(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	protected Piece(String code) {
		this.row = getRow(code);
		this.col = getCol(code);
	}
	
	protected final int getRow(String code) {
		return 8 - Integer.parseInt(code.charAt(1) + "");
	}
	
	protected final int getCol(String code) {
		return Math.abs(97 - (int)code.charAt(0));
	}
	
	protected abstract char getMark();
	
	protected boolean move(String code, Board board) {
		return move(getRow(code), getCol(code), board);
	}
	
	protected boolean move(int row, int col, Board board) {
		int rowDiff = row - this.row;
		int colDiff = col = this.col;
		return board.isSquareEmpty(row, col) && rowDiff == colDiff;
	}
	
	protected void remove(Board board) {
		board.remove(row, col);
	}
	
	protected void completeMove(int row, int col, Board board) {
		this.row = row;
		this.col = col;
		board.setPiece(this);
	}
	
}
