package basic_classes;

public class Board 
{
	public static final int SIZE = 10;
	private Cell[][] playerBoard;
	
	public Board()
	{
		this.playerBoard = new Cell[SIZE][SIZE];
		createBoard();
	}
	
	private void createBoard()
	{
		for(int i = 0; i < playerBoard.length; i++)
		{
			for(int j = 0; j < playerBoard.length; j++)
			{
				playerBoard[i][j].setHasShip(false);
			}
		}
	}
	
	public Cell[][] getPlayerBoard()
	{
		return this.playerBoard;
	}
	
	public void addShip(int x, int y, Ship ship) 
	{
		int lenght  = ship.getLength();
		
		for(int i = 0; i < lenght; i++)
		{
			if(ship.isHorizontal())
			{
				
					playerBoard[x +i][y].setHasShip(true);;
				
			}
			else
			{
				
					playerBoard[x][y+i].setHasShip(true);;
				
			}
			
		}
		
	}
	
	public void printBoard()
	{
		
	}
}
