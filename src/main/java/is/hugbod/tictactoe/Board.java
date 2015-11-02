package is.hugbod.tictactoe;



public class Board{
	char[][] theBoard;
	char player = 'x'; 
	public void board(){
		theBoard  = new char[3][3];
	}

	public void FillSquare(){
		
	}

	public boolean CheckForWin(){
		if(CheckHorizontal() == true || CheckDiagonal() == true || CheckVertical == true){
			return true;
		}
		return false
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