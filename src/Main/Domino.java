package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.Objects;

public class Domino {
	
	// Secret Password: Im learning Java and Python!

	
	// Instance Variables!
	private int LEFT_VALUE;
	private int RIGHT_VALUE;
	private int width = 60, height = 30;
	private int DOT_WIDTH = 5;
	private String direction = "hor"; // "hor" for horizontal, "ver" for vertical
	
	
	// Variables for "domino traveling"
	private boolean isVer = this.direction.equals("ver");
	private int h = isVer ? this.width : this.height;
	private int w = isVer ? this.height : this.width;
	private int horQuar = w/4, horHalf = w/2, horThreeQuar = w - horQuar;
	private int verQuar = h/4, verHalf = h/2, verThreeQuar = h - verQuar;
	
	
	/*
	 * EXERCISE 1: Dominoes! 
	 * 
	 * Problem 1: (Line 41 - 44)
	 * 		Create a constructor given 2 parameters: left and right
	 * 
	 * Problem 2: (Line 46 - 49)
	 * 		Create a constructor that takes a Domino as a parameter
	 * 			TIP: Remember that dominoes have a left and right value!
	 * 
	 * Problem 3: (Line 78 - 81)
	 * 		Complete the isDouble() method. It should return true if the domino is a double, otherwise false
	 * 			TIP: What makes a domino a double?
	 * 
	 * Problem 4: (Line 84 - 87)
	 * 		Complete the invert() method. It should MODIFY the LEFT_VALUE and the RIGHT_VALUE instance variables
	 * 			TIP: Swap algorithm!
	 * 
	 * Problem 5: (Line 89 - 91)
	 * 		Complete the STATIC invert() method. This method should RETURN a NEW domino with
	 * 		LEFT_VALUE and RIGHT_VALUE swapped
	 * 			TIP: Use the keyword "new" and the constructor from exercise 1!
	 * 
	 * 
	 */
	
	
	// Constructor 1: Fresh domino
	public Domino(int left, int right) {
		// TODO: Finish the Constructor!
	}
	
	// Constructor 2: Creating a domino using another domino
	public Domino(Domino otherDomino) {
		// TODO: Finish the Constructor!
	}

	
	// Getters
	public int get_LEFT_VALUE() {return this.LEFT_VALUE;}
	public int get_RIGHT_VALUE() {return this.RIGHT_VALUE;}
	
	
	// Setters
	
	
	// Setters
	public void set_direction(String dir) {
		this.direction = dir.toLowerCase();
		update();
	}
	
	
	private void update() {
		this.isVer = this.direction.equals("ver");
		this.h = this.isVer ? this.width : this.height;
		this.w = this.isVer ? this.height : this.width;
		
		// Measurements for "domino traveling"
		this.horQuar = this.w/4; this.horHalf = this.w/2; this.horThreeQuar = this.w - this.horQuar;
		this.verQuar = this.h/4; this.verHalf = this.h/2; this.verThreeQuar = this.h - this.verQuar;
	}

	
	
	public void draw(Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		int[] values = {this.get_LEFT_VALUE(), this.get_RIGHT_VALUE()};
		boolean secondNum = false;
		int horShift = 0, verShift = 0;
		

		for (int i : values) {
			horShift = (secondNum && !isVer) ? w/2 : 0;
			verShift = (secondNum && isVer) ? h/2 : 0;
			switch(i) {
			case 0:
				g2.drawImage(Images.zero, x + horShift, y + verShift, 30, 30, null);
				break;
			case 1:
				g2.drawImage(Images.one, x + horShift, y + verShift, 30, 30, null);
				break;
			case 2:
				if (isVer) {
					g2.drawImage(Images.two, x + horShift, y + verShift, 30, 30, null);
				}
				
				else {
					g2.drawImage(Images.twoTilt, x + horShift, y + verShift, 30, 30, null);
				}
				break;
			case 3:
				if (isVer) {
					g2.drawImage(Images.three, x + horShift, y + verShift, 30, 30, null);
				}
				
				else {
					g2.drawImage(Images.threeTilt, x + horShift, y + verShift, 30, 30, null);
				}				
				break;
			case 4:
				g2.drawImage(Images.four, x + horShift, y + verShift, 30, 30, null);
				break;
			case 5:
				g2.drawImage(Images.five, x + horShift, y + verShift, 30, 30, null);
				break;
			case 6:
				if (isVer) {
					g2.drawImage(Images.six, x + horShift, y + verShift, 30, 30, null);
				}
				
				else {
					g2.drawImage(Images.sixTilt, x + horShift, y + verShift, 30, 30, null);
				}				
				break;
				
			default:
				Line2D.Double line1 = new Line2D.Double(x,y,x+w, y+h);
				Line2D.Double line2 = new Line2D.Double(x + w,y,x, y+h);

				g2.draw(line1);
				g2.draw(line2);
			}
			
			secondNum = true;
		}
		
		
	}

	
	
	public boolean isDouble() {
		// TODO: Finish this method!
		return false;
	}
	
	// Non-Static Method Invert
	public void invert() {
		// TODO: Finish this method!
	}
	
	// Static Method Invert
	public static Domino invert(Domino d) {
		// TODO: Finish this method!
		return null;
	}

	@Override
	public String toString() {return this.get_LEFT_VALUE() + " | " + this.get_RIGHT_VALUE();}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Domino)) {
			return false;
		}
		Domino other = (Domino) obj;
		return LEFT_VALUE == other.LEFT_VALUE && RIGHT_VALUE == other.RIGHT_VALUE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(LEFT_VALUE, RIGHT_VALUE);
	}
	
}
