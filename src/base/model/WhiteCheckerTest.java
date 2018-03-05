package base.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WhiteCheckerTest {
	
private Board board;
	
	private List<Checker> checkers1 = new ArrayList<>(Arrays.asList(
			new WhiteChecker(4, 1, Board.WHITE_CHECKER),
			new BlackChecker(3, 2, Board.BLACK_CHECKER),
			new WhiteChecker(1, 6, Board.WHITE_CHECKER),
			new BlackChecker(0, 7, Board.BLACK_CHECKER),
			new WhiteChecker(6, 5, Board.WHITE_CHECKER, true),
			new BlackChecker(2, 1, Board.BLACK_CHECKER)
			));

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCanMove() {
		board = new Board(checkers1);
		assertTrue(checkers1.get(0).canMove(2, 3, board));
		assertFalse(checkers1.get(0).canMove(3, 2, board));
		assertTrue(checkers1.get(4).canMove(4, 3, board));
		assertFalse(checkers1.get(4).canMove(2, 1, board));
		assertFalse(checkers1.get(4).canMove(1, 0, board));
		assertFalse(checkers1.get(4).canMove(3, 2, board));
		assertFalse(checkers1.get(4).canMove(0, -1, board));
		assertFalse(checkers1.get(4).canMove(2, 1, board));
	}

	@Test
	public final void testMoveIntIntBoard() {
//		fail("Not yet implemented"); // TODO
	}

}
