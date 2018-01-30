import java.util.Scanner;

public class Reversi {

	public static void main(String[] args) {
		Model game = new Model();
		View view = new View(game);
		Controller con = new Controller(game, view);
		Scanner scan = new Scanner(System.in);
		
		con.getBoard(); //Ritar upp i konsolf�nstret
		int playerS = 1;
		
		while(!game.ifGameEnd()){
			int x = scan.nextInt();
			int y = scan.nextInt();
			//int player = scan.nextInt(); //Detta borde l�sas p� annat s�tt
			con.setDisk(x, y, playerS); 
			con.getBoard();
			game.markLegalMoves(playerS); //kolla p� denna
			playerS = (playerS == 1 ? 2: 1); //Byter tur. Vad h�nder om man inte gjorde ett giltigt drag?
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

