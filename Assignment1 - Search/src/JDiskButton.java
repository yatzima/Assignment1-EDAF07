package src;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JDiskButton extends JButton implements ActionListener{
	private int x;
	private int y;
	private Dimension d;
	
	public JDiskButton(int x, int y, int player) {
		super();
		this.x=x;
		this.y=y;
		
		Dimension d = new Dimension(40,40);
		setPreferredSize(d);
		setBackground(getColor(player));
		setOpaque(true);
		addActionListener(this);
	}
	
	 private Color getColor(int index) {
		 switch(index) {
		 case 0:
			 return Color.GREEN;
		 case 1:
			 return Color.black;
		 case 2:
			 return Color.white;
		 default:
			 return Color.green;
		 }
	 }
	public void getCoord() {
		System.out.println(x + " " + y);
	}
	
	 public void actionPerformed(ActionEvent e) { 
		    getCoord();
	  }
}
