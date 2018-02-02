import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
 
public class View{
	private Model board;
	public View(Model board){
		this.board=board;
		createWindow();
	}
	public void getBoard(Model board) {
		for (int row = 0; row < board.getRow(); row++) {
			for (int col = 0; col < board.getCol(); col++) {
				System.out.print(board.getPlayer(row, col));
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	 private void createWindow() {
		 JFrame frame = new JFrame("Reversi Game");
		 
		 //Closing the window exits the application
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 
//		 JLabel textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER); textLabel.setPreferredSize(new Dimension(300, 100)); 
//		 frame.getContentPane().add(textLabel, BorderLayout.CENTER); 

		 frame.getContentPane().setLayout(new GridLayout(board.getRow(),board.getCol()));
		
		 for(int i=0; i<board.getRow(); i++) {
			 for(int j =0; j<board.getCol(); j++) {
				 JButton disk = new JDiskButton(i,j, board.getPlayer(i, j));
				 frame.getContentPane().add(disk);
			 }
		 }
		 
		 
		 //Display the window
		 frame.setLocationRelativeTo(null);
		 frame.pack();
		 frame.setVisible(true); 
	 } 
	 
 

}
