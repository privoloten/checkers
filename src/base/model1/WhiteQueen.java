package base.model1;

public class WhiteQueen extends WhitePiece {

	protected WhiteQueen(int row, int col) {
		super(row, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected char getMark() {
		// TODO Auto-generated method stub
		return 'W';
	}
	
	@Override
	protected boolean move(int row, int col, Board board) {
		
		return false;
	}
}
