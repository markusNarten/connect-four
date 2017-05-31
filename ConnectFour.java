/**
 * a connect four game
 * @author 18helling/18narten
 *@version 5/30/2017
 */
public class ConnectFour implements BoardGame {
	private int[][] board;
	private int currentPlayer;
	private Position[] winningPositions;
	private int winner;

	/**
	 * default constructor for a connect four game
	 */
	public ConnectFour() {
		board = new int[6][7];
		winningPositions = new Position[4];
		winningPositions[0] = new Position();
		winningPositions[1] = new Position();
		winningPositions[2] = new Position();
		winningPositions[3] = new Position();
		currentPlayer = 1;
	}

	/**
	 * generates a new game of connect four
	 */
	public void newGame() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
		winner = 0;
		winningPositions = new Position[4];
		winningPositions[0] = new Position();
		winningPositions[1] = new Position();
		winningPositions[2] = new Position();
		winningPositions[3] = new Position();
		currentPlayer = 1;

	}

	/**
	 * determines if the game has ended
	 * @return if the game is over
	 */
	public boolean gameOver() {
		if (getWinner() != 0) {
			winner = getWinner();
			return true;
		} else {
			for (int row = 0; row < 6; row++) {
				for (int col = 0; col < 7; col++) {
					if (board[row][col] == 0)
						return false;
				}
			}
			return true;
		}
		
	}

	/**
	 * determines if there is a winner for the game
	 * @return the winner, 0 if no winner
	 */
	public int getWinner() {
		for(int p = 1; p< 3;p++)
			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[r].length; c++) {
					if (board[r][c] == p) {
						for (int vert = -1; vert < 2; vert++) {
							for (int horiz = -1; horiz < 2; horiz++) {
								if ((r + (3 * vert) > 0) && (c + (3 * horiz) > 0) && (r + (3 * vert) < 6)
										&& (c + (3 * horiz) < 7) && ((vert != 0 || horiz != 0))
										&& (board[r + vert][c + horiz] == p)
										&& (board[r + vert * 2][c + horiz * 2] == p)
										&& (board[r + vert * 3][c + horiz * 3] == p)) {
									winningPositions[0] = new Position(r, c);
									winningPositions[1] = new Position(r + vert, c + horiz);
									winningPositions[2] = new Position(r + (2 * vert), c + (2 * horiz));
									winningPositions[3] = new Position(r + (3 * vert), c + (3 * horiz));
									return p;
								}
	
							}
						}
					}
				}
	
			}
		return 0;
	}

	/**
	 * returns the winning positions
	 * @return the positions
	 */
	public Position[] getWinningPositions() {
		return winningPositions;
	}

	public boolean columnFull(int column) {
		return (board[0][column] != 0);
	}
 /**
  * Plays the game and checks if someone's won
  */
	public void play(int column) {
		if (!columnFull(column)) {
			for (int i = board.length-1; i >= 0; i--){
				if (board[i][column] == 0) {
					if (currentPlayer == 1) {
						board[i][column] = 1;
					}
				 else {
					board[i][column] = 2;
					break;
				}
			}
			currentPlayer = currentPlayer % 2 + 1;
		}
	}

	/**
	 * returns the boardstate
	 * @return the board
	 */
	public int[][] getBoard() {
		return board;
	}
}
