package program;

public class PlayerLocation
{
	public int row = 0;
	public int col = 0;

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (!PlayerLocation.class.isAssignableFrom(obj.getClass()))
			return false;
		
		final PlayerLocation loc = (PlayerLocation) obj;
		if(this.row != loc.row) return false;
		if(this.col != loc.col) return false;

		return true;
	}
}
