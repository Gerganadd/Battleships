package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import basic_classes.Cell;
import players.Player;

public class PlayerView extends JPanel
{
	public Dimension d = new Dimension(500, 600);
	//public Dimension dInfo = new Dimension(100, 20);
	
	private Player player;
	
	public PlayerView(Player player)
	{
		this.player = player;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(information());
		this.add(board());
		
		setSize();
		this.setBackground(Color.blue);
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
	
	private void setSize()
	{
		this.setSize(d);
		this.setPreferredSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);
	}
	
	private JPanel information()
	{
		JPanel info = new JPanel();

		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		
		Label name = new Label(this.player.getName());
		name.setFont(new Font("Serif", Font.PLAIN, 17));
		
		Label points = new Label(String.valueOf(this.player.getPoints()));
		points.setFont(new Font("Serif", Font.PLAIN, 17));
		
		info.add(name);
		info.add(points);
		
		//setInfoSize();
		
		return info;
	}
	/*
	private void setInfoSize()
	{
		this.setSize(dInfo);
		this.setPreferredSize(dInfo);
		this.setMaximumSize(dInfo);
		this.setMinimumSize(dInfo);
	}
	*/
	
	private JPanel board()
	{
		Cell[][] tableOfCells = this.player.getBoard().getPlayerBoard();
		
		JPanel board = new JPanel();
		board.setLayout(new BoxLayout(board, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < tableOfCells.length; i++)
		{
			JPanel currentPanel = new JPanel();
			currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.X_AXIS));
			
			for(int k = 0; k < tableOfCells[i].length; k++) 
			{
				CellView current = new CellView(tableOfCells[i][k]);
				currentPanel.add(current);
			}
			board.add(currentPanel);
		}
		
		return board;
	}
	
}
