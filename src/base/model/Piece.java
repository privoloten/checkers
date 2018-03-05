package base.model;

public abstract class Piece implements Checker {

	protected int row;
	
	protected int col;
	
	protected char mark;
	
	protected boolean queen;
	
	public Piece(int row, int col, char mark) {
		this.row = row;
		this.col = col;
		this.mark = mark;
	}
	
	public Piece(int row, int col, char mark, boolean queen) {
		this(row, col, mark);
		this.queen = queen;
	}
	
	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public int getCol() {
		// TODO Auto-generated method stub
		return col;
	}

	@Override
	public char getMark() {
		// TODO Auto-generated method stub
		return mark;
	}
	
	@Override
	public boolean isQueen() {
		// TODO Auto-generated method stub
		return queen;
	}

	@Override
	public boolean move(String move, Board board) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void remove(Board board) {
		board.removeChecker(this);		
	}
	
	@Override
	public boolean canMove(int row, int col, Board board) {
		return board.isValid(row, col);
	}
	
	@Override
	public void capture(Checker checker, Board board) {
		checker.remove(board);
	}
	
}
