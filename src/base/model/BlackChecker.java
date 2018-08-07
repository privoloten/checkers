package base.model;

public class BlackChecker extends Piece {

	public BlackChecker(int row, int col, char mark) {
		super(row, col, mark);
	}

	@Override
	public boolean canMove(int row, int col, Board board) {	
		return false;
	}

	@Override
	public boolean move(int row, int col, Board board) {
		// git test
		return false;
	}




}
