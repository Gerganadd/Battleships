package game;

import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import players.Player;
import players.Robot;
import views.GameView;

public class Game 
{
	public static Game gameInstance = null;
	public static GameView gameView = null;
	public final static int MAX_POINTS = 24;
	
	private Player player;
	private Robot bot;
	private boolean isAllShipsAdded;
	
	
	public Game()
	{
		this.player = new Player("player1");
		this.bot = new Robot("bot");
		this.isAllShipsAdded = false;
		
		
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
	public boolean isAllShipsAdded()
	{
		return this.isAllShipsAdded;
	}
	public void setAllShipsAdded(boolean value)
	{
		this.isAllShipsAdded = value;
	}
	
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		f.setBounds(10, 10, 900, 800);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
		
		Game g = new Game();
		g.gameView = new GameView(g);
		
		f.add(g.gameView);
		
		f.setLocationRelativeTo(null);
		f.pack();
		f.repaint();
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
