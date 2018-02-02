
public class Coordinate {
	private int row;
	private char col;
	
	/**
	 * X = column
	 * Y = row
	 * @param XY
	 */
	public Coordinate(String XY) {
			col = Character.toLowerCase(XY.charAt(0));
			row = XY.charAt(1);
	}
	
	public Coordinate(int row, int col){
		this.row = row;
		this.col = (char) col;
		
	}

	public int getRow() {
		return row;
	}
	
	public int getCol(){
		switch(col){
		case 'a':
		return 0;
		case 'b':
		return 1;
		case 'c':
		return 2;
		case 'd':
		return 3;
		case 'e':
		return 4;
		case 'f':
		return 5;
		case 'g':
		return 6;
		case 'h':
		return 7;
		default:
			return -1;
			
		}
			
		
	}
}
