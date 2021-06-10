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
		if(x <= 10 && x >= 0 && y <= 10 && y >= 0 )
		{
			playerBoard[x][y].isSelected();
			
		}
		else 
		{
			throw new IllegalArgumentException("Invalid values for row and column");
			
		}
	}
	
	public void printBoard()
	{
		
	}
}
