package players;

import basic_classes.Board;

public abstract class BasePlayer 
{
	private String name;
	protected Board playerBoard;
	private int points;
	
	public BasePlayer(String name)
	{
		this.name = name;
		this.points = 0;
		this.playerBoard = makeBoard();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getPoints()
	{
		return this.points;
	}
	
	public Board getBoard()
	{
		return this.playerBoard;
	}
	
	public void setPoints(int points)
	{
		this.points = points;
	}
	
	public abstract void attack();
	public abstract Board makeBoard();
	
}
