package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import challenge.Sudoku;

public class SudokuTest {
	private static final Boolean FALSE = false;
	private static final Boolean TRUE = true;
	private static final int[][] SUDOKU_BOARD = {
			{7,0,0,0,8,0,0,0,2},
			{0,0,3,0,2,4,9,0,0},
			{0,4,0,0,0,9,0,0,0},
			{0,8,4,2,1,0,0,0,5},
			{0,0,9,0,0,0,2,0,0},
			{1,0,0,0,9,5,4,3,0},
			{0,0,0,4,0,0,0,5,0},
			{0,0,1,6,5,0,3,0,0},
			{2,0,0,0,3,0,0,0,4},
	};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test(expected = IllegalArgumentException.class)
	public void testIsValidFails() {

		Sudoku s = new Sudoku();
		s.isValid(SUDOKU_BOARD, 0, 1, 99);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testIsValid() {

		Sudoku s = new Sudoku();
		s.isValid(SUDOKU_BOARD, 0, 1, 9);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCheckInRowExists() {
		Sudoku s = new Sudoku();
		assertEquals(TRUE, s.checkInRow(SUDOKU_BOARD, 0, 7));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCheckInRowDoesNotExists() {

		Sudoku s = new Sudoku();
		assertEquals(FALSE, s.checkInRow(SUDOKU_BOARD, 0, 9));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCheckInColExists() {

		Sudoku s = new Sudoku();
		assertEquals(TRUE, s.checkInColumn(SUDOKU_BOARD, 4, 9));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCheckInColDoesNotExists() {

		Sudoku s = new Sudoku();
		assertEquals(FALSE, s.checkInColumn(SUDOKU_BOARD, 4, 4));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCheckInBoxExists() {

		Sudoku s = new Sudoku();
		assertEquals(TRUE, s.checkInBox(SUDOKU_BOARD, 0, 1, 7));
	}

	@SuppressWarnings("static-access")
	@Test(expected = IllegalArgumentException.class)
	public void testCheckInBoxDoesNotExists() {

		Sudoku s = new Sudoku();
		assertEquals(FALSE, s.checkInBox(SUDOKU_BOARD, 0, 1, 99));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testGetHints() {

		Sudoku s = new Sudoku();
		s.getHints(SUDOKU_BOARD);
	}
}