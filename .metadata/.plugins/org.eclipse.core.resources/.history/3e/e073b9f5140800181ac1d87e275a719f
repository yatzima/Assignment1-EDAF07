package src;

import java.util.ArrayList;

public class Agent {
	private int player;
	private Model game;

	public Agent(Model game, int player) {
		this.game = game;
		this.player = player;
	}

	public void move() {
		final long startTime = System.currentTimeMillis();
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
		// game.setDisk(row, col, player);
	}

	/** Defines the utility function for the mini-max adversarial search */
	private int utility() {
		ArrayList<Coordinate> ls = game.countLegalMoves(player);
		for (int i = 0; i < ls.size(); i++) {
			Model state = game;
			int row = ls.get(0).getRow();
			int col = ls.get(0).getCol();
			state.setDisk(row, col, player);
			int val = eval(state);
		}
		return 0;
	}

	private int eval(Model state) {
		if (game.ifGameEnd()) {
			return player == game.getWinner() ? 1 : 0;
		} else {
			int a = game.countPlayerDisks()[player - 1];
			int b = game.getNbrOfDisks();
			return a / b;
		}
	}

	private int maxVal() {
		// return coord and value
		return 0;
	}

	private int minVal() {
		// return coord and value
		return 0;
	}

	private int recursive() {
		return 0;
	}

}
