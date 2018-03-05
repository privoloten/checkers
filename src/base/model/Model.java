package base.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

	private Board board;

	public Model() {

	}	

	public static void main(String[] args) {
		List<Checker> checkers = new ArrayList<>(Arrays.asList(				
				new WhiteChecker(7, 0, Board.WHITE_CHECKER),
				new WhiteChecker(7, 2, Board.WHITE_CHECKER),
				new WhiteChecker(7, 4, Board.WHITE_CHECKER),
				new WhiteChecker(7, 6, Board.WHITE_CHECKER),
				new WhiteChecker(6, 1, Board.WHITE_CHECKER),
				new WhiteChecker(6, 3, Board.WHITE_CHECKER),
				new WhiteChecker(6, 5, Board.WHITE_CHECKER),
				new WhiteChecker(6, 7, Board.WHITE_CHECKER),
				new WhiteChecker(5, 0, Board.WHITE_CHECKER),
				new WhiteChecker(5, 2, Board.WHITE_CHECKER),
				new WhiteChecker(5, 4, Board.WHITE_CHECKER),
				new WhiteChecker(5, 6, Board.WHITE_CHECKER),
				new BlackChecker(0, 1, Board.BLACK_CHECKER),
				new BlackChecker(0, 3, Board.BLACK_CHECKER),
				new BlackChecker(0, 5, Board.BLACK_CHECKER),
				new BlackChecker(0, 7, Board.BLACK_CHECKER),
				new BlackChecker(1, 0, Board.BLACK_CHECKER),
				new BlackChecker(1, 2, Board.BLACK_CHECKER),
				new BlackChecker(1, 4, Board.BLACK_CHECKER),
				new BlackChecker(1, 6, Board.BLACK_CHECKER),
				new BlackChecker(2, 1, Board.BLACK_CHECKER),
				new BlackChecker(2, 3, Board.BLACK_CHECKER),
				new BlackChecker(2, 5, Board.BLACK_CHECKER),
				new BlackChecker(2, 7, Board.BLACK_CHECKER)
				));
		checkers.remove(0);
		
	}

}
