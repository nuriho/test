package program;

public interface IMaze
{
	PlayerLocation playerLocation();
	PlayerLocation moveNorth();
	PlayerLocation moveSouth();
	PlayerLocation moveEast();
	PlayerLocation moveWest();
	boolean canMoveNorth();
	boolean canMoveSouth();
	boolean canMoveEast();
	boolean canMoveWest();
	boolean isSolved();
}
