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

public class BoardTest {
	
	private Board board;
	
	private List<Checker> checkers1 = new ArrayList<>(Arrays.asList(
			new WhiteChecker(4, 1, Board.WHITE_CHECKER),
			new BlackChecker(3, 2, Board.BLACK_CHECKER),
			new WhiteChecker(1, 6, Board.WHITE_CHECKER),
			new BlackChecker(0, 7, Board.BLACK_CHECKER),
			new WhiteChecker(6, 5, Board.WHITE_CHECKER, true)
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
	public final void testBoard() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testBoardListOfChecker() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitBoard() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitCheckers() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testUpdateBoard() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRemoveChecker() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetCapturedChecker() {
		board = new Board(checkers1);
		Checker ch = board.getCapturedChecker(4, 1, 2, 3);
		assertNotNull(ch);
		assertTrue(ch.getMark() == Board.BLACK_CHECKER);
		assertEquals(3, ch.getRow());
		assertEquals(2, ch.getCol());
		
		// Check bounds.
		ch = board.getCapturedChecker(1, 6, -1, 8);
		assertNull(ch);
		
		// For queen.
		ch = board.getCapturedChecker(6, 5, 1, 0);
		assertNotNull(ch);
		assertTrue(ch.getMark() == Board.BLACK_CHECKER);
		assertEquals(3, ch.getRow());
		assertEquals(2, ch.getCol());
	}
	
	@Test
	public final void testNumPieces() {
		board = new Board(checkers1);
		assertEquals(2, board.numPieces(7, 6, 2, 1));
		assertEquals(1, board.numPieces(7, 0, 0, 7));
		assertEquals(2, board.numPieces(5, 0, 1, 4));
	}

	@Test
	public final void testToString() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsValid() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsChecker() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetChecker() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testMove() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testMain() {
//		fail("Not yet implemented"); // TODO
	}

}
