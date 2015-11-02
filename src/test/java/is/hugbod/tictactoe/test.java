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

}

