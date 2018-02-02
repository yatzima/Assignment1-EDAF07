import java.util.Scanner;

public class Controller {
	private Model board;
	private View view;
	private Scanner scan = new Scanner(System.in);
	private Player nextPlayer;
	private Player player1;
	private Player player2;

	public Controller(Model board, View view) {
		this.board = board;
		this.view = view;
		setUp();
		this.nextPlayer = player1; //1 always start
	}

	public void getBoard() {
		view.getBoard(board);
	}

	public void setDisk(int row, int col, int player) {
		board.setDisk(row, col, player);
	}
	
	public void startGame() {
		while(!board.ifGameEnd()){
		nextPlayer.move();	
		nextPlayer = (nextPlayer.number == 1 ? player2: player1);
		}
		announceWinner();
	}
	
	private void setUp() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Who is player 1?");
		printMenu();
		int choice = scan.nextInt();
		player1=createPlayer(choice, 1);
		System.out.println("Who is player 2?");
		printMenu();
		choice = scan.nextInt();
		player2=createPlayer(choice, 2);
	}
	
	private Player createPlayer(int choice, int nr) {
		if(choice ==1) {
			return new Agent(nr, board); 
		} else if(choice ==2) {
			return new HumanPlayer(nr, board);
		}
		return null;
	}
	private void printMenu() {
		System.out.println("Dator: 1");
		System.out.println("Människa: 2");
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
