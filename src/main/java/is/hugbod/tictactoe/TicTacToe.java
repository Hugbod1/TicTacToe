package is.hugbod.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

	static Service service;
	JFrame frame;
	JButton[][] board;
	boolean singleplayer = false;

	private final int boardSize = 3;
	
	public TicTacToe() {
		frame = new JFrame("Tic Tac Toe by Hugboð");
		frame.setMinimumSize(new Dimension(550, 500));
		frame.setMaximumSize(new Dimension(600, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(boardSize, boardSize));
		frame.setLocation(500, 200);
		frame.setVisible(true);
		service = new Service();
		board = new JButton[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				board[i][j] = new JButton("");
				frame.getContentPane().add(board[i][j]);
				board[i][j].addActionListener(this);
			}
		}
		playingMode();
		display();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if(e.getSource()==board[i][j]) {
				service.updateBoard(i, j);
				}
			}
		}
		display();
		endConditions();

		if(singleplayer && !service.checkForWin() && !service.checkForFullBoard()) {
			// Let the AI play one move for 'O'
			aiTic();
		}
	}

	private void displayResult(char result) {
		String resultmsg;
		if(result == 'D') {
			resultmsg = "Match is draw!";
		}
		else if(result == 'X') {
			resultmsg = "Circle wins!";
		}
		else if(result == 'O') {
			resultmsg = "Cross wins!";
		}
		else {
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
		if(n == 0) {
			reset();
		}
		else {
			frame.dispose();
		}
	}

	private void display() {
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				board[i][j].setText("" + service.getBoard(i,j));
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
		if(service.checkForWin()) {
			displayResult(service.getCurrentPlayer());
		}
		// check if there is a draw (full board and no winner)
		else if(service.checkForFullBoard()) {
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
		if(n == 0) {
			singleplayer = true;
		}
		else {
			singleplayer = false;
		}
	}
}
