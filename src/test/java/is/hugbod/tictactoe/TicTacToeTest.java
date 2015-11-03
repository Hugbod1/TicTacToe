package is.hugbod.tictactoe;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TicTacToeTest {

	private final int boardSize = 3;

	public static void main(final String[] args) {
		org.junit.runner.JUnitCore.main("is.hugbod.tictactoe.test");
	}

	// Test that board is empty / reset
	@Test
	public final void testResetBoard() {
		Service test = new Service();
		test.resetBoard();
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				// Assert for each square that they are '-'
				assertEquals('-', test.getBoard(i, j));
			}
		}
	}

	// Test for legal tic
	@Test
	public final void testIsLegalTic() {
		Service test = new Service();
		assertTrue(test.isLegalTic(1, 1));
	}

	// Test for illegal tic
	@Test
	public final void testIsLegalTic2() {
		Service test = new Service();
		test.setBoard(1, 1, 'X');
		assertFalse(test.isLegalTic(1, 1));
	}

	@Test
	public final void checkForFullBoard() {
		Service test = new Service();
		// Empty board tested
		assertFalse(test.checkForFullBoard());

		// Board filled with 'X'
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				test.setBoard(i, j, 'X');
			}
		}
		assertTrue(test.checkForFullBoard());
	}

	// Test for horizontal win
	@Test
	public final void testCheckForWin() {
		Service test = new Service();
		test.setBoard(1, 0, 'X');
		test.setBoard(1, 1, 'X');
		test.setBoard(1, 2, 'X');
		// win for 'X'
		assertTrue(test.checkForWin());

		test.setBoard(1, 0, 'O');
		test.setBoard(1, 1, 'O');
		test.setBoard(1, 2, 'O');
		// win for 'O'
		assertTrue(test.checkForWin());
	}

	// Test for vertical win
	@Test
	public final void testCheckForWin2() {
		Service test = new Service();
		test.setBoard(0, 0, 'X');
		test.setBoard(1, 0, 'X');
		test.setBoard(2, 0, 'X');
		// win for 'X'
		assertTrue(test.checkForWin());

		test.setBoard(0, 0, 'O');
		test.setBoard(1, 0, 'O');
		test.setBoard(2, 0, 'O');
		// win for 'O'
		assertTrue(test.checkForWin());
	}

	// Test for diagonal win
	@Test
	public final void testCheckForWin3() {
		Service test = new Service();
		test.setBoard(0, 0, 'X');
		test.setBoard(1, 1, 'X');
		test.setBoard(2, 2, 'X');
		// win for 'X'
		assertTrue(test.checkForWin());

		test.setBoard(2, 0, 'O');
		test.setBoard(1, 1, 'O');
		test.setBoard(0, 2, 'O');
		// win for 'O'
		assertTrue(test.checkForWin());
	}

	// Test for no win
	@Test
	public final void testCheckForWin4() {
		Service test = new Service();
		// Empty board tested
		assertFalse(test.checkForWin());
	}

	// Test correct update of board
	@Test
	public final void testUpdateBoard() {
		Service test = new Service();
		// get the current player
		char player = test.getCurrentPlayer();
		// update one field with current player mark
		test.updateBoard(1, 1);
		assertEquals(player, test.getBoard(1, 1));
		// update another field with next player
		player = test.getCurrentPlayer();
		test.updateBoard(0, 1);
		assertEquals(player, test.getBoard(0, 1));
		// try illegal move (same as previous player)
		// No need to update player here since the field should NOT change
		test.updateBoard(0, 1);
		assertEquals(player, test.getBoard(0, 1));
		// try another field!
		player = test.getCurrentPlayer();
		test.updateBoard(2, 1);
		assertEquals(player, test.getBoard(2, 1));
	}

	// Test for ai
	@Test
	public final void testaiTic() {
		Service test = new Service();
		char player = test.getCurrentPlayer();
		test.aiTic();
		assertFalse(player == test.getCurrentPlayer());
	}

}

