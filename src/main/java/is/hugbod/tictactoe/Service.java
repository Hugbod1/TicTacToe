package is.hugbod.tictactoe;

public class Service {
	char[][] board;
	char player;
	int size = 3;

	public Service() {
		board = new char[size][size];
		player = 'X';
		ResetBoard();
	}

	public void UpdateBoard(int row, int col) {
		if (!IsLegalTic(row, col)) {
			// not a legal move
			return;
		}
		board[row][col] = player;

		// swap current player
		if (player == 'X') {
			player = 'O';
		}
		else {
			player = 'X';
		}
	}

	public boolean CheckForWin() {
		return (CheckDiagonal() || CheckVertical() || CheckHorizontal());
	}

	public boolean CheckForFullBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}

	private boolean CheckDiagonal() {
		return (((board[1][1] != '-') && (((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) ||
				((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])))));
	}

	private boolean CheckVertical() {
		for (int i = 0; i < size; i++) {
			if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}

	private boolean CheckHorizontal() {
		for (int i = 0; i < size; i++) {
			if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	public boolean IsLegalTic(int row, int col) {
		return ((board[row][col] != 'X') && (board[row][col] != 'O'));
	}

	public void ResetBoard() {
		// Board set to zero
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = '-';
			}
		}
	}
}
