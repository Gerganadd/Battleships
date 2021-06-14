package players;

import java.util.Random;

import basic_classes.Board;
import basic_classes.Cell;
import basic_classes.Ship;
import views.ShipView;

public class Robot extends BasePlayer
{
	public Robot(String name)
	{
		super(name);
		//super.playerBoard = new Board();
		
	}
	public Board makeBoard()
	{
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
	
}
