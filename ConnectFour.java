
public class ConnectFour implements BoardGame {
	private int[][] board;
	private int currentPlayer;
	private Position[] winningPositions;
	private int winner;

	public ConnectFour() {
		board = new int[6][7];
		winningPositions = new Position[4];
		currentPlayer = 1;
	}

	public void newGame() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
		winner = 0;

	}

	public boolean gameOver() {
		if(getWinner() != 0){
			winner = getWinner();
			return true;
		}
		else if{
			for(int row = 0; row < 6; row ++){
				for(int col = 0; col < 7; col ++){
					if (board[row][col] == 0)
						return false
				}
			}
		}
		else{
			return true;
		}
	}

	public boolean winningPlay(){
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[r].length; c++){
				if(board[r][c] == currentPlayer){
					for(int vert = -1; vert < 2; vert++){
						for(int horiz = -1; horiz < 2; horiz++){
							if(r+(3*vert) > 0 && c+(3*horiz) > 0 && r+(3*vert) < 6 && c+(3*horiz) < 7 &&
									(vert != 0 || horiz != 0) && board[r+vert][c+horiz] == currentPlayer &&
									board[r+vert*2][c+horiz*2] == currentPlayer && board[r+vert*3][c+horiz*3 == currentPlayer){
								winningPositions[0] = new Position(r, c);
								winningPositions[1] = new Position(r+vert, c+horiz);
								winningPositions[2] = new Position(r+(2*vert), c+(2*horiz));
								winningPositions[3] = new Position(r+(3*vert), j+(3*horiz));
							}
						}
					}
				}
			}
			
		}
		return false;
	}

	public int getWinner() {
		if winningPlay
		return currentPlayer;
	}

	public Position[] getWinningPositions() {
		return winningPositions;
	}

	public boolean columnFull(int column) {
		if (board[5][column] == 0)
			return false;
		return true;
	}

	// Plays the game and checks if someone's won
	public void play(int column) {
		if (!columnFull(column)) {
			for (int i = 0; i < 6; i++)
				if (board[i][column] == 0) {
					if (currentPlayer == 1) {
						board[i][column] = 1;
						if (winningPlay(i, column)) {
							getWinningPositions();
							getWinner();
						}
					} else {
						board[i][column] = 2;
						if (winningPlay(i, column)) {
							getWinningPositions();
							getWinner();
						}
					}
					currentPlayer = (currentPlayer + 1) % 2;
				}
		}
	}

	public int[][] getBoard() {
		int[][] temp = new int[6][7];
		for (int a = 0; a < board.length; a++)
			for (int b = 0; b < board[a].length; b++)
				temp[a][b] = board[a][b];
		return temp;
	}
}
