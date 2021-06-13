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

public class Player extends BasePlayer
{
	
	public Player(String name)
	{
		super(name);
		super.playerBoard = new Board();
		
	}
	
	public void attack(int x, int y, Board enemyBoard)
	{
		Cell temp = enemyBoard.getPlayerBoard()[x][y];
		if(temp.isSelected() == true) //unsuccessful attack - cell has been selected before
		{
			return;
		}
		else if(temp.hasShip() == true) //successful attack - points + 1, mark cell(s) as selected
		{
			this.setPoints(this.getPoints() + 1);
			if(temp.getShip().getLength() > 1)
			{
				if(temp.getShip().isHorizontal())
				{
					for(int i = temp.getX(), j = 0; j < temp.getShip().getLength(); i++, j++)
					{
						enemyBoard.getPlayerBoard()[i][y].setIsSelected(true);
					}
				}
				else
				{
					for(int i = temp.getY(), j = 0; j < temp.getShip().getLength(); i++, j++)
					{
						enemyBoard.getPlayerBoard()[x][i].setIsSelected(true);
					}
				}

			}
			else
			{
				enemyBoard.getPlayerBoard()[x][y].setIsSelected(true);
			}
		}
		else //unsuccessful attack - no ship in selected cell. Mark cell as selected
		{
			enemyBoard.getPlayerBoard()[x][y].setIsSelected(true);
		}
	}


	@Override
	public void attack() 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	//requires new makePlayerBoard that uses the mouse listener on Cell View
	//alternatively - make a new makePlayerBoard that calls the makePlayerBoard of the second
	//screen (the one that lets the player choose their ships)

	@Override
	public Board makeBoard() 
	{
		super.playerBoard = new Board();
		return super.playerBoard;
		/*File file = new File(".\\resources\\PlayerShipsPosition.txt"); 
		Path filePath = file.toPath();
		Board board = new Board();		
		try 
		{
			List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
			lines.remove(0);
			lines.remove(6);
			for(String line : lines)
			{
				String[] args = line.split(" ");
				int length = Integer.parseInt(args[0]);
				int x = Integer.parseInt(args[1]);
				int y = Integer.parseInt(args[2]);
				boolean isHorizontal = Integer.parseInt(args[3]) == 1 ? true : false;
				Ship temp = new Ship(length, isHorizontal);
				board.addShip(x, y, temp);
				board.getPlayerBoard()[x][y].setHasShip(true);
				// was supposed to add the ships along the grid but isn't working
				if(isHorizontal == true)
				{
					for(int i = x, j = 0; j < length; i++, j++)
					{
						board.addShip(i, y, temp);
						board.getPlayerBoard()[i][y].setHasShip(true);
					}
				}
				else
				{
					for(int i = y, j = 0; j < length; i++, j++)
					{
						board.addShip(x, i, temp);
						board.getPlayerBoard()[x][i].setHasShip(true);
					}
				}
				if(isHorizontal)
				{
					if(Board.SIZE - x > length)
					{
						board.addShip(x, y, temp);
					}
				}
				else
				{
					if(Board.SIZE - y > length)
					{
						board.addShip(x, y, temp);
					}
				}
				
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Problem with reading file in makePlayerBoard in Player.");
			e.printStackTrace();
		}
		
		return board;
		*/
	}
	
}
