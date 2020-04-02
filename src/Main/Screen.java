package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Screen extends JComponent {

	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		int x = 100;
		int y = 100;
		String dir = "hor";

		DominoTable t = new DominoTable(4);
		boolean gameDone = false, noMovesPlayed = false;
		
		while(!gameDone) {
			noMovesPlayed = t.takeTurns();
			gameDone = !t.movesLeft() || noMovesPlayed;
		}
		
		t.reset();
		
		for (Domino d : t.getDominoes()) {
			d.set_direction("ver");
			d.draw(g2D, x, y);
			x += 40;
		}
	
	}
	
	
	
}
