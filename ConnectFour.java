
public class ConnectFour implements BoardGame {
	private int[][] board;
	private int currentPlayer;
	private Position[] winningPositions;
	private int winner;
	
	public ConnectFour() {
		
	}
	
	public void newGame() {
		board = new int[6][7];
		currentPlayer = 1;
	}
	
	public boolean gameOver() {
		return false;
	}
	
	public int getWinner() {
		return 1;
	}
	
	public Position[] getWinningPositions() {
		
	}
	
	 public boolean columnFull(int column) {
		 if(board[5][column] ==0)
		 return false;
		 return true;
	 }
	 
	 public void play(int column) {
		if(!columnFull(column)){
			for(int i = 0;i<6;i++)
				if(board[i][column] == 0) {
					if(currentPlayer == 1)
						board[i][column] = 1;
					else
						board[i][column] = 2;
					currentPlayer = (currentPlayer+1)%2;
			}
		}
	}
	 
	 public int[][] getBoard() {
		 int[][] temp = new int[6][7];
		 for(int a = 0; a < board.length; a++)
			 for(int b = 0; b < board[a].length; b++)
				 temp[a][b] = board[a][b];
		 return temp;
	 }
}
