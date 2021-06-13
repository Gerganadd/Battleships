package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import basic_classes.Cell;
import basic_classes.Ship;

public class ShipView extends JPanel implements MouseListener
{
	public static final Color SHIP_COLOR = new Color(0, 0, 0);
	public static final Color SELECTED_SHIP_COLOR = new Color(0, 255, 0);
	
	public static final int MAX_SHIPS = 8;
	
	private Ship ship;
	public static SelectShipView lastSelectedShip = null;
	
	public ShipView(Ship ship)
	{
		this.ship = ship;
		this.addMouseListener(this);
		this.setShipSize();
		this.setShipColour();
	}
	
	public static SelectShipView getLastSelectedShip()
	{
		if(lastSelectedShip == null)
		{
			lastSelectedShip = new SelectShipView();
		}
		
		return lastSelectedShip;
	}
	
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
	
	private void setShipSize()
	{
		if(this.getShip().isHorizontal())
		{
			Dimension d = new Dimension(Cell.WIDTH * this.ship.getLength(), Cell.HEIGHT);
			
			this.setSize(d);
			this.setPreferredSize(d);
			this.setMaximumSize(d);
			this.setMinimumSize(d);
		}
		else
		{
			Dimension d = new Dimension(Cell.WIDTH, Cell.HEIGHT * this.getShip().getLength());
			
			this.setSize(d);
			this.setPreferredSize(d);
			this.setMaximumSize(d);
			this.setMinimumSize(d);
		}
	}
	
	private void setShipColour()
	{
		if (this.isVisible())
		{
			this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			this.setBackground(SHIP_COLOR); 
		}
		else
		{
			this.setBackground(this.lastSelectedShip.getBackground());
		}
		if(this.ship.hasBeenSelected)
		{
			this.setBackground(Color.RED);
		}
	}
	
	public Ship getShip()
	{
		return this.ship;
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		ShipView.getLastSelectedShip().setLastSelectedShip(this);
		this.ship.hasBeenSelected = true;
		//this.setVisible(false);
		this.repaint();
		
		//lastSelectedShip.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		this.setBackground(SELECTED_SHIP_COLOR);
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		setShipColour();
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		setShipColour();
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		this.setBackground(Color.red);
		
	}
	
}
