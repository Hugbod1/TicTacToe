package is.hugbod.tictactoe;

public class Service
{
	char[][] board;
	char player;

	public Service() {
		board = new char[3][3];
		char player = 'X';
		ResetBoard();
	}

	public void UpdateBoard(int row, int col) {
	
	}

	private void CheckForWin() {
		
	}

	public boolean CheckForFullBoard() {
		return false;
	}
	
	private boolean CheckDiagonal() {
		return false;
	}
	
	private boolean CheckVertical() {
		return false;
	}
	
	private boolean CheckHorizontal() {
		return false;
	}
	
	public boolean IsLegalTic(int row, int col) {
		return board[row][col] == '-';
	}
	
	public void ResetBoard() {
		// Board set to zero
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '-';
			} 
		}
	}
}
