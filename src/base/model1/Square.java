package base.model1;

public class Square {
	
	private final char mark;
	
	private Piece piece;
	
	// TODO add constructor(s)
	
	public Square(char mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "" + (piece == null ? mark : piece.getMark());
	}
	
	public boolean isEmpty() {
		return piece == null;
	}
	
	public boolean isBlackPiece() {
		return isEmpty() ? false : 
			piece.getMark() == Board.BLACK_QUEEN || 
			piece.getMark() == Board.BLACK_CHECKER;
	}
	
	public boolean isWhitePiece() {
		return isEmpty() ? false : 
			piece.getMark() == Board.WHITE_CHECKER || 
			piece.getMark() == Board.WHITE_QUEEN;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

		
}
