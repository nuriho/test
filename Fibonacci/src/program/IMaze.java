package program;

import java.awt.Point;

public interface IMaze
{
	Point playerLocation();
	Point moveNorth();
	Point moveSouth();
	Point moveEast();
	Point moveWest();
	boolean canMoveNorth();
	boolean canMoveSouth();
	boolean canMoveEast();
	boolean canMoveWest();
}
