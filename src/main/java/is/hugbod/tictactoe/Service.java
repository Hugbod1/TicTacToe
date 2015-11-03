package is.hugbod.tictactoe;

import java.util.Random;

public class Service {
	private char[][] board;
	private char player;
	private final int boardSize = 3;

	public Service() {
		board = new char[boardSize][boardSize];
		resetBoard();
	}

	public final void updateBoard(final int row, final int col) {
		if (!isLegalTic(row, col)) {
			// not a legal move
			return;
		}
		board[row][col] = player;

		// swap current player
		if (player == 'X') {
			player = 'O';
		} else {
			player = 'X';
		}
	}

	// Sets a certain square to a certain value. Only for unit tests
	public final void setBoard(final int row, final int col, final char value) {
		board[row][col] = value;
	}

	public final char getBoard(final int row, final int col) {
		return board[row][col];
	}

	public final char getCurrentPlayer() {
		return player;
	}

	public final boolean checkForWin() {
		return (checkDiagonal() || checkVertical() || checkHorizontal());
	}

	public final boolean checkForFullBoard() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (board[i][j] == '-') {
				return false;
				}
			}
		}
		return true;
	}

	private boolean checkDiagonal() {
		return (((board[1][1] != '-') && (((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
				|| ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])))));
	}

	private boolean checkVertical() {
		for (int i = 0; i < boardSize; i++) {
			if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}

	private boolean checkHorizontal() {
		for (int i = 0; i < boardSize; i++) {
			if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	public final boolean isLegalTic(final int row, final int col) {
		return ((board[row][col] != 'X') && (board[row][col] != 'O'));
	}

	public final void resetBoard() {
		// Board set to zero
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = '-';
			}
		}
		player = 'X';
	}

	public final void aiTic() {
		Random rn = new Random();
		char currentplayer = player;
		while (currentplayer == player) {
			// "click" on a random square until next player's turn
			updateBoard(rn.nextInt(boardSize), rn.nextInt(boardSize));
		}
	}
}
