package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

	public static void main(String[] args)
	{
		Maze m = new Maze();
		System.out.println(m.toString());

		while (m.isSolved() == false)
		{
			String message = "Enter an action:";
			System.out.println(message);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			try
			{
				line = bufferedReader.readLine();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
			if(line.equalsIgnoreCase("exit"))
			{
				System.out.println("Exiting");
				break;
			}
			else if(line.equalsIgnoreCase("help"))
			{
				System.out.println("Valid commands are:");
				System.out.println(m.validCommands());
			}
			else if(line.equalsIgnoreCase(Maze.moveNorthCommand)
					&& m.canMoveNorth())
			{
				m.moveNorth();
			}
			else if(line.equalsIgnoreCase(Maze.moveSouthCommand)
					&& m.canMoveSouth())
			{
				m.moveSouth();
			}
			else if(line.equalsIgnoreCase(Maze.moveEastCommand)
					&& m.canMoveEast())
			{
				m.moveEast();
			}
			else if(line.equalsIgnoreCase(Maze.moveWestCommand)
					&& m.canMoveWest())
			{
				m.moveWest();
			}
			else
			{
				System.out.println("Invalid command!  Type 'Help' for help");
			}
			
			if(m.isSolved())
			{
				System.out.println("Congratulations!");
			}
			else
			{
				Maze.clearConsole();
				System.out.println(m.toString());
			}
		}
	}

}
