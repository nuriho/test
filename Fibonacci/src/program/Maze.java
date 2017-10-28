package program;

import java.awt.Point;

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
	 * loc.x = col loc.y = row
	 */
	private Point loc;

	public Maze()
	{
		playerLocation();
	}

	@Override
	public Point playerLocation()
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

			loc = new Point(x, y);
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

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < maze.length; row++)
		{
			for (int column = 0; column < maze[row].length; column++)
			{
				if (loc.y == row && loc.x == column)
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
	public Point moveNorth()
	{
		loc.y = loc.y - 1;
		return loc;
	}

	@Override
	public Point moveSouth()
	{
		loc.y = loc.y + 1;
		return loc;
	}

	@Override
	public Point moveEast()
	{
		loc.x = loc.x + 1;
		return loc;
	}

	@Override
	public Point moveWest()
	{
		loc.x = loc.x - 1;
		return loc;
	}

	@Override
	public boolean canMoveNorth()
	{
		if (loc.y == 0)
			return false;
		return maze[loc.x][loc.y - 1] == Features.Wall ? false : true;
	}

	@Override
	public boolean canMoveSouth()
	{
		if (loc.y == 16)
			return false;
		return maze[loc.x][loc.y + 1] == Features.Wall ? false : true;
	}

	@Override
	public boolean canMoveEast()
	{
		if (loc.x == 15)
			return false;
		return maze[loc.x + 1][loc.y] == Features.Wall ? false : true;
	}

	@Override
	public boolean canMoveWest()
	{
		if (loc.x == 0)
			return false;
		return maze[loc.x - 1][loc.y] == Features.Wall ? false : true;
	}
}
