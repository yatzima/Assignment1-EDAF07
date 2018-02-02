
public class Agent extends Player{
	private int max;
	private int min;
	private Model game;
	
	public Agent(int nbr, Model game){
		super(nbr);
		this.game = game;
	}
	
	/** Defines the utility function for the mini-max adversarial search */
	private int minimax(){
		return 0;
	}
}
