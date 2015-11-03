package is.hugbod.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class test{

	public static void main(String args[]){
		org.junit.runner.JUnitCore.main("is.hugbod.tictactoe.test");
	}
	
	// Test that board is empty / reset
	@Test
	public void testResetBoard(){
		Service test = new Service();
		test.resetBoard();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				// Assert for each square that they are '-'
				assertEquals('-', test.board[i][j]);
			} 
		}
	}
	
	// Test for legal tic
	@Test
	public void testIsLegalTic(){
		Service test = new Service();
		assertTrue(test.isLegalTic(1,1));
	}

	// Test for illegal tic
	@Test
	public void testIsLegalTic2(){
		Service test = new Service();
		test.board[1][1] = 'X';
		assertFalse(test.isLegalTic(1,1));
	}

	@Test
	public void checkForFullBoard(){
		Service test = new Service();
		// Empty board tested
		assertFalse(test.checkForFullBoard());
		
		// Board filled with 'X'
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				test.board[i][j] = 'X';
			} 
		}
		assertTrue(test.checkForFullBoard());
	}

	// Test for horizontal win
	@Test
	public void testCheckForWin(){
		Service test = new Service();
		test.board[1][0] = 'X';
		test.board[1][1] = 'X';
		test.board[1][2] = 'X';
		// win for 'X'
		assertTrue(test.checkForWin());

		test.board[1][0] = 'O';
		test.board[1][1] = 'O';
		test.board[1][2] = 'O';
		// win for 'O'
		assertTrue(test.checkForWin());
	}

	// Test for vertical win
	@Test
	public void testCheckForWin2(){
		Service test = new Service();
		test.board[0][0] = 'X';
		test.board[1][0] = 'X';
		test.board[2][0] = 'X';
		// win for 'X'
		assertTrue(test.checkForWin());

		test.board[0][0] = 'O';
		test.board[1][0] = 'O';
		test.board[2][0] = 'O';
		// win for 'O'
		assertTrue(test.checkForWin());
	}

	// Test for diagonal win
	@Test
	public void testCheckForWin3(){
		Service test = new Service();
		test.board[0][0] = 'X';
		test.board[1][1] = 'X';
		test.board[2][2] = 'X';
		// win for 'X'
		assertTrue(test.checkForWin());

		test.board[2][0] = 'O';
		test.board[1][1] = 'O';
		test.board[0][2] = 'O';
		// win for 'O'
		assertTrue(test.checkForWin());
	}

	// Test for no win
	@Test
	public void testCheckForWin4(){
		Service test = new Service();
		// Empty board tested
		assertFalse(test.checkForWin());
	}

	// Test correct update of board
	@Test
	public void testUpdateBoard(){
		Service test = new Service();
		// get the current player
		char player = test.player;
		// update one field with current player mark
		test.updateBoard(1,1);
		assertEquals(player, test.board[1][1]);
		// update another field with next player
		player = test.player;
		test.updateBoard(0,1);
		assertEquals(player, test.board[0][1]);
		// try illegal move (same as previous player)
		// No need to update player here since the field should NOT change
		test.updateBoard(0,1);
		assertEquals(player, test.board[0][1]);
		// try another field!
		player = test.player;
		test.updateBoard(2,1);
		assertEquals(player, test.board[2][1]);
	}

	// Test for ai
	@Test
	public void testaiTic(){
		Service test = new Service();
		char player = test.player;
		test.aiTic();
		assertFalse(player == test.player);
	}

}

