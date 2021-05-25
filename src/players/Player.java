package players;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import basic_classes.Board;
import basic_classes.Cell;
import basic_classes.Ship;

public class Player 
{
	private String name;
	private Board playerBoard;
	private int points;
	
	public Player(String name)
	{
		this.name = name;
		this.points = 0; //starts at 0
		this.playerBoard = this.makePlayerBoard();
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getPoints()
	{
		return this.points;
	}
	
	public Board getPlayerBoard()
	{
		return this.playerBoard;
	}
	
	private void setPoints(int points)
	{
		this.points = points; //private since only the attack function will use it
	}
	
	public void attack(int x, int y, Board enemyBoard)
	{
		Cell temp = enemyBoard.getPlayerBoard()[x][y]; //class hasn't been made yet
		//but I checked the documentation and this should be the field I need
		//I'm gonna need a getter for it
		//or for it to be public
		if(temp.isSelected() == true) //unsuccessful attack - cell has been selected before
		{
			return;
		}
		else if(temp.hasShip() == true) //successful attack - points + 1, mark cell as selected
		{
			this.setPoints(this.getPoints() + 1);
			enemyBoard.getPlayerBoard()[x][y].setIsSelected(true);
		}
		else //unsuccessful attack - no ship in selected cell. Mark cell as selected
		{
			enemyBoard.getPlayerBoard()[x][y].setIsSelected(true);
		}
	}
	
	private Board makePlayerBoard()
	{
		File file = new File(".\\resources\\PlayerShipsPosition.txt"); 
		Path filePath = file.toPath();
		Board board = new Board();		
		try 
		{
			List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
			lines.remove(0);
			for(String line : lines)
			{
				String[] args = line.split(" ");
				int length = Integer.parseInt(args[0]);
				int x = Integer.parseInt(args[1]);
				int y = Integer.parseInt(args[2]);
				boolean isHorizontal = Integer.parseInt(args[3]) == 1 ? true : false;
				Ship temp = new Ship(length, isHorizontal);
				board.addShip(x, y, temp);
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Problem with reading file in makePlayerBoard in Player.");
			e.printStackTrace();
		}
		
		return board;
	}
	
}
