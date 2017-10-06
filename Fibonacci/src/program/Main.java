package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

	public static void main(String[] args)
	{
		Maze m = new Maze();
		m.printMaze();
		
		String message = "Enter a number";
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
		System.out.println("you entered: "+ line);
		line = System.console().readLine(message);
		System.out.println("you entered: "+ line);
	}

}
