package basic_classes;

public class Ship
{
	private int length;
	private boolean isSunk;
	private boolean isHorizontal;
	public boolean hasBeenSelected;
	
	public Ship(int length)
	{
		setLength(length);
		this.isSunk = false;
		this.isHorizontal = true;
		this.hasBeenSelected = false;
	}
	
	public Ship(int length, boolean isHorizontal)
	{
		this(length);
		this.isHorizontal = isHorizontal;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public boolean isSunk()
	{
		return this.isSunk;
	}
	
	public boolean isHorizontal()
	{
		return this.isHorizontal;
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
	
	public void setSunk(boolean isSunk)
	{
		this.isSunk = isSunk;
	}
	
}
