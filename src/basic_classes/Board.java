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
		
	}
	
	public Cell[][] getPlayerBoard()
	{
		return this.playerBoard;
	}
	
	public void addShip(int x, int y, Ship ship) 
	{
		
	}
	
	public void printBoard()
	{
		
	}
}
