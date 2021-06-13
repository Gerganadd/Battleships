package game;

import java.util.Random;

import players.Player;
import players.Robot;

public class Game 
{
	public static Game gameInstance = null;
	public final static int MAX_POINTS = 24;
	
	private Player player;
	private Robot bot;
	
	public Game()
	{
		this.player = new Player("player1");
		this.bot = new Robot("bot");
		
		play();
	}
	
	public static Game getInstance()
	{
		if(gameInstance == null)
		{
			gameInstance = new Game();
		}
		return gameInstance;
	}
	
	public Player getPlayer() //need those two for the CellView
	{
		return this.player;
	}
	public Robot getBot()
	{
		return this.bot;
	}
	
	public static void main(String[] args)
	{
		Game newGame = new Game();
	}
	
	private void play()
	{
		/*
		while(player.getPoints() != MAX_POINTS && bot.getPoints() != MAX_POINTS)
		{
			//player turn
			//bot turn
			
			int row = randomGenerateNumber();
			int col = randomGenerateNumber();
			
			//player.attack(row, col, bot.getBoard());
			//bot.attack(player.getBoard());
			System.out.println("player points : " + player.getPoints());
			System.out.println("robot points : " + bot.getPoints());
		}
		*/
	}
	
	private static int randomGenerateNumber()
	{
		Random rand = new Random();
		
		return rand.nextInt(10); // to do - change it with Board.SIZE
	}
}
