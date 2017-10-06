package program;

public class Maze
{
	private static final Features[][] maze =
	{
			// row 1
			{ Features.Wall, Features.Start, Features.Wall, Features.Wall, Features.Wall,
				Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall,
				Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall },
			// row 2
			{ Features.Wall, Features.Path, Features.Path, Features.Path, Features.Path,
				Features.Wall, Features.Path, Features.Path, Features.Path, Features.Path, 
				Features.Path, Features.Path, Features.Path, Features.Path, Features.Wall },
			// row 3
			{ Features.Wall, Features.Wall, Features.Path, Features.Path, Features.Path,
				Features.Path, Features.Wall, Features.Path, Features.Wall, Features.Wall, 
				Features.Wall, Features.Path, Features.Path, Features.Path, Features.Wall },
			// row 4
			{ Features.Wall, Features.Path, Features.Wall, Features.Wall, Features.Wall,
				Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Water, 
				Features.Wall, Features.Path, Features.Path, Features.Path, Features.Wall },
			// row 5
			{ Features.Wall, Features.Path, Features.Path, Features.Path, Features.Path,
				Features.Path, Features.Path, Features.Wall, Features.Wall, Features.Path, 
				Features.Wall, Features.Path, Features.Path, Features.Path, Features.Wall },
			// row 6
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path,
				Features.Wall, Features.Wall, Features.Wall, Features.Path, Features.Path, 
				Features.Path, Features.Path, Features.Path, Features.Wall, Features.Wall },
			// row 7
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path,
				Features.Path, Features.Path, Features.Path, Features.Path, Features.Path, 
				Features.Path, Features.Path, Features.Wall, Features.Path, Features.Wall },
			// row 8
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path,
				Features.Wall, Features.Fire, Features.Wall, Features.Path, Features.Path, 
				Features.Path, Features.Wall, Features.Path, Features.Path, Features.Wall },
			// row 9
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path,
				Features.Wall, Features.Wall, Features.Wall, Features.Path, Features.Path, 
				Features.Wall, Features.Path, Features.Path, Features.Path, Features.Wall },
			// row 10
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path,
				Features.Path, Features.Path, Features.Path, Features.Path, Features.Wall, 
				Features.Path, Features.Path, Features.Path, Features.Path, Features.Wall },
			// row 11
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path,
				Features.Path, Features.Path, Features.Path, Features.Wall, Features.Path, 
				Features.Path, Features.Path, Features.Path, Features.Path, Features.Wall },
			// row 12
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Wall,
				Features.Path, Features.Path, Features.Wall, Features.Path, Features.Path, 
				Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall },
			// row 13
			{ Features.Wall, Features.Path, Features.Path, Features.Earth, Features.Wall,
				Features.Path, Features.Path, Features.Path, Features.Path, Features.Path, 
				Features.Wall, Features.Path, Features.Path, Features.Path, Features.Wall },
			// row 14
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Wall,
				Features.Path, Features.Wall, Features.Wall, Features.Wall, Features.Path, 
				Features.Wall, Features.Path, Features.Wall, Features.Path, Features.Wall },
			// row 15
			{ Features.Wall, Features.Path, Features.Path, Features.Wall, Features.Path,
				Features.Path, Features.Path, Features.Wind, Features.Wall, Features.Path, 
				Features.Path, Features.Path, Features.Wall, Features.Path, Features.Wall },
			// row 16
			{ Features.Wall, Features.Wall, Features.Wall, Features.Wall, Features.Wall,
				Features.Wall, Features.Wall,Features.Wall, Features.Wall, Features.Wall,
				Features.Wall, Features.Wall, Features.Wall,Features.End, Features.Wall }, };

	private enum Features
	{
		Wall, Start, End, Earth, Fire, Wind, Water, Path
	}

	public Maze()
	{
		// No action
	}

	public void printMaze()
	{
		for (int row = 0; row < maze.length; row++)
		{
			for (int column = 0; column < maze[row].length; column++)
			{
				printRowCol(maze[row][column]);
			}
			System.out.println();
		}
	}

	private void printRowCol(Features value)
	{
		switch (value)
		{
		case Wall:
			System.out.print("X");
			break;
		case Path:
			System.out.print(" ");
			break;
		case Earth:
			System.out.print("Q");
			break;
		case Fire:
			System.out.print("A");
			break;
		case Wind:
			System.out.print("Z");
			break;
		case Start:
			System.out.print("S");
			break;
		case End:
			System.out.print("E");
			break;
		case Water:
			System.out.print("W");
			break;
		default:
			break;
		}
	}
}
