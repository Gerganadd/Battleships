package basic_classes;

public class Cell 
{
	public final int SIZE = 10;//wasn't sure how big to make it, so this is just a temporary 
	//number
	private int x;
	private int y;
	private boolean hasAShip;
	private boolean hasBeenChosen;
	
	public Cell()
	{
		this(0, 0, false, false);
	}
	
	public Cell(int x, int y, boolean hasAShip, boolean hasBeenChosen)
	{
		this.setX(x);
		this.setY(y);
		this.setHasAShip(hasAShip);
		this.setHasBeenChosen(hasBeenChosen);
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public boolean hasAShip()
	{
		return this.hasAShip;
	}
	
	public boolean hasBeenChosen()
	{
		return this.hasBeenChosen;
	}
	
	//not sure if we need setters, but I'll add them just in case
	//I'll keep them public for now but we can make them private if needed be
	
	public void setX(int x)
	{
		//I assume 10 x 10 is the board size
		//I suggest we make an enum list of constants like this
		if(x > 0 && x < 10)
		{
			this.x = x;
		}
		else
		{
			throw new IllegalArgumentException("Invalid value for x of cell entered.");
		}
	}
	
	public void setY(int y)
	{
		//I assume 10 x 10 is the board size
		//I suggest we make an enum list of constants like this
		if(y > 0 && y < 10)
		{
			this.y = y;
		}
		else
		{
			throw new IllegalArgumentException("Invalid value for y of cell entered.");
		}
	}
	
	public void setHasAShip(boolean hasAShip)
	{
		this.hasAShip = hasAShip;
	}
	
	public void setHasBeenChosen(boolean hasBeenChosen)
	{
		this.hasBeenChosen = hasBeenChosen;
	}
	
}

