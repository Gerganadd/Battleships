package players;

import java.util.Random;

import basic_classes.Board;
import basic_classes.Cell;
import basic_classes.Ship;

public class Robot 
{
	String name;
	Board playerBoard;
	int points;
	
	public Robot(String name, Board playerBoard)
	{
		this.name = name;
		this.playerBoard = playerBoard;
		this.points = 0;
	}
	
	public Robot(String name)
	{
		this.name = name;
		this.playerBoard = makeBoard();
		this.points = 0;
	}
	
	public int getPoints() 
	{
		return this.points;
	}
	
	public Board getBoard()
	{
		return this.playerBoard;
	}
	
	public void attack(Board enemyBoard) 
	{
		
	}
	
	public Board makeBoard()
	{
		return null;
	}
}
