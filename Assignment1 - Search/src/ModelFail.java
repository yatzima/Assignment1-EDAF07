package src;
public class ModelFail {
	private final static int player1 = 1;
	private final static int player2 = 2;
	private int[][] board;

	public ModelFail() {
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
		return board[row][col];
	}

	public void setDisk(int row, int col, int player) {
		if (isLegalPlay(row, col, player)) {
			board[row][col] = player;
			setDiskUp(row, col, player);
			setDiskUpRight(row, col, player);
			setDiskRight(row, col, player);
			setDiskDownRight(row, col, player);
			setDiskDown(row, col, player);
			setDiskDownLeft(row, col, player);
			setDiskLeft(row, col, player);
			setDiskUpLeft(row, col, player);
		}
	}

	private void setDiskUp(int row, int col, int player){
		int newRow = row - 1;
		int newCol = col;
		while(checkUp(newRow, newCol, player)){
			board[newRow][newCol] = player;
			newRow = newRow - 1;
		}
		
		if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
			board[newRow][newCol] = player;
		}
	}
	
	private void setDiskUpRight(int row, int col, int player){
		int newRow = row - 1;
		int newCol = col + 1;
		while(checkUpRight(newRow, newCol, player)){
			board[newRow][newCol] = player;
			newRow = newRow - 1;
			newCol = newCol + 1;
		}
		if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
			board[newRow][newCol] = player;
		}
	}
	
	private void setDiskRight(int row, int col, int player){
		int newRow = row;
		int newCol = col + 1;
		while(checkRight(newRow, newCol, player)){
			board[newRow][newCol] = player;
			newCol = newCol + 1;
		}
		if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
			board[newRow][newCol] = player;
		}
	}
	
	private void setDiskDownRight(int row, int col, int player){
		int newRow = row + 1;
		int newCol = col + 1;
		while(checkDownRight(newRow, newCol, player)){
			board[newRow][newCol] = player;
			newRow = newRow + 1;
			newCol = newCol + 1;
		}
		if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
			board[newRow][newCol] = player;
		}
	}
	
	private void setDiskDown(int row, int col, int player){
		int newRow = row + 1;
		int newCol = col;
		while(checkDown(newRow, newCol, player)){
			board[newRow][newCol] = player;
			newRow = newRow + 1;
		}
		if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
			board[newRow][newCol] = player;
		}
	}
	
	private void setDiskDownLeft(int row, int col, int player){
		int newRow = row + 1;
		int newCol = col - 1;
		while(checkDownLeft(newRow, newCol, player)){
			board[newRow][newCol] = player;
			newRow = newRow + 1;
			newCol = newCol - 1;
		}
		if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
			board[newRow][newCol] = player;
		}
	}
	
	private void setDiskLeft(int row, int col, int player){
		int newRow = row;
		int newCol = col - 1;
		while(checkLeft(newRow, newCol, player)){
			board[newRow][newCol] = player;
			newCol = newCol - 1;
		}
		if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
			board[newRow][newCol] = player;
		}
	}
	
	private void setDiskUpLeft(int row, int col, int player){
		int newRow = row - 1;
		int newCol = col - 1;
		while(checkUpLeft(newRow, newCol, player)){
			board[newRow][newCol] = player;
			newRow = newRow - 1;
			newCol = newCol - 1;
		}
		if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
			board[newRow][newCol] = player;
		}
	}
	
//	private void setDiskUp(int row, int col, int player) {
//		board[row][col] = player;
//		int oppPlayer = getOppositePlayer(player);
//		if (getPlayer(row - 1, col) == oppPlayer && checkUp(row, col, player)) {
//			setDiskUp(row - 1, col, player);
//		} else if(getPlayer(row - 1, col) == player){
//			board[row - 1][col] = player;
//		}
//	}
//
//	private void setDiskUpRight(int row, int col, int player) {
//		board[row][col] = player;
//		int oppPlayer = getOppositePlayer(player);
//		if (getPlayer(row - 1, col + 1) == oppPlayer && checkUpRight(row, col, player)) {
//			setDiskUpRight(row - 1, col + 1, player);
//		}else if(getPlayer(row - 1, col + 1) == player){
//			board[row - 1][col + 1] = player;
//		}
//	}
//
//	private void setDiskRight(int row, int col, int player) {
//		board[row][col] = player;
//		int oppPlayer = getOppositePlayer(player);
//		if (getPlayer(row, col + 1) == oppPlayer && checkRight(row, col, player)) {
//			setDiskRight(row, col + 1, player);
//		}else if(getPlayer(row, col + 1) == player){
//			board[row][col + 1] = player;
//		}
//	}
//
//	private void setDiskDownRight(int row, int col, int player) {
//		board[row][col] = player;
//		int oppPlayer = getOppositePlayer(player);
//		if (getPlayer(row + 1, col + 1) == oppPlayer && checkDownRight(row, col, player)) {
//			setDiskDownRight(row + 1, col + 1, player);
//		}else if(getPlayer(row + 1, col + 1) == player){
//			board[row + 1][col + 1] = player;
//		}
//	}
//
//	private void setDiskDown(int row, int col, int player) {
//		board[row][col] = player;
//		int oppPlayer = getOppositePlayer(player);
//		if (getPlayer(row + 1, col) == oppPlayer && checkDown(row, col, player)) {
//			setDiskDown(row + 1, col, player);
//		}else if(getPlayer(row + 1, col) == player){
//			board[row + 1][col] = player;
//		}
//	}
//
//	private void setDiskDownLeft(int row, int col, int player) {
//		board[row][col] = player;
//		int oppPlayer = getOppositePlayer(player);
//		if (getPlayer(row + 1, col - 1) == oppPlayer && checkDownLeft(row, col, player)) {
//			setDiskDownLeft(row + 1, col - 1, player);
//		}else if(getPlayer(row + 1, col - 1) == player){
//			board[row + 1][col - 1] = player;
//		}
//	}
//
//	private void setDiskLeft(int row, int col, int player) {
//		board[row][col] = player;
//		int oppPlayer = getOppositePlayer(player);
//		if (getPlayer(row, col - 1) == oppPlayer && checkLeft(row, col, player)) {
//			setDiskLeft(row, col - 1, player);
//		}else if(getPlayer(row , col - 1) == player){
//			board[row][col - 1] = player;
//		}
//	}
//
//	private void setDiskUpLeft(int row, int col, int player) {
//		board[row][col] = player;
//		int oppPlayer = getOppositePlayer(player);
//		if (getPlayer(row - 1, col - 1) == oppPlayer && checkUpLeft(row, col, player)) {
//			setDiskUpLeft(row - 1, col - 1, player);
//		}else if(getPlayer(row - 1, col - 1) == player){
//			board[row - 1][col - 1] = player;
//		}
//	}

	private int getOppositePlayer(int player) {
		if (player == 0) {
			throw new Error();
		}
		return player == player1 ? player2 : player1;
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

	/** Public method for checking if there is any legal moves left. */
	public boolean checkIfWin() {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				if (isLegalPlay(i, j, player1) || isLegalPlay(i, j, player2)) {
					return false;
				}
			}
		}
		return true;
	}

	/** Private method for checking if the move is legal. */
	private boolean isLegalPlay(int row, int col, int player) {
		// int oppPlayer = getOppositePlayer(player);
		if (isInsideBoard(row, col) && checkForNeighbours(row, col, player)) {
			return checkIfSurrounded(row, col, player);
		}
		return false;
	}

	private boolean isInsideBoard(int row, int col) {
		return row >= 0 && row < 8 && col >= 0 && col < 8;
	}

	private boolean isOnTheEdge(int row, int col) {
		return row == 0 || row == (getRow() - 1) || col == 0 || col == (getRow() - 1);
	}

	private boolean checkIfSurrounded(int row, int col, int player) {
		int oppPlayer = getOppositePlayer(player);
		return checkUp(row, col, oppPlayer) || checkUpRight(row, col, oppPlayer) || checkRight(row, col, oppPlayer)
				|| checkDownRight(row, col, oppPlayer) || checkDown(row, col, oppPlayer)
				|| checkDownLeft(row, col, oppPlayer) || checkLeft(row, col, oppPlayer)
				|| checkUpLeft(row, col, oppPlayer);
	}

	private boolean checkForNeighbours(int row, int col, int player) {
		int oppPlayer = getOppositePlayer(player);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (oppPlayer == getPlayer(row + i, col + j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkUp(int row, int col, int player) {
		int newRow = row - 1;
		int newCol = col;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow - 1;
			} else if(getPlayer(newRow, col) == getOppositePlayer(player)){
				return true;
			}else if(getPlayer(newRow, newCol) == 0){
				return false;
			}
		}
		return false;
	}

	private boolean checkUpRight(int row, int col, int player) {
		int newRow = row - 1;
		int newCol = col + 1;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow - 1;
				newCol = newCol + 1;
			} else if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
				return true;
			}else if(getPlayer(newRow, newCol) == 0){
				return false;
			}
		}
		return false;
	}
	
	private boolean checkRight(int row, int col, int player) {
		int newRow = row;
		int newCol = col + 1;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newCol = newCol + 1;
			} else if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
				return true;
			}else if(getPlayer(newRow, newCol) == 0){
				return false;
			}
		}
		return false;
	}
	
	private boolean checkDownRight(int row, int col, int player) {
		int newRow = row + 1;
		int newCol = col + 1;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow + 1;
				newCol = newCol + 1;
			} else if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
				return true;
			} else if(getPlayer(newRow, newCol) == 0){
				return false;
			}
			
		}
		return false;
	}
	
	private boolean checkDown(int row, int col, int player) {
		int newRow = row + 1;
		int newCol = col;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow + 1;
			} else if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
				return true;
			} else if(getPlayer(newRow, newCol) == 0){
				return false;
			}
		}
		return false;
	}
	
	private boolean checkDownLeft(int row, int col, int player) {
		int newRow = row + 1;
		int newCol = col - 1;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow + 1;
				newCol = newCol - 1;
			} else if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
				return true;
			} else if(getPlayer(newRow, newCol) == 0){
				return false;
			}
		}
		return false;
	}
	
	private boolean checkLeft(int row, int col, int player) {
		int newRow = row;
		int newCol = col - 1;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newCol = newCol - 1;
			} else if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
				return true;
			} else if(getPlayer(newRow, newCol) == 0){
				return false;
			}
		}
		return false;
	}
	
	private boolean checkUpLeft(int row, int col, int player) {
		int newRow = row - 1;
		int newCol = col - 1;
		while (isInsideBoard(newRow, newCol)) {
			if (getPlayer(newRow, newCol) == player) {
				newRow = newRow - 1;
				newCol = newCol - 1;
			} else if(getPlayer(newRow, newCol) == getOppositePlayer(player)){
				return true;
			} else if(getPlayer(newRow, newCol) == 0){
				return false;
			}
		}
		return false;
	}
	
	/** Returns true if disk are surrounded upwards. */
	// private boolean checkUp(int row, int col, int player) {
	// if (!isInsideBoard(row, col) || isOnTheEdge(row, col)) {
	// return false;
	// }
	//
	// if (player == getPlayer(row-1, col)) {
	// checkUp(row-1, col, player);
	// }
	// return true;
	// }

//	private boolean checkUpRight(int row, int col, int player) {
//		if (!isInsideBoard(row, col) || isOnTheEdge(row, col)) {
//			return false;
//		}
//		if (player == getPlayer(row - 1, col + 1)) {
//			checkUpRight(row - 1, col + 1, player);
//		}
//		return true;
//	}
//
//	private boolean checkRight(int row, int col, int player) {
//		if (!isInsideBoard(row, col) || isOnTheEdge(row, col)) {
//			return false;
//		}
//
//		if (player == getPlayer(row, col + 1)) {
//			checkRight(row, col + 1, player);
//		}
//		return true;
//	}
//
//	private boolean checkDownRight(int row, int col, int player) {
//		if (!isInsideBoard(row, col) || isOnTheEdge(row, col)) {
//			return false;
//		}
//
//		if (player == getPlayer(row + 1, col + 1)) {
//			checkDownRight(row + 1, col + 1, player);
//		}
//		return true;
//	}
//
//	private boolean checkDown(int row, int col, int player) {
//		if (!isInsideBoard(row, col) || isOnTheEdge(row, col)) {
//			return false;
//		}
//
//		if (player == getPlayer(row + 1, col)) {
//			checkDown(row + 1, col, player);
//		}
//		return true;
//	}
//
//	private boolean checkDownLeft(int row, int col, int player) {
//		if (!isInsideBoard(row, col) || isOnTheEdge(row, col)) {
//			return false;
//		}
//
//		if (player == getPlayer(row + 1, col - 1)) {
//			checkDownLeft(row + 1, col - 1, player);
//		}
//		return true;
//	}
//
//	private boolean checkLeft(int row, int col, int player) {
//		if (!isInsideBoard(row, col) || isOnTheEdge(row, col) || getPlayer(row, col - 1) == 0) {
//			return false;
//		}
//
//		if (player == getPlayer(row, col - 1)) {
//			checkLeft(row, col - 1, player);
//		}
//		return true;
//	}
//
//	private boolean checkUpLeft(int row, int col, int player) {
//		if (!isInsideBoard(row, col) || isOnTheEdge(row, col)) {
//			return false;
//		}
//
//		if (player == getPlayer(row - 1, col - 1)) {
//			checkUpLeft(row - 1, col - 1, player);
//		}
//		return true;
//	}
}