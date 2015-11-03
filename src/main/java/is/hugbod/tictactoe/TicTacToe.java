package is.hugbod.tictactoe;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

	private static Service service;
	private JFrame frame;
	private JButton[][] board;
	private boolean singleplayer = false;

	private final int boardSize = 3;
	private final int minFrameSizeX = 550;
	private final int minAndMaxFrameSizeY = 500;
	private final int maxFrameSizeX = 600;
	private final int locationX = 500;
	private final int locationY = 200;

	public TicTacToe() {
		frame = new JFrame("Tic Tac Toe by Hugboð");
		frame.setMinimumSize(new Dimension(minFrameSizeX, minAndMaxFrameSizeY));
		frame.setMaximumSize(new Dimension(maxFrameSizeX, minAndMaxFrameSizeY));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(boardSize, boardSize));
		frame.setLocation(locationX, locationY);
		frame.setVisible(true);
		service = new Service();
		board = new JButton[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = new JButton("");
				frame.getContentPane().add(board[i][j]);
				board[i][j].addActionListener(this);
			}
		}
		playingMode();
		display();
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {
		boolean legal = false;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (e.getSource() == board[i][j]) {
					legal = service.isLegalTic(i, j);
					service.updateBoard(i, j);
				}
			}
		}
		display();
		endConditions();

		if (legal && singleplayer && !service.checkForWin() && !service.checkForFullBoard()) {
			// Let the AI play one move for 'O'
			aiTic();
		}
	}

	private void displayResult(final char result) {
		String resultmsg;
		if (result == 'D') {
			resultmsg = "Match is draw!";
		} else if (result == 'X') {
			resultmsg = "Circle wins!";
		} else if (result == 'O') {
			resultmsg = "Cross wins!";
		} else {
			resultmsg = "WHAT?";
		}
		Object[] options = {"Rematch", "No, thanks"};
		int n = JOptionPane.showOptionDialog(
			null,
			resultmsg,
			"Result",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[1]);
		if (n == 0) {
			reset();
		} else {
			frame.dispose();
		}
	}

	private void display() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j].setText("" + service.getBoard(i, j));
			}
		}
	}

	private void reset() {
		service.resetBoard();
		display();
	}

	private void aiTic() {
		service.aiTic();
		display();
		endConditions();
	}

	// check for end conditions
	private void endConditions() {
		// check if there is a winner
		if (service.checkForWin()) {
			displayResult(service.getCurrentPlayer());
		} else if (service.checkForFullBoard()) {
			// check if there is a draw (full board and no winner)
			displayResult('D');
		}
	}


	private void playingMode() {
		Object[] options = {"Single Player", "2 Player"};
		int n = JOptionPane.showOptionDialog(
			null,
			"vs computer or player?",
			"Result",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[1]);
		if (n == 0) {
			singleplayer = true;
		} else {
			singleplayer = false;
		}
	}
}
