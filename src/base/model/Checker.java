package base.model;

public interface Checker  {

	public int getRow();
	
	public int getCol();
	
	public char getMark();
	
	public boolean canMove(int row, int col, Board board);
	
	public boolean move(int row, int col, Board board);
	
	public boolean move(String move, Board board);
	
	public void capture(Checker checker, Board board);
	
	public boolean isQueen();
	
	public void remove(Board board);
}
