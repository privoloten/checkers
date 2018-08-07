package base.model1;

public class BlackQueen extends BlackPiece {

	protected BlackQueen(int row, int col) {
		super(row, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected char getMark() {
		// TODO Auto-generated method stub
		return 'B';
	}
	
	@Override
	protected boolean move(int row, int col, Board board) {
		// TODO Auto-generated method stub
		return false;
	}
}
