package program;

public class Maze implements IMaze
{
	private static final Features[][] maze =
	{
			// row 1
			{ Features.Wall, Features.Start, Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall,
					Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall,
					Features.Wall, Features.Wall },
			// row 2
			{ Features.Wall, Features.Path, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path,
					Features.Path, Features.Path, Features.Path, Features.Path, Features.Path, Features.Path,
					Features.Path, Features.Wall },
			// row 3
			{ Features.Wall, Features.Wall, Features.Path, Features.Path, Features.Path, Features.Path, Features.Wall,
					Features.Path, Features.Wall, Features.Wall, Features.Wall, Features.Path, Features.Path,
					Features.Path, Features.Wall },
			// row 4
			{ Features.Wall, Features.Path, Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Path,
					Features.Path, Features.Wall, Features.Water, Features.Wall, Features.Path, Features.Path,
					Features.Path, Features.Wall },
			// row 5
			{ Features.Wall, Features.Path, Features.Path, Features.Path, Features.Path, Features.Path, Features.Path,
					Features.Wall, Features.Wall, Features.Path, Features.Wall, Features.Path, Features.Path,
					Features.Path, Features.Wall },
			// row 6
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Wall, Features.Wall,
					Features.Wall, Features.Path, Features.Path, Features.Path, Features.Path, Features.Path,
					Features.Wall, Features.Wall },
			// row 7
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path, Features.Path,
					Features.Path, Features.Path, Features.Path, Features.Path, Features.Path, Features.Wall,
					Features.Path, Features.Wall },
			// row 8
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Wall, Features.Fire,
					Features.Wall, Features.Path, Features.Path, Features.Path, Features.Wall, Features.Path,
					Features.Path, Features.Wall },
			// row 9
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Wall, Features.Wall,
					Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path,
					Features.Path, Features.Wall },
			// row 10
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path, Features.Path,
					Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path, Features.Path,
					Features.Path, Features.Wall },
			// row 11
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path, Features.Path,
					Features.Path, Features.Wall, Features.Path, Features.Path, Features.Path, Features.Path,
					Features.Path, Features.Wall },
			// row 12
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Wall, Features.Path, Features.Path,
					Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Wall, Features.Wall,
					Features.Wall, Features.Wall },
			// row 13
			{ Features.Wall, Features.Path, Features.Path, Features.Earth, Features.Wall, Features.Path, Features.Path,
					Features.Path, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path,
					Features.Path, Features.Wall },
			// row 14
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Wall, Features.Path, Features.Wall,
					Features.Wall, Features.Wall, Features.Path, Features.Wall, Features.Path, Features.Wall,
					Features.Path, Features.Wall },
			// row 15
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path, Features.Path,
					Features.Wind, Features.Wall, Features.Path, Features.Path, Features.Path, Features.Wall,
					Features.Path, Features.Wall },
			// row 16
			{ Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall,
					Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall,
					Features.End, Features.Wall }, };

	private enum Features
	{
		Wall, Start, End, Earth, Fire, Wind, Water, Path
	}

	/**
	 * loc.x = col == (-)west/(+)east, loc.y = row == (-)north/(+)south
	 */
	private PlayerLocation loc;
	private boolean isMazeSolved;
	public static final String moveNorthCommand = "North";
	public static final String moveSouthCommand = "South";
	public static final String moveEastCommand = "East";
	public static final String moveWestCommand = "West";

	public Maze()
	{
		playerLocation();
		isMazeSolved = false;
	}

	@Override
	public PlayerLocation playerLocation()
	{
		if (loc == null)
		{
			// find starting point
			int x = 0;
			int y = 0;
			boolean found = false;

			for (int row = 0; row < maze.length; row++)
			{
				for (int column = 0; column < maze[row].length; column++)
				{
					if (maze[row][column] == Features.Start)
					{
						x = column;
						y = row;
						found = true;
						break;
					}
				}
				if (found)
					break;
			}

			loc = new PlayerLocation();
			loc.row = y;
			loc.col = x;
		}

		return loc;
	}

	public void printMaze()
	{
		for (int row = 0; row < maze.length; row++)
		{
			for (int column = 0; column < maze[row].length; column++)
			{
				System.out.print(printRowCol(maze[row][column]));
			}
			System.out.println();
		}
	}
	
	public static void clearConsole()
	{
		// Just adding lines for separation
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < maze.length; row++)
		{
			for (int column = 0; column < maze[row].length; column++)
			{
				if (loc.row == row && loc.col == column)
				{
					sb.append("P");
				} else
				{
					sb.append(printRowCol(maze[row][column]));
				}
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	private String printRowCol(Features value)
	{
		switch (value)
		{
		case Wall:
			return "X";
		case Path:
			return " ";
		case Earth:
			return "Q";
		case Fire:
			return "A";
		case Wind:
			return "Z";
		case Start:
			return "S";
		case End:
			return "E";
		case Water:
			return "W";
		default:
			return "";
		}
	}

	@Override
	public PlayerLocation moveNorth()
	{
		loc.row = loc.row - 1;
		isMazeSolved = isPlayerLocationAtEnd();
		return loc;
	}

	@Override
	public PlayerLocation moveSouth()
	{
		loc.row = loc.row + 1;
		isMazeSolved = isPlayerLocationAtEnd();
		return loc;
	}

	@Override
	public PlayerLocation moveEast()
	{
		loc.col = loc.col + 1;
		isMazeSolved = isPlayerLocationAtEnd();
		return loc;
	}

	@Override
	public PlayerLocation moveWest()
	{
		loc.col = loc.col - 1;
		isMazeSolved = isPlayerLocationAtEnd();
		return loc;
	}

	@Override
	public boolean canMoveNorth()
	{
		if (loc.row == 0)
			return false;
		
		if(maze[loc.row - 1][loc.col] == Features.Wall)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean canMoveSouth()
	{
		if (loc.row == 16)
			return false;
		
		if(maze[loc.row + 1][loc.col] == Features.Wall)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean canMoveEast()
	{
		if (loc.col == 15)
			return false;
		
		if(maze[loc.row][loc.col + 1] == Features.Wall)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean canMoveWest()
	{
		if (loc.col == 0)
			return false;
		
		if(maze[loc.row][loc.col -1] == Features.Wall)
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean isSolved()
	{
		return isMazeSolved;
	}
	
	private boolean isPlayerLocationAtEnd()
	{
		return maze[loc.row][loc.col] == Features.End;
	}
	
	public String validCommands()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Exit" + System.lineSeparator());
		sb.append("Help" + System.lineSeparator());
		
		if(canMoveNorth()) { sb.append(moveNorthCommand + System.lineSeparator()); }
		if(canMoveSouth()) { sb.append(moveSouthCommand + System.lineSeparator()); }
		if(canMoveEast()) { sb.append(moveEastCommand + System.lineSeparator()); }
		if(canMoveWest()) { sb.append(moveWestCommand + System.lineSeparator()); }
		
		return sb.toString();
	}
}
