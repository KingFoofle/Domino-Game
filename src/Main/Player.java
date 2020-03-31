package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

	private List<Domino> hand = new ArrayList<Domino>();
	public boolean isCPU = true;
	private Random random = new Random();
	
	public List<Domino> getHand() {return this.hand;}
	
	// TODO: Make a method that determines if the player can make a move given the table parameter
	public List<Domino> makeMove(List<Domino> table){
		
		// Can't make a move
		if (hand.size() == 0) {return table;}
		
		// Randomly place a domino down
		else if (table.size() == 0) {table.add(hand.get( random.nextInt( hand.size() ) ) ); return table;}

		for (int i = 0; i < hand.size(); i ++) {
			Domino d = hand.get(i);
			if (d.get_RIGHT_VALUE() == table.get(0).get_LEFT_VALUE()) {
				// Add to beginning
				hand.remove(i);
				table.add(0, d);
				break;
			}
			
			else if (d.get_LEFT_VALUE() == table.get(table.size() - 1).get_RIGHT_VALUE()) {
				// Add to end of board
				hand.remove(i);
				table.add(d);
				break;
			}
			
			else if (d.get_LEFT_VALUE() == table.get(0).get_LEFT_VALUE()) {
				// Add inverted to beginning
				hand.remove(i);
				table.add(0, Domino.invert(d));
				break;
			}
			
			else if (d.get_RIGHT_VALUE() == table.get(table.size() - 1).get_RIGHT_VALUE()) {
				// Add inverted to end
				hand.remove(i);
				table.add(Domino.invert(d));
				break;
			}
		}
		
		return table;
	}
}
