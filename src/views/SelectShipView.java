package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import basic_classes.Ship;

public class SelectShipView extends JPanel
{
	
	private LinkedList<ShipView> selectShipView;
	private ShipView lastSelectedShip;
	private int counter; //counts how many ships there are
	
	public SelectShipView()
	{
		selectShipView = new LinkedList<>();
		generateShips();
		counter = 0;
	}
	
	public ShipView getLastSelectedShip()
	{
		return this.lastSelectedShip;
	}
	public void setLastSelectedShip(ShipView s)
	{
		this.lastSelectedShip = s;
	}
	
	public LinkedList<ShipView> getSelectShipView()
	{
		return this.selectShipView;
	}
	
	public int getCounter()
	{
		return counter;
	}
	
	public void setCounter()
	{
		counter = getCounter() + 1;
	}
	
	private void generateShips()
	{
		selectShipView.add(new ShipView(new Ship(5, true)));
		selectShipView.add(new ShipView(new Ship(4, true)));
		selectShipView.add(new ShipView(new Ship(3, true)));
		selectShipView.add(new ShipView(new Ship(3, true)));
		selectShipView.add(new ShipView(new Ship(3, true)));
		selectShipView.add(new ShipView(new Ship(2, true)));
		selectShipView.add(new ShipView(new Ship(2, true)));
		selectShipView.add(new ShipView(new Ship(2, true)));
	}
	
	public void paintComponent(Graphics graphics)
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPnlSize();
		
		JPanel space = new JPanel();
		space.setSize(20, 30);
		space.setVisible(true);
		
		
		for(ShipView s : selectShipView)
		{
			this.add(space);
			this.add(s);
			this.add(space);
		}
	}
	
	private void setPnlSize()
	{
		int WIDTH = 200;
		int HEIGHT = 300;
		
		this.setSize(WIDTH, HEIGHT);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
						
	}
}
