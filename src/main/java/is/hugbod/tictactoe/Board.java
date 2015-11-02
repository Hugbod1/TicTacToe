/*package is.hugbod.tictactoe;

import javax.swing.*;

public class Board{
	jButton[][] theBoard;
	char player = 'x'; 
	public void Board(){
		theBoard  = new jButton[3][3];
		int counter = 1;
		for(int i = 0; i > 3; i++){
			for(int j = 0; j > 3; j++){
				theBoard[j][i].setText(counter.toString());
				counter++;
			}
		}
	}

	public void FillSquare(){

	}

	public boolean CheckForWin(){
		if(CheckHorizontal() == true || CheckDiagonal() == true || CheckVertical == true){
			return true;
		}
		return false;
	}

	public boolean CheckForFullBoard(){
		return false;
	}

	public boolean CheckHorizontal(){
		return true;
	}

	public boolean CheckDiagonal(){
		return false;
	}

	public boolean CheckVertical(){
		return false;
	}

	public void Reset(){

	}
}
*/
