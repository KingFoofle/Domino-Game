package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

public class Domino {

	private int LEFT_VALUE;
	private int RIGHT_VALUE;
	private String direction;
	
	public Domino(int left, int right) {
		this.LEFT_VALUE = left;
		this.RIGHT_VALUE = right;
	}

	
	public int get_LEFT_VALUE() {return this.LEFT_VALUE;}
	public int get_RIGHT_VALUE() {return this.RIGHT_VALUE;}
	public boolean isDouble() {return this.get_LEFT_VALUE() == this.get_RIGHT_VALUE();}
	
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		// Draw here!
	}
	
	public String toString() {return this.get_LEFT_VALUE() + " | " + this.get_RIGHT_VALUE();}
	public boolean is_double() {return this.get_LEFT_VALUE() == this.get_RIGHT_VALUE();}
	
	public void invert() {
		int oldValue = this.get_LEFT_VALUE();
		this.LEFT_VALUE = this.get_RIGHT_VALUE();
		this.RIGHT_VALUE = oldValue;
	}
	
	public static Domino invert(Domino d) {
		return new Domino(d.get_RIGHT_VALUE(), d.get_LEFT_VALUE());
	}

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
