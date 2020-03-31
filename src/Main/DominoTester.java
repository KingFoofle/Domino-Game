package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DominoTester {
	
	Domino d1 = new Domino(2, 4);
	Domino d2 = new Domino(d1);
	Domino d3 = new Domino(3,3);
	Domino d4 = new Domino(2,6);

	
	
	@Test
	void DominoConstuctor1() {

		assertNotEquals(0, d1.get_LEFT_VALUE(),  "Incorrect number given to LEFT_VALUE");
		assertNotEquals(0, d1.get_RIGHT_VALUE(), "Incorrect number given to RIGHT_VALUE");
		
		assertNotEquals(4, d1.get_LEFT_VALUE(), "You probably inverted LEFT_VALUE and RIGHT_VALUE");
		assertNotEquals(2, d1.get_RIGHT_VALUE(), "You probably inverted LEFT_VALUE and RIGHT_VALUE");
		
		assertEquals(2, d1.get_LEFT_VALUE(),  "Wrong value assigned to LEFT_VALUE");
		assertEquals(4, d1.get_RIGHT_VALUE(), "Wrong value assigned to RIGHT_VALUE");
		
	}
	
	@Test
	void DominoConstructor2() {
		assertNotEquals(0, d2.get_LEFT_VALUE(), "Incorrect number given to LEFT_VALUE");
		assertNotEquals(0, d2.get_RIGHT_VALUE(), "Incorrect number given to RIGHT_VALUE");
		assertEquals(d1.get_LEFT_VALUE(), d2.get_LEFT_VALUE(), "Your constructor is not assigning the correct number to LEFT_VALUE");
		assertEquals(d1.get_RIGHT_VALUE(), d2.get_RIGHT_VALUE(), "Your constructor is not assigning the correct number to RIGHT_VALUE");
	}
		
	@Test
	void isDouble() {
		
		assertFalse(d1.isDouble(), "This is not a double, check your method");
		assertFalse(d2.isDouble(), "This is not a double, check your method");
		assertTrue(d3.isDouble(), "This domino is a double, check your method");
		assertTrue(new Domino(6,6).isDouble(), "This domino is a double, check your method");
		
	}
	
	
	@Test
	void invertTest() {
		d1.invert();

		assertNotEquals(2, d1.get_LEFT_VALUE(), "You probably did not invert correctly");
		assertNotEquals(4, d1.get_RIGHT_VALUE(),"You probably did not invert correctly");
		
		assertEquals(4, d1.get_LEFT_VALUE(), "Wrong value assigned to LEFT_VALUE");
		assertEquals(2, d1.get_RIGHT_VALUE(), "Wrong value assigned to RIGHT_VALUE");
	}
	
	@Test
	void staticInvertTest() {
		Domino d5 = Domino.invert(d4);
		
		assertNotNull(d5, "You are not returning a new domino!");
		assertNotEquals(d5, d4, "You are not returning a NEW domino");
		
		assertNotEquals(d5.get_LEFT_VALUE(), 2, "You probably did not invert correctly");
		assertNotEquals(d5.get_RIGHT_VALUE(), 6, "You probably did not invert correctly");
		
		assertEquals(6, d5.get_LEFT_VALUE(), "Wrong value assigned to LEFT_VALUE");
		assertEquals(2, d5.get_RIGHT_VALUE(), "Wrong value assigned to RIGHT_VALUE");
	}
		

}
