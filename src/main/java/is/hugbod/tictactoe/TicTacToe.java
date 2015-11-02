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
		frame.setLayout(new GridLayout(3, 3));
		frame.setLocation(500, 200);
		frame.setVisible(true);
		service = new Service();
		board = new JButton[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = new JButton("-");
				frame.getContentPane().add(board[i][j]);
				board[i][j].addActionListener(this);
			}
		}
	}

	public static void play() {

	}

	public void actionPerformed(ActionEvent e) {

	}

	private void Reset() {

	}
}
