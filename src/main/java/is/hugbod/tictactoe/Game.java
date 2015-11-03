package is.hugbod.tictactoe;

public final class Game {

	private static TicTacToe game;

	private Game() {
	}

	public static void main(final String[] args) {
		game = new TicTacToe();
	}
}
