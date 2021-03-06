package base.model1;

public class BlackPiece extends Piece {

	protected BlackPiece(int row, int col) {
		super(row, col);
	}

	@Override
	protected char getMark() {
		return 'b';
	}

	@Override
	protected boolean move(int row, int col, Board board) {
		if (!super.move(row, col, board)) {
			System.out.println(1);
			return false;
		}

		int rowDiff = row - this.row;

		if (Math.abs(rowDiff) == 2) { // If capture.

			int rowWhite = (row + this.row) / 2;
			int colWhite = (col + this.col) / 2;

			if (!board.isWhitePiece(rowWhite, colWhite)) {		
				System.out.println("BlackPiece.move(): black piece or nothing");		
				return false;				
			} 

			move(row, col, board, rowWhite, colWhite); // Move with capture.

		} else { // If just a move.

			if (rowDiff < 0) {
				System.out.println("BlackPiece.move(): moving back");
				return false; // Don't allow moving back.
			}

			super.move(row, col, board, null); // Just a move, without capture.
		}

		return true;
	}

	@Override
	protected boolean canCapture(Board board) {
		if (board.isWhitePiece(row + 1, col + 1) && board.isSquareEmpty(row + 2, col + 2)) {
			return true;
		}
		if (board.isWhitePiece(row + 1, col - 1) && board.isSquareEmpty(row + 2, col - 2)) {
			return true;
		}
		if (board.isWhitePiece(row - 1, col + 1) && board.isSquareEmpty(row - 2, col + 2)) {
			return true;
		}
		if (board.isWhitePiece(row - 1, col - 1) && board.isSquareEmpty(row - 2, col - 2)) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean canMove(Board board) {
		if (board.isSquareEmpty(row + 1, col + 1)) {
			return true;
		}
		if (board.isSquareEmpty(row + 1, col - 1)) {
			return true;
		}
		return false;
	}

}
