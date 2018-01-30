public class Model {
	private final static int player1 = 1;
	private final static int player2 = 2;
	private int[][] board;

	public Model() {
		board = new int[8][8];
		setNewGame();
	}

	public int getRow() {
		return board.length;
	}

	public int getCol() {
		return board[0].length;
	}

	public int getPlayer(int row, int col) {
		if (isInsideBoard(row, col)) {
			return board[row][col];
		}
		return 0;
	}

	/** Public method for checking if there is any legal moves left. */
	public boolean ifGameEnd() {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				if (isLegalMove(i, j, player1) || isLegalMove(i, j, player2)) {
					return false;
				}
			}
		}
		return true;
	}

	public void markLegalMoves(int player) {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				if (isLegalMove(i, j, player)) {
					System.out.println("Här är en lösning:" + i + " " + j);
				}
			}
		}
	}

	public void setDisk(int row, int col, int player) {
		if (isLegalMove(row, col, player)) {
			setDiskUp(row, col, player);
			setDiskUpRight(row, col, player);
			setDiskRight(row, col, player);
			setDiskDownRight(row, col, player);
			setDiskDown(row, col, player);
			setDiskDownLeft(row, col, player);
			setDiskLeft(row, col, player);
			setDiskUpLeft(row, col, player);
		} else {
			System.out.println("Not a valid move! Try again!");
		}
	}

	private void setDiskUp(int row, int col, int player) {
		int newRow = row;
		int newCol = col;
		do {
			board[newRow][newCol] = player;
			newRow = newRow - 1;
		} while (checkUp(newRow, newCol, player));
		if (getPlayer(newRow, newCol) == getOppPlayer(player) && getPlayer(newRow - 1, newCol) != 0) {
			board[newRow][newCol] = player;
		}
	}

	private void setDiskUpRight(int row, int col, int player) {
		int newRow = row;
		int newCol = col;
		do {
			board[newRow][newCol] = player;
			newRow = newRow - 1;
			newCol = newCol + 1;
		} while (checkUpRight(newRow, newCol, player));
		if (getPlayer(newRow, newCol) == getOppPlayer(player) && getPlayer(newRow - 1, newCol + 1) != 0) {
			board[newRow][newCol] = player;
		}
	}

	private void setDiskRight(int row, int col, int player) {
		int newRow = row;
		int newCol = col;
		do {
			board[newRow][newCol] = player;
			newCol = newCol + 1;
		} while (checkRight(newRow, newCol, player));
		if (getPlayer(newRow, newCol) == getOppPlayer(player) && getPlayer(newRow, newCol + 1) != 0) {
			board[newRow][newCol] = player;
		}
	}

	private void setDiskDownRight(int row, int col, int player) {
		int newRow = row;
		int newCol = col;
		do {
			board[newRow][newCol] = player;
			newRow = newRow + 1;
			newCol = newCol + 1;
		} while (checkDownRight(newRow, newCol, player));
		if (getPlayer(newRow, newCol) == getOppPlayer(player) && getPlayer(newRow + 1, newCol + 1) != 0) {
			board[newRow][newCol] = player;
		}
	}

	private void setDiskDown(int row, int col, int player) {
		int newRow = row;
		int newCol = col;
		do {
			board[newRow][newCol] = player;
			newRow = newRow + 1;
		} while (checkDown(newRow, newCol, player));
		if (getPlayer(newRow, newCol) == getOppPlayer(player) && getPlayer(newRow + 1, newCol) != 0) {
			board[newRow][newCol] = player;
		}
	}

	private void setDiskDownLeft(int row, int col, int player) {
		int newRow = row;
		int newCol = col;
		do {
			board[newRow][newCol] = player;
			newRow = newRow + 1;
			newCol = newCol - 1;
		} while (checkDownLeft(newRow, newCol, player));
		if (getPlayer(newRow, newCol) == getOppPlayer(player) && getPlayer(newRow + 1, newCol - 1) != 0) {
			board[newRow][newCol] = player;
		}
	}

	private void setDiskLeft(int row, int col, int player) {
		int newRow = row;
		int newCol = col;
		do {
			board[newRow][newCol] = player;
			newCol = newCol - 1;
		} while (checkLeft(newRow, newCol, player));
		if (getPlayer(newRow, newCol) == getOppPlayer(player) && getPlayer(newRow, newCol - 1) != 0) {
			board[newRow][newCol] = player;
		}
	}

	private void setDiskUpLeft(int row, int col, int player) {
		int newRow = row;
		int newCol = col;
		do {
			board[newRow][newCol] = player;
			newRow = newRow - 1;
			newCol = newCol - 1;
		} while (checkUpLeft(newRow, newCol, player));
		if (getPlayer(newRow, newCol) == getOppPlayer(player) && getPlayer(newRow - 1, newCol - 1) != 0) {
			board[newRow][newCol] = player;
		}
	}

	/** Private method for clearing the board and setting the start disks. */
	private void setNewGame() {
		for (int row = 0; row < getRow(); row++) {
			for (int col = 0; col < getCol(); col++) {
				board[row][col] = 0;
			}
		}
		board[3][3] = player1;
		board[4][4] = player1;
		board[3][4] = player2;
		board[4][3] = player2;
	}

	private boolean isLegalMove(int row, int col, int player) {
		if (isInsideBoard(row, col) && hasNeighbours(row, col, player)) {
			return isSurrounded(row, col, player);
		}
		return false;

	}

	private boolean isInsideBoard(int row, int col) {
		return row >= 0 && row < 8 && col >= 0 && col < 8;
	}

	private boolean isOnTheEdge(int row, int col) {
		return row == 0 || row == (getRow() - 1) || col == 0 || col == (getRow() - 1);
	}

	private boolean hasNeighbours(int row, int col, int player) {
		int oppPlayer = getOppPlayer(player);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (isInsideBoard(row + i, col + j)) {
					if (oppPlayer == getPlayer(row + i, col + j)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private int getOppPlayer(int player) {
		return player == player1 ? player2 : player1;
	}

	private boolean isSurrounded(int row, int col, int player) {
		int oppPlayer = getOppPlayer(player);
		return checkUp(row, col, oppPlayer) || checkUpRight(row, col, oppPlayer) || checkRight(row, col, oppPlayer)
				|| checkDownRight(row, col, oppPlayer) || checkDown(row, col, oppPlayer)
				|| checkDownLeft(row, col, oppPlayer) || checkLeft(row, col, oppPlayer)
				|| checkUpLeft(row, col, oppPlayer);
	}

	private boolean checkUp(int row, int col, int player) {
		int newRow = row - 1;
		int newCol = col;
		int counter = 0;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow - 1;
				counter++;
				continue;
			} else if (getPlayer(newRow, newCol) == getOppPlayer(player)) {
				return counter > 0;
			} else if (getPlayer(newRow, newCol) == 0) {
				return false;
			}
		}
		return false;
	}

	private boolean checkUpRight(int row, int col, int player) {
		int newRow = row - 1;
		int newCol = col + 1;
		int counter = 0;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow - 1;
				newCol = newCol + 1;
				counter++;
				continue;
			} else if (getPlayer(newRow, newCol) == getOppPlayer(player)) {
				return counter > 0;
			} else if (getPlayer(newRow, newCol) == 0) {
				return false;
			}
		}
		return false;
	}

	private boolean checkRight(int row, int col, int player) {
		int newRow = row;
		int newCol = col + 1;
		int counter = 0;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newCol = newCol + 1;
				counter++;
				continue;
			} else if (getPlayer(newRow, newCol) == getOppPlayer(player)) {
				return counter > 0;
			} else if (getPlayer(newRow, newCol) == 0) {
				return false;
			}
		}
		return false;
	}

	private boolean checkDownRight(int row, int col, int player) {
		int newRow = row + 1;
		int newCol = col + 1;
		int counter = 0;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow + 1;
				newCol = newCol + 1;
				counter++;
				continue;
			} else if (getPlayer(newRow, newCol) == getOppPlayer(player)) {
				return counter > 0;
			} else if (getPlayer(newRow, newCol) == 0) {
				return false;
			}
		}
		return false;
	}

	private boolean checkDown(int row, int col, int player) {
		int newRow = row + 1;
		int newCol = col;
		int counter = 0;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow + 1;
				counter++;
				continue;
			} else if (getPlayer(newRow, newCol) == getOppPlayer(player)) {
				return counter > 0;
			} else if (getPlayer(newRow, newCol) == 0) {
				return false;
			}
		}
		return false;
	}

	private boolean checkDownLeft(int row, int col, int player) {
		int newRow = row + 1;
		int newCol = col - 1;
		int counter = 0;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow + 1;
				newCol = newCol - 1;
				counter++;
				continue;
			} else if (getPlayer(newRow, newCol) == getOppPlayer(player)) {
				return counter > 0;
			} else if (getPlayer(newRow, newCol) == 0) {
				return false;
			}
		}
		return false;
	}

	private boolean checkLeft(int row, int col, int player) {
		int newRow = row;
		int newCol = col - 1;
		int counter = 0;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newCol = newCol - 1;
				counter++;
				continue;
			} else if (getPlayer(newRow, newCol) == getOppPlayer(player)) {
				return counter > 0;
			} else if (getPlayer(newRow, newCol) == 0) {
				return false;
			}
		}
		return false;
	}

	private boolean checkUpLeft(int row, int col, int player) {
		int newRow = row - 1;
		int newCol = col - 1;
		int counter = 0;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow - 1;
				newCol = newCol - 1;
				counter++;
				continue;
			} else if (getPlayer(newRow, newCol) == getOppPlayer(player)) {
				return counter > 0;
			} else if (getPlayer(newRow, newCol) == 0) {
				return false;
			}
		}
		return false;
	}

}