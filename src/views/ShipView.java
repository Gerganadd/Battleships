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
	
	private void setShipSize()
	{
		if(this.getShip().isHorizontal())
		{
			this.setSize(Cell.WIDTH * this.ship.getLength(), Cell.HEIGHT);
			this.setPreferredSize(new Dimension(Cell.WIDTH * this.ship.getLength(), Cell.HEIGHT));
			this.setMaximumSize(new Dimension(Cell.WIDTH * this.ship.getLength(), Cell.HEIGHT));
			this.setMinimumSize(new Dimension(Cell.WIDTH * this.ship.getLength(), Cell.HEIGHT));
		}
		else
		{
			this.setSize(Cell.WIDTH, Cell.HEIGHT * this.getShip().getLength());
			this.setPreferredSize(new Dimension(Cell.WIDTH, Cell.HEIGHT * this.getShip().getLength()));
			this.setMaximumSize(new Dimension(Cell.WIDTH, Cell.HEIGHT * this.getShip().getLength()));
			this.setMinimumSize(new Dimension(Cell.WIDTH, Cell.HEIGHT * this.getShip().getLength()));
		}
	}
	
	public void paintComponent(Graphics graphics)
	{
		Graphics2D g = (Graphics2D) graphics;
		super.paintComponent(g);
	}
	
	public void setShipColour()
	{
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		this.setBackground(new Color(0, 0, 0)); //base colour in CellView
	}
	
	public Ship getShip()
	{
		return this.ship;
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		ShipView.getLastSelectedShip().setLastSelectedShip(this);
		
	
		
		this.setVisible(false);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setBackground(Color.green);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.black);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setBackground(Color.black);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
