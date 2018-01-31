import java.util.Scanner;

public class Controller {
	private Model board;
	private View view;
	private Scanner scan = new Scanner(System.in);
	private int nextPlayer;

	public Controller(Model board, View view) {
		this.board = board;
		this.view = view;
		this.nextPlayer = 1; //1 always start
	}

	public void getBoard() {
		view.getBoard(board);
	}

	public void setDisk(int row, int col, int player) {
		board.setDisk(row, col, player);
	}
	
	public void startGame() {
		while(!board.ifGameEnd()){
			int x = scan.nextInt();
			int y = scan.nextInt();
			//int player = scan.nextInt(); //Detta borde lösas på annat sätt
			board.setDisk(x, y, nextPlayer); //Denna kanske skulle kunna returnera boolean
			getBoard(); //Bara om man gjode legal move
			board.markLegalMoves(nextPlayer); //kolla på denna. Verkar inte stämma helt. Skriver denna ut varje gång?
			nextPlayer = (nextPlayer == 1 ? 2: 1); //Byter tur. Vad händer om man inte gjorde ett giltigt drag?
		}
		
		announceWinner();
	}
	
	private void announceWinner() {
		int player1 = 0;
		int player2 = 0;
		for(int i = 0; i<board.getRow(); i++) {
			for(int j=0; j<board.getCol(); j++) {
				int disk = board.getPlayer(i, j);
				if(disk ==1) {
					player1++;
				} else if(disk==2){
					player2++;
				}
			}
		}
		int winner = (player1>player2 ? 1:2);
		System.out.println("Player " + winner + " won. The result is is: " + player1 + " - " + player2);
	}

}
