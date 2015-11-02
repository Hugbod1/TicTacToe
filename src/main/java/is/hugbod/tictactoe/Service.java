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

	public boolean CheckForWin() {
		return (CheckDiagonal() || CheckVertical() || CheckHorizontal());
	}

	public boolean CheckForFullBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == '-') {
				return false;
				}
			} 
		}
	return true;
	}
	
	private boolean CheckDiagonal() {
		return (((board[1][1] != '-') && (board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) || 
				((board[1][1] != '-') && (board[0][2] == board[1][1]) && (board[1][1] == board[2][0])));
	}
	
	private boolean CheckVertical() {
		for(int i = 0; i < 3; i++) {
			if(board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean CheckHorizontal() {
		for(int i = 0; i < 3; i++) {
			if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
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
