public class Controller {
	private Model board;
	private View view;

	public Controller(Model board, View view) {
		this.board = board;
		this.view = view;
	}

	public void getBoard() {
		view.getBoard(board);
	}

	public void setDisk(int row, int col, int player) {
		board.setDisk(row, col, player);
	}

}
