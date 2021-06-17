package players;

import java.util.Random;

import basic_classes.Board;
import basic_classes.Cell;
import basic_classes.Ship;
import data_structures.LinkedList;
import views.ShipView;

public class Robot extends BasePlayer
{
	public Robot(String name)
	{
		super(name);
		super.playerBoard = makeBoard(); // to create empty board (without ships)
		super.playerBoard = generateBotBoard(); // add ships on bot board
		
		//super.playerBoard  = makeBoard(); // for console version
		
		System.out.println("Robot board");
		playerBoard.printBoard();
	}
	
	public Board makeBoard()
	{
		
		return new Board();
		/*
		super.playerBoard = new Board();
				Random r = new Random();
				int shipsAdded = 0;
				while(shipsAdded < ShipView.MAX_SHIPS)
				{
					Ship temp = generateRandomShip(r);
					int x = r.nextInt(10);
					int y = r.nextInt(10);
					if(x < 0 || x > 9 || y < 0 || y > 9)
						continue;
					if(super.playerBoard.getPlayerBoard()[x][y].hasShip() == true)
						continue;
					else
					{
						//super.playerBoard.addShip(x, y, temp);
						if(temp.isHorizontal() == true)
						{
						
						  if(Board.SIZE - x < temp.getLength()) 
						{
							continue;
						}
						else
						{
							boolean shipsOnWay = false;
							for(int i = x, j = 0; j < temp.getLength(); i++, j++)
							{
								if(super.playerBoard.getPlayerBoard()[i][y].hasShip() == true)
								{
									shipsOnWay = true;
								}
							}
							if(shipsOnWay == true)
							{
								continue;
							}
							else
							{
								shipsAdded++;
								super.playerBoard.addShip(x, y, temp);
								//super.playerBoard.getPlayerBoard()[x][y].setHasShip(true);
							}
						}
					}
					else if(temp.isHorizontal() == false)
					{
						if(Board.SIZE - y < temp.getLength()) //ship won't fit
						{
							continue;
						}
						else
						{
							boolean shipsOnWay = false;
							for(int i = y, j = 0; j < temp.getLength(); i++, j++)
							{
								if(super.playerBoard.getPlayerBoard()[x][i].hasShip() == true)
								{
									shipsOnWay = true;
								}
							}
							if(shipsOnWay == true)
							{
								continue;
							}
							else
							{
								shipsAdded++;
								super.playerBoard.addShip(x, y, temp);
						
								//super.playerBoard.getPlayerBoard()[x][y].setHasShip(true);
							}
						}
						
					}
					
					}
				
			}
				return super.playerBoard;
				*/
	}

	@Override
	public void attack() {
				
	}
	
	
	public void attack(Board enemyBoard) 
	{
		Random r = new Random();
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		Cell temp = enemyBoard.getPlayerBoard()[x][y];
		if(temp.isSelected() == true) 
		{
			return;
		}
		else if(temp.hasShip() == true) 
			//selected
		{
			this.points += 1;
			enemyBoard.getPlayerBoard()[x][y].setIsSelected(true);
		}
		else 
		{
			enemyBoard.getPlayerBoard()[x][y].setIsSelected(true);
		}
	}
	
	private Ship generateRandomShip(Random r)
	{
		
		int length = r.nextInt(5) + 1; //length from 1 to 5
		boolean isHorizontal = r.nextBoolean();
		Ship ship = new Ship(length, isHorizontal);
		return ship;
	}
	
	//only generate horizontal ships
	private Board generateBotBoard()
	{
		Board board = new Board();
		int[] shipsLenght = {2, 2, 2, 3, 3, 3, 4, 5};
		
		Random rand = new Random();
		
		for(int i = 0; i < shipsLenght.length; i++)
		{
			int lenght = shipsLenght[i];
			int randomGenerateX = rand.nextInt(10);
			int randomGenerateY = rand.nextInt(9);
			
			
			while(!isPosibleToAddShip(randomGenerateX, randomGenerateY, lenght))
			{
				randomGenerateX = rand.nextInt(10);
				randomGenerateY = rand.nextInt(9);
				System.out.println("second change");
			}
			
			//System.out.println("X = " + randomGenerateX + " Y = " + randomGenerateY + " L = " + lenght);
			board.addShip(randomGenerateX, randomGenerateY, new Ship(lenght));
			
		}
		
		return board;
	}
	
	// only for horizontal ships
	private boolean isPosibleToAddShip(int x, int y, int lenghtOfShip) // to do - check if ship is vertical 
	{
		if(y + lenghtOfShip < 10 && !hasOtherShip(x, y, lenghtOfShip)) 
		{
			return true;
		}
		return false;
	}
	
	public boolean hasOtherShip(int x, int y, int searchedArea)// only for horizontal ships
	{
		boolean hasShip = false; 
		int i = y; 
		while(!hasShip)
		{
			if(i == y + searchedArea)
				break;
			
			if(this.playerBoard.getPlayerBoard()[x][i].hasShip())
				hasShip = true;
			
			i++;
		}
		
		return hasShip;
	}
	
	
}
