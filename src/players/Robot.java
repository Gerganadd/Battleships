package players;

import java.util.Random;

import basic_classes.Board;
import basic_classes.Cell;
import basic_classes.Ship;

public class Robot extends BasePlayer
{
	//String name;
	//Board playerBoard;
	//int points;
	
	public Robot(String name)
	{
		super(name);
		super.playerBoard = new Board();
		
	}
	/*
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
	*/
	
	/*
	public int getPoints() 
	{
		return this.points;
	}
	
	public Board getBoard()
	{
		return this.playerBoard;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void attack(Board enemyBoard) 
	{
		
	}
	*/
	public Board makeBoard()
	{
		super.playerBoard = new Board();
		return super.playerBoard;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
