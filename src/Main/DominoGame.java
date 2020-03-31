package Main;

public class DominoGame {

	public static void main(String[] args) {
		DominoTable t = new DominoTable(4);
		boolean gameDone = false, noMovesPlayed = false;
		
		while(!gameDone) {
			noMovesPlayed = t.takeTurns();
			gameDone = !t.movesLeft() || noMovesPlayed;
		}
		
		System.out.println(t.getDominoesOnTable());
		
		System.out.println("===");
		
		for (int i = 0; i < t.getPlayers().length; i++) {
			System.out.println(t.getPlayers()[i].getHand());
		}

	}

}
