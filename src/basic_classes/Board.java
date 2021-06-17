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
				playerBoard[i][j] = new Cell(i, j, false);
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
		/*if(!isPossibleToAddAnotherShip())
		{
			return;
		}*/
		for(int i = 0; i < lenght; i++)
		{
			if(ship.isHorizontal())
			{
				
				playerBoard[x][y + i].setHasShip(true); // for horizontal!!!
				//playerBoard[x + i][y].setHasShip(true);
				
			}
			else
			{
				playerBoard[x + i][y].setHasShip(true);
				//playerBoard[x][y + i].setHasShip(true);
				
			}
			
		}
		System.out.println("add ship print");
		printBoard();
		
	}
	
	public void printBoard()
	{
		for(int i = 0; i < SIZE; i++)
		{
			for(int k = 0; k < SIZE; k++)
			{
				char symbol = this.playerBoard[i][k].hasShip() ? 'X' : 'o';
				System.out.print(symbol + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	/*private boolean isPossibleToAddAnotherShip()
	{
		for(int i = 0; i < SIZE; i++)
		{
			for(int k = 0; k < SIZE; k++)
			{
				if(this.playerBoard[i++][k++].hasShip())
				{
					return false;
				}
			}
		}
		return true;
	}*/
}
