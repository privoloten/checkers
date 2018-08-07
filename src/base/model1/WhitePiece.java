package base.model1;

public class WhitePiece extends Piece {

	protected WhitePiece(String code) {
		super(code);
	}

	protected WhitePiece(int row, int col) {
		super(row, col);
	}	

	@Override
	protected char getMark() {
		return 'w';
	}

	@Override
	protected boolean move(int row, int col, Board board) {

		if (!super.move(row, col, board)) {
			return false;
		}

		// ? different methods in Piece?
		int rowDiff = row - this.row;

		if (rowDiff > 2) { // Only for queens allowed.
			return false;
		} 

		if (rowDiff == 2) { // If capture.

			int rowBlack = (row + this.row) / 2;
			int colBlack = (col + this.col) / 2;

			if (!board.isBlackPiece(rowBlack, colBlack)) {				
				return false;				
			} 

			board.remove(rowBlack, colBlack);
			completeMove(row, col, board);

		} else { // If just a move.
			
			if (rowDiff < 0) {
				return false; // Don't allow moving back.
			}
			
			completeMove(row, col, board);
		}

		return true;
	}

}
