package Main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TableTester {
	
	DominoTable t1 = new DominoTable(4);
	DominoTable t2 = new DominoTable(2);
	
	@Test
	void SpreadDominoes() {
		t1.spreadDominoes();
		t2.spreadDominoes();
		
		for (int i = 0; i < t1.getPlayers().length; i++) {
			assertTrue(isUnique(t1.getPlayers()[i].getHand()));
			assertEquals(7, t1.getPlayers()[i].getHand().size());
		}
		
		for (int i = 0; i < t2.getPlayers().length; i++) {
			assertTrue(isUnique(t2.getPlayers()[i].getHand()));
			assertEquals(7, t1.getPlayers()[i].getHand().size());
		}
		
		assertEquals(14, t2.getFreeHand().size());
		assertEquals(0, t1.getFreeHand().size());
		
		assertEquals(0, t2.getDominoes().size());
		assertEquals(0, t1.getDominoes().size());
		
		
	}
	
	@Test
	void DominoCount() {
		assertEquals(28, t1.getDominoes().size());
		for (int i = 0; i < t1.getDominoes().size(); i++) {
			t1.addToEnd(t1.getDominoes().get(i));
		}
		
		t1.addToEnd(new Domino(6,6));
		assertFalse(isUnique(t1.getDominoesOnTable()));
		assertEquals(29, t1.getDominoesOnTable().size());
		
		t1.reset();
		
		assertEquals(0, t1.getDominoesOnTable().size());
	}
	
	
	@Test
	void UniqueHands() {
		
		for (int i = 4; i >= 1; i--) {
			DominoTable t = new DominoTable(i);
			t.spreadDominoes();
			assertTrue(EveryHandIsUnique(t));
		}
		
	}
	
	@Test
	void Reset() {
		DominoTable t = new DominoTable(4);
		t.spreadDominoes();
		
		assertEquals(0, t.getDominoes().size());
		assertEquals(0, t.getFreeHand().size());
		assertEquals(4, t.getPlayers().length);
		assertNotNull(t.getPlayers()[0]);
		
		t.reset();
		
		assertEquals(28, t.getDominoes().size());
		assertEquals(4, t.getPlayers().length);
		assertNull(t.getPlayers()[0]);
		
	}
	
	private boolean EveryHandIsUnique(DominoTable t) {
		
		// Player i
		for (int i = 0; i < t.getPlayers().length - 1; i++) {
			Player player = t.getPlayers()[i];
			
			// Players after player i
			for (int k = i + 1 ; k < t.getPlayers().length; k++) {
				Player other = t.getPlayers()[k];
				
				// For each domino in player i
				for (int a = 0; a < player.getHand().size(); a++) {
					Domino d1 = player.getHand().get(a);
					
					// For each domino in the players after player i
					for (int b = 0; b < other.getHand().size(); b++) {
						Domino d2 = other.getHand().get(b);

						if (d1.equals(d2)){
							return false;
						}
					}
				}
			}		
		}
		
		return true;
		
	}
	
	
	private boolean isUnique(List<Domino> d) {
		
		// Check if a domino table list is unique

		for (int i = 0; i < d.size() - 1; i++) {
			Domino d1 = d.get(i);
			
			for (int k = i+1; k < d.size(); k++) {
				Domino d2 = d.get(k);
				if (d1.equals(d2)) {
					return false;
				}		
			}	
		}
		return true;
	}

}
