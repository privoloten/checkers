package base.model;

public class WhiteChecker extends Piece {

	public WhiteChecker(int row, int col, char mark) {
		super(row, col, mark);
	}
	
	public WhiteChecker(int row, int col, char mark, boolean queen) {
		super(row, col, mark, queen);
	}

	@Override
	public boolean move(int row, int col, Board board) {
		if (canMove(row, col, board)) {
			
			return true;
		}
		return false;
	}

	@Override
	public boolean canMove(int row, int col, Board board) {		
		boolean moveWhite = false;
		
		boolean backMove = row - getRow() > 0;

		if (isQueen()) {
			boolean move = Math.abs(row - getRow()) >= 1; // Simple move detection for queen
			// to avoid possible move to the same location.
			
			if (move) {
				int numPiecesOnPath = board.numPieces(getRow(), getCol(), row, col);
				if (numPiecesOnPath == 1) {
					Checker captured = board.getCapturedChecker(getRow(), getCol(), row, col);
					if (captured.getMark() != getMark()) {
						moveWhite = true;
					}
				} else if (numPiecesOnPath == 0) { // If just siimple move for queen.
					moveWhite = true;
				}
			}
			
		} else {
			boolean capture = Math.abs(row - getRow()) == 2; // Capture detection for non-queen.
			boolean move = Math.abs(row - getRow()) == 1; // Simple move detection for non-queen.
			if (!capture && move) {
				if (!backMove) { // Moving back is forbidden for non-queens.
					moveWhite = true;
				}
			} else { // If this is capture, it doesn't matter whether this is the moving back.
				Checker captured = board.getCapturedChecker(getRow(), getCol(), row, col);
				if (captured != null && captured.getMark() != getMark()) { // Only if there is opposite piece between
					// start and end squares.
					
					moveWhite = true;
				}
			}
		}
		return super.canMove(row, col, board) && moveWhite;
	} // method

} // class
