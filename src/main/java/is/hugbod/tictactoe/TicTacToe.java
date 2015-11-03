package is.hugbod.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

	static Service service;
	JFrame frame;
	JButton[][] board;
	
	public TicTacToe() {
		JFrame frame = new JFrame("Tic Tac Toe by Hugboð");
		frame.setMinimumSize(new Dimension(550, 500));
		frame.setMaximumSize(new Dimension(600, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 3));
		frame.setLocation(500, 200);
		frame.setVisible(true);
		service = new Service();
		board = new JButton[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = new JButton("");
				frame.getContentPane().add(board[i][j]);
				board[i][j].addActionListener(this);
			}
		}
		display();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(e.getSource()==board[i][j]) {
				service.updateBoard(i, j);
				}
			}
		}
		display();
		if(service.checkForWin()) {
			displayResult(service.player);
		}
		else if(service.checkForFullBoard()) {
			displayResult('D');
		}
	}

	private void displayResult(char result) {
		String resultmsg;
		if(result == 'D') {
			resultmsg = "Match is draw!";
		}
		if(result == 'X') {
			resultmsg = "Circle wins!";
		}
		else {
			resultmsg = "Cross wins!";
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
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j].setText("" + service.board[i][j]);
			}
		}
	}

	private void reset() {
		service.resetBoard();
		display();
	}
}
