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
		test.ResetBoard();
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
		assertTrue(test.IsLegalTic(1,1));
	}

	// Test for illegal tic
	@Test
	public void testIsLegalTic2(){
		Service test = new Service();
		test.board[1][1] = 'X';
		assertFalse(test.IsLegalTic(1,1));
	}

	// Test for horizontal win
	@Test
	public void testCheckForWin(){
		Service test = new Service();
		test.board[1][0] = 'X';
		test.board[1][1] = 'X';
		test.board[1][2] = 'X';
		// win for 'X'
		assertTrue(test.CheckForWin());

		test.board[1][0] = 'O';
		test.board[1][1] = 'O';
		test.board[1][2] = 'O';
		// win for 'O'
		assertTrue(test.CheckForWin());
	}

	// Test for vertical win
	@Test
	public void testCheckForWin2(){
		Service test = new Service();
		test.board[0][0] = 'X';
		test.board[1][0] = 'X';
		test.board[2][0] = 'X';
		// win for 'X'
		assertTrue(test.CheckForWin());

		test.board[0][0] = 'O';
		test.board[1][0] = 'O';
		test.board[2][0] = 'O';
		// win for 'O'
		assertTrue(test.CheckForWin());
	}

	// Test for diagonal win
	@Test
	public void testCheckForWin3(){
		Service test = new Service();
		test.board[0][0] = 'X';
		test.board[1][1] = 'X';
		test.board[2][2] = 'X';
		// win for 'X'
		assertTrue(test.CheckForWin());

		test.board[2][0] = 'O';
		test.board[1][1] = 'O';
		test.board[0][2] = 'O';
		// win for 'O'
		assertTrue(test.CheckForWin());
	}

	// Test for no win
	@Test
	public void testCheckForWin4(){
		Service test = new Service();
		// Empty board tested
		assertFalse(test.CheckForWin());
	}

}

