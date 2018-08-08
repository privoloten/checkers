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
			System.out.println(1);
			return false;
		}

		int rowDiff = row - this.row;

		if (Math.abs(rowDiff) == 2) { // If capture.

			int rowBlack = (row + this.row) / 2;
			int colBlack = (col + this.col) / 2;

			if (!board.isBlackPiece(rowBlack, colBlack)) {		
				System.out.println("WhitePiece.move(): white piece");		
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

	public static void main(String...args) {

		Board b = new Board();
		b.initBoard();
		System.out.println(b);
		if (b.move("a3-b4")) {
			System.out.println(b);			
		}
		if (b.move("b6-a5")) {
			System.out.println(b);		
		}
		if (b.move("b4-a3")) {
			System.out.println(b);
		}
		if (b.move("a5-b6")) {
			System.out.println(b);
		}
		if (b.move("c3-d4")) {
			System.out.println(b);
		}
		if (b.move("a5:c3")) {
			System.out.println(b);
		}
		if (b.move("c3:e5")) {
			System.out.println(b);
		}

	}

}
