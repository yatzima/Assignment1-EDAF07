import java.util.Scanner;

public class Reversi {

	public static void main(String[] args) {
		Model game = new Model();
		View view = new View();
		Controller con = new Controller(game, view);
		Scanner scan = new Scanner(System.in);
		
		con.getBoard();
		int playerS = 1;
		
		while(!game.ifGameEnd()){
			int x = scan.nextInt();
			int y = scan.nextInt();
			int player = scan.nextInt();
			con.setDisk(x, y, player);
			con.getBoard();
			game.markLegalMoves(playerS);
			playerS = playerS == 1 ? 2: 1;
		}
		
//		con.getBoard();
//		con.setDisk(1, 1, 1);
//		con.getBoard();
//		con.setDisk(5, 4, 2);
//		con.getBoard();
//		con.setDisk(5, 5, 1);
//		con.getBoard();
//		con.setDisk(5, 6, 2);
//		con.getBoard();
	}

}

