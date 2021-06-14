package views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import basic_classes.Cell;
import game.Game;
import players.BasePlayer;

public class GameView extends JPanel
{
	public static int pnlInformation_WIDTH = 10 * Cell.WIDTH;
	public static int pnlInformation_HEIGHT = Cell.HEIGHT; // may be 30 or 40
	
	private Game game;
	
	public GameView(Game game)
	{
		this.game = game;
		
		JPanel shipsChoise = new SelectShipView();
		this.add(shipsChoise);
		
		PlayerView p = new PlayerView(Game.getInstance().getPlayer());
		this.add(p);
		
		RobotView r = new RobotView(Game.getInstance().getBot()); 
		this.add(r);
	}

	@Override
	public void paintComponent(Graphics graphics)
	{
		Graphics2D g = (Graphics2D) graphics;
		super.paintComponent(g);
		
	}
	
	public void repaint()
	{
		if(this.getGraphics() != null)
		{
			this.paint(this.getGraphics());
		}
	}
	

}
