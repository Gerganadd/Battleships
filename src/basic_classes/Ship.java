package basic_classes;

public class Ship
{
	private int length;
	private boolean isSunk;
	
	public Ship(int length, boolean isSunk)
	{
		setLength(length);
		isSunk = false;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public boolean isSunk()
	{
		return this.isSunk;
	}
	
	public void setLength(int length)
	{
		if(length >= 1 && length <= 5)
		{
			this.length  = length;
		}
		else
		{
			throw new IllegalArgumentException("Invalid value for length.");
		}
	}
	
}
