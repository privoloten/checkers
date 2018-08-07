package base.model1;

public class BlackPiece extends Piece {

protected BlackPiece(String code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	protected BlackPiece(int row, int col) {
		super(row, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected char getMark() {
		// TODO Auto-generated method stub
		return 'b';
	}

	@Override
	protected boolean move(int row, int col, Board board) {
		// TODO Auto-generated method stub
		return false;
	}

}
