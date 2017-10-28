package program;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class MazeTest
{

	@Test
	public void testMaze()
	{
		Point startLoc = new Point(1,0);
		Maze m = new Maze();
		Point playerLoc = m.playerLocation();
				
		assertEquals(startLoc.x, playerLoc.x);
		assertEquals(startLoc.y, playerLoc.y);
		
		assertFalse(m.canMoveNorth());
		assertTrue(m.canMoveSouth());
		
		Point movedLoc = m.moveSouth();
		playerLoc = m.playerLocation();
		
		assertEquals(movedLoc.x, playerLoc.x);
		assertEquals(movedLoc.y, playerLoc.y);

		assertEquals(startLoc.x, playerLoc.x);
		assertEquals(startLoc.y+1, playerLoc.y);
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
	}

}
