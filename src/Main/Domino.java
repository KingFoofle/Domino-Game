package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

public class Domino {
	
	// Secret Password:

	
	// Instance Variables!
	private int LEFT_VALUE;
	private int RIGHT_VALUE;
	private String direction = "hor"; // "hor" for horizontal, "ver" for vertical
	
	
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
		// TODO: Finish the constructor!
	}
	
	// Constructor 2: Creating a domino using another domino
	public Domino(Domino otherDomino) {
		// TODO: Finish the constructor
	}

	
	// Getters
	public int get_LEFT_VALUE() {return this.LEFT_VALUE;}
	public int get_RIGHT_VALUE() {return this.RIGHT_VALUE;}
	
	
	// Setters
	public void set_direction(String dir) {this.direction = dir.toLowerCase();}

	
	
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		// Draw here!
		
		switch(direction) {
		case "hor":
			// TODO: Draw domino sideways  (Ignore this)
			break;
			
		case "ver":
			// TODO: Draw domino vertically (Ignore this)
			break;
		}
		
	}
	
	public boolean isDouble() {
		// TODO: Complete this method!
			return false; // Dummy return, delete this
		}
	
	// Non-Static Method Invert
	public void invert() {
		// TODO: Complete this method!
	}
	
	// Static Method Invert
	public static Domino invert(Domino d) {
		// TODO: Complete this method!
		return null; // Dummy Return
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
