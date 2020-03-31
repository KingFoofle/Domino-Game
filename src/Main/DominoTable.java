package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DominoTable {
	
	// We use ArrayLists so we can add in specific indexes
	private List<Domino> dominoes = createDeck();
	private List<Domino> dominoesOnTable = new ArrayList<Domino>();
	private int NUMBER_OF_PLAYERS;

	private Player[] players;
	private List<Domino> freeHand = new ArrayList<Domino>();
	
	private static Random random = new Random();
	
	
	public DominoTable(int numPlayers) {
		
		// If the range of the number of players is invalid, set it to 2 players
		if (numPlayers > 4 || numPlayers < 1) {numPlayers = 2;}
		
		this.NUMBER_OF_PLAYERS = numPlayers;
		this.players = new Player[numPlayers];
		
		this.spreadDominoes();
	}
	
	// Getters
	public List<Domino> getDominoes() {return dominoes;}
	public List<Domino> getDominoesOnTable() {return dominoesOnTable;}
	public Player[] getPlayers() {return players;}
	public List<Domino> getFreeHand() {return freeHand;}

	
	
	// Works
	public void spreadDominoes() {
		// Only spread if the table is new
		if (this.getDominoes().size() != 28) {reset();}
		for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
			Player player = new Player();
			
			for (int k = 0; k < 7; k++) {
				Domino domino = this.getDominoes().remove(this.getDominoes().size()- 1);
				player.getHand().add(domino);

			}
			this.getPlayers()[i] = player;
		}

		this.freeHand = this.getDominoes();
		this.dominoes = new ArrayList<Domino>();
	}
	
	
	// TODO: Make method that gives takes a player param, and gives the player the table so that THEIR method determines
	// if they have a play or not
	

	public void addToFront(Domino d) {
		this.getDominoesOnTable().add(0, d);
	}
	
	public void addToEnd(Domino d) {
		this.getDominoesOnTable().add(d);
	}
	
	public boolean takeTurns() {
		int oldLen = dominoesOnTable.size();
		for (int i = 0; i < players.length; i++) {
			this.dominoesOnTable = players[i].makeMove(this.dominoesOnTable);
		}
		
		return dominoesOnTable.size() == oldLen;
		
	}
	
	// Reset the Table and all its hands
	public void reset() {
		this.dominoes = createDeck();
		this.players = new Player[NUMBER_OF_PLAYERS];
		this.dominoesOnTable = new ArrayList<Domino>(); 
		this.freeHand = new ArrayList<Domino>();
	}
	
	public boolean gameIsValid() {
		for (int i = 0; i < this.getDominoesOnTable().size() - 1; i++) {
			if (this.getDominoesOnTable().get(i).get_RIGHT_VALUE() != this.getDominoesOnTable().get(i+1).get_LEFT_VALUE() ) {
				return false;
			}
		}
		return true;
	}
	
	public boolean movesLeft() {
		
		// TODO: Add more checking options.
		// For example: If no players can move, end the game
		
		List<Domino> dominoes = this.getDominoesOnTable();
		if (this.dominoes.size() == 28) {return false;}
		
		for (int i = 0; i < 7; i++) { // For each number
			int timesFound = 0;
			for (Domino d : dominoes) {
				if (i == d.get_LEFT_VALUE() || i == d.get_RIGHT_VALUE()) {
					timesFound++;
				}
			}
			
			// If all of i was played AND both sides end with i, no more moves are left
			if (timesFound == 7 && dominoes.get(0).get_LEFT_VALUE() == i && dominoes.get(dominoes.size() - 1 ).get_RIGHT_VALUE() == i) {
				return false;
			}
		}
		
		return true;
	}
	
	private List<Domino> createDeck(){
		List<Domino> deckToReturn = new ArrayList<Domino>();
		for (int i = 0; i < 7; i++) { // [0,6]
			for (int k = i; k < 7; k++) { // [0,6]
				deckToReturn.add(new Domino(i,k));
			}
		}
		return DominoTable.shuffle(deckToReturn);
	}
	
	
	private static List<Domino> shuffle(List<Domino> d){
		
		List<Domino> toReturn = new ArrayList<Domino>();
		int size = d.size();
		for (int i = 0; i < size; i++) {
			Domino e = d.remove(random.nextInt(d.size()));
			toReturn.add(e);
		}
		
		return toReturn;
	}
	


	
	
}
