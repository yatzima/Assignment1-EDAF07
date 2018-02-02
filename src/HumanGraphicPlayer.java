import java.util.Scanner;

public class HumanGraphicPlayer extends Player{
	private Scanner scan = new Scanner(System.in);
	private Model board;
	private Coordinate latestCoord;
	
	public HumanGraphicPlayer(int number, Model board) {
		super(number);
		this.board=board;
	}
	
	public Coordinate move() {
		
		board.setDisk(x, y, this.number); //Denna kanske skulle kunna returnera boolean
		//getBoard(); //Bara om man gjode legal move
		//board.markLegalMoves(nextPlayer); //kolla på denna. Verkar inte stämma helt. Skriver denna ut varje gång?
		//nextPlayer = (nextPlayer == 1 ? 2: 1); //Byter tur. Vad händer om man inte gjorde ett giltigt drag?
		return null;
	}
	
	public void registerClick(Coordinate c) {
		latestCoord = c;
	}
}
