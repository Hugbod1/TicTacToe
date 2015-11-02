package is.hugbod.tictactoe;

public class Service
{
	char[][] board;
	char player;

	public Service() {
		board = new char[3][3];
		char player = "X";
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
	
	private boolean IsLegalTic(int row, int col) {
		return false;
	}
	
	public void ResetBoard() {
	
	}
}
