package is.hugbod.tictactoe;

public class Service
{
	char[][] board;
	char player;

	public Service() {
		board = new char[3][3];
		resetBoard();
	}

	public void updateBoard(int row, int col) {
		if(!isLegalTic(row, col)) {
			// not a legal move
			return;
		}
		board[row][col] = player;

		// swap current player
		if(player == 'X') {
			player = 'O';
		}
		else {
			player = 'X';
		}
	}

	public boolean checkForWin() {
		return (checkDiagonal() || checkVertical() || checkHorizontal());
	}

	public boolean checkForFullBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == '-') {
				return false;
				}
			} 
		}
	return true;
	}
	
	private boolean checkDiagonal() {
		return (((board[1][1] != '-') && (((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) ||
				((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])))));
	}
	
	private boolean checkVertical() {
		for(int i = 0; i < 3; i++) {
			if(board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkHorizontal() {
		for(int i = 0; i < 3; i++) {
			if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isLegalTic(int row, int col) {
		return ((board[row][col] != 'X') && (board[row][col] != 'O'));
	}
	
	public void resetBoard() {
		// Board set to zero
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '-';
			} 
		}
		player = 'X';
	}
}
