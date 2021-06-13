package basic_classes;

public class Cell 
{
	public final int SIZE = 10;//wasn't sure how big to make it, so this is just a temporary 
	//number
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	private int x;
	private int y;
	private boolean hasShip;
	private boolean isSelected;
	private Ship ship; //not sure if we need it, but I felt like each cell needs to hold its
	//own ship
	
	public Cell(int x, int y, boolean hasShip)
	{
		this.x = x;
		this.y = y;
		this.hasShip = hasShip;
		this.isSelected = false;
	}
	
	public Cell(int x, int y, boolean hasShip, Ship ship)
	{
		this.x = x;
		this.y = y;
		this.hasShip = hasShip;
		this.isSelected = false;
		this.ship = ship;
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
	
	public Ship getShip()
	{
		return this.ship;
	}
	
	public void setShip(Ship ship)
	{
		this.ship = ship;
	}
	
	
}

