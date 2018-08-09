package base.model1;

public class WhitePiece extends Piece {

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
			System.out.println("WhitePiece.move(): super.move(..)");
			return false;
		}

		int rowDiff = row - this.row;

		if (Math.abs(rowDiff) == 2) { // If capture.

			int rowBlack = (row + this.row) / 2;
			int colBlack = (col + this.col) / 2;

			if (!board.isBlackPiece(rowBlack, colBlack)) {		
				System.out.println("WhitePiece.move(): white piece or nothing");		
				return false;				
			} 

			move(row, col, board, rowBlack, colBlack); // Move with capture.

		} else { // If just a move.

			if (rowDiff > 0) {
				System.out.println("WhitePiece.move(): moving back");
				return false; // Don't allow moving back.
			}

			super.move(row, col, board, null); // Just a move, without capture.
		}

		return true;
	}


	@Override
	protected boolean canCapture(Board board) {
		if (board.isBlackPiece(row + 1, col + 1) && board.isSquareEmpty(row + 2, col + 2)) {
			System.out.println("WhitePiece.canCapture(): 1 " + row + " : " + col);
			return true;
		}
		if (board.isBlackPiece(row + 1, col - 1) && board.isSquareEmpty(row + 2, col - 2)) {
			System.out.println("WhitePiece.canCapture(): 2 " + row + " : " + col);
			return true;
		}
		if (board.isBlackPiece(row - 1, col + 1) && board.isSquareEmpty(row - 2, col + 2)) {
			System.out.println("WhitePiece.canCapture(): 3 " + row + " : " + col);
			return true;
		}
		if (board.isBlackPiece(row - 1, col - 1) && board.isSquareEmpty(row - 2, col - 2)) {
			System.out.println("WhitePiece.canCapture(): 4 " + row + " : " + col);
			return true;
		}
		return false;
	}

	@Override
	protected boolean canMove(Board board) {
		if (board.isSquareEmpty(row - 1, col + 1)) {
			return true;
		}
		if (board.isSquareEmpty(row - 1, col - 1)) {
			return true;
		}
		return false;
	}
	
	

}
