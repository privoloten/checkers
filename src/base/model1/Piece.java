package base.model1;

public abstract class Piece {

	protected int row;

	protected int col;

	protected Piece(int row, int col) {
		this.row = row;
		this.col = col;
	}

	protected abstract char getMark();	

	protected boolean move(String code, Board board) {
		return move(board.getRow(code), board.getCol(code), board);
	}

	protected boolean move(int row, int col, Board board) {
		int rowDiff = Math.abs(row - this.row);
		int colDiff = Math.abs(col - this.col);
		if (rowDiff > 2) { // Only for queens allowed.
			System.out.println("Piece.move(): queen's move");
			return false;
		} 
		return board.isSquareEmpty(row, col) && rowDiff == colDiff;
	}

	protected void move(String code, Board board, int ...opponentCoords) {
		move(board.getRow(code), board.getCol(code), board, opponentCoords);
	}

	protected void move(int row, int col, Board board, int ...opponentCoords) {
		if (opponentCoords != null) { // If capture.
			board.removePiece(opponentCoords[0], opponentCoords[1]);
		}
		board.removePiece(this.row, this.col);
		this.row = row;
		this.col = col;
		board.setPiece(this);
	}
	
	
	protected abstract boolean canCapture(Board board);
	
	protected abstract boolean canMove(Board board);

}
