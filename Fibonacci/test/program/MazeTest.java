package program;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazeTest
{

	@Test
	public void testMaze()
	{
		PlayerLocation startLoc = new PlayerLocation();
		startLoc.row = 0;
		startLoc.col = 1;
		Maze m = new Maze();
		PlayerLocation playerLoc = m.playerLocation();
				
		assertEquals(startLoc.row, playerLoc.row);
		assertEquals(startLoc.col, playerLoc.col);
		
		assertFalse(m.canMoveNorth());
		assertTrue(m.canMoveSouth());
		
		PlayerLocation movedLoc = m.moveSouth();
		playerLoc = m.playerLocation();
		
		assertEquals(movedLoc.row, playerLoc.row);
		assertEquals(movedLoc.col, playerLoc.col);

		assertEquals(startLoc.row+1, playerLoc.row);
		assertEquals(startLoc.col, playerLoc.col);
	}

	@Test
	public void testToString()
	{
		String expected = "XPXXXXXXXXXXXXX\n" + 
				"X   X         X\n" + 
				"XX    X XXX   X\n" + 
				"X XXXX  XWX   X\n" + 
				"X      XX X   X\n" + 
				"X  X XXX     XX\n" + 
				"X  X        X X\n" + 
				"X  X XAX   X  X\n" + 
				"X  X XXX  X   X\n" + 
				"X  X     X    X\n" + 
				"X  X    X     X\n" + 
				"X  XX  X  XXXXX\n" + 
				"X  QX     X   X\n" + 
				"X  XX XXX X X X\n" + 
				"X  X   ZX   X X\n" + 
				"XXXXXXXXXXXXXEX\n";
		
		Maze m = new Maze();
		String maze = m.toString();
		assertEquals("Expecting to match", expected, maze);
		

		expected = "XSXXXXXXXXXXXXX\n" + 
				"XP  X         X\n" + 
				"XX    X XXX   X\n" + 
				"X XXXX  XWX   X\n" + 
				"X      XX X   X\n" + 
				"X  X XXX     XX\n" + 
				"X  X        X X\n" + 
				"X  X XAX   X  X\n" + 
				"X  X XXX  X   X\n" + 
				"X  X     X    X\n" + 
				"X  X    X     X\n" + 
				"X  XX  X  XXXXX\n" + 
				"X  QX     X   X\n" + 
				"X  XX XXX X X X\n" + 
				"X  X   ZX   X X\n" + 
				"XXXXXXXXXXXXXEX\n";
		
		m.moveSouth();
		maze = m.toString();
		assertEquals("Expecting to match", expected, maze);
		

		expected = "XSXXXXXXXXXXXXX\n" + 
				"X P X         X\n" + 
				"XX    X XXX   X\n" + 
				"X XXXX  XWX   X\n" + 
				"X      XX X   X\n" + 
				"X  X XXX     XX\n" + 
				"X  X        X X\n" + 
				"X  X XAX   X  X\n" + 
				"X  X XXX  X   X\n" + 
				"X  X     X    X\n" + 
				"X  X    X     X\n" + 
				"X  XX  X  XXXXX\n" + 
				"X  QX     X   X\n" + 
				"X  XX XXX X X X\n" + 
				"X  X   ZX   X X\n" + 
				"XXXXXXXXXXXXXEX\n";
		
		m.moveEast();
		maze = m.toString();
		assertEquals("Expecting to match", expected, maze);
		

		expected = "XSXXXXXXXXXXXXX\n" + 
				"XP  X         X\n" + 
				"XX    X XXX   X\n" + 
				"X XXXX  XWX   X\n" + 
				"X      XX X   X\n" + 
				"X  X XXX     XX\n" + 
				"X  X        X X\n" + 
				"X  X XAX   X  X\n" + 
				"X  X XXX  X   X\n" + 
				"X  X     X    X\n" + 
				"X  X    X     X\n" + 
				"X  XX  X  XXXXX\n" + 
				"X  QX     X   X\n" + 
				"X  XX XXX X X X\n" + 
				"X  X   ZX   X X\n" + 
				"XXXXXXXXXXXXXEX\n";
		
		m.moveWest();
		maze = m.toString();
		assertEquals("Expecting to match", expected, maze);
		

		expected = "XPXXXXXXXXXXXXX\n" + 
				"X   X         X\n" + 
				"XX    X XXX   X\n" + 
				"X XXXX  XWX   X\n" + 
				"X      XX X   X\n" + 
				"X  X XXX     XX\n" + 
				"X  X        X X\n" + 
				"X  X XAX   X  X\n" + 
				"X  X XXX  X   X\n" + 
				"X  X     X    X\n" + 
				"X  X    X     X\n" + 
				"X  XX  X  XXXXX\n" + 
				"X  QX     X   X\n" + 
				"X  XX XXX X X X\n" + 
				"X  X   ZX   X X\n" + 
				"XXXXXXXXXXXXXEX\n";
		
		m.moveNorth();
		maze = m.toString();
		assertEquals("Expecting to match", expected, maze);
	}
	

	@Test
	public void testMove()
	{
		PlayerLocation expected = new PlayerLocation();
		expected.row = 1;
		expected.col = 1;
		Maze m = new Maze();
		PlayerLocation actual = m.moveSouth();
		assertEquals("Expecting to match", expected, actual);
		
		expected.row = 1;
		expected.col = 2;
		actual = m.moveEast();
		assertEquals("Expecting to match", expected, actual);
		
		expected.row = 1;
		expected.col = 1;
		actual = m.moveWest();
		assertEquals("Expecting to match", expected, actual);
		
		expected.row = 0;
		expected.col = 1;
		actual = m.moveNorth();
		assertEquals("Expecting to match", expected, actual);
	}
	

	@Test
	public void testCanMove()
	{
		PlayerLocation expected = new PlayerLocation();
		expected.row = 1;
		expected.col = 1;
		Maze m = new Maze();
		assertFalse(m.canMoveNorth());
		assertTrue(m.canMoveSouth());
		assertFalse(m.canMoveEast());
		assertFalse(m.canMoveWest());
		
		m.moveSouth(); // 1,1
		assertTrue(m.canMoveNorth());
		assertFalse(m.canMoveSouth());
		assertTrue(m.canMoveEast());
		assertFalse(m.canMoveWest());
		
		expected.row = 1;
		expected.col = 2;
		m.moveEast(); // 1,2
		assertFalse(m.canMoveNorth());
		assertTrue(m.canMoveSouth());
		assertTrue(m.canMoveEast());
		assertTrue(m.canMoveWest());
	}

}
