package basic_classes;

public class Cell 
{
	public final int SIZE = 10;//wasn't sure how big to make it, so this is just a temporary 
	//number
	private int x;
	private int y;
	private boolean hasShip;
	private boolean isSelected;
	
	public Cell(int x, int y, boolean hasShip)
	{
		this.x = x;
		this.y = y;
		this.hasShip = hasShip;
		this.isSelected = false;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public boolean hasShip()
	{
		return this.hasShip;
	}
	
	public boolean isSelected()
	{
		return this.isSelected;
	}
	
	public void setHasShip(boolean hasShip)
	{
		this.hasShip = hasShip;
	}
	
	public void setIsSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}
	
}

