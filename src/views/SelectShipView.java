package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.Box;
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
		this.setBackground(Color.blue);
		setPnlSize();
		
		for(ShipView s : selectShipView)
		{
			if (s.isVisible())
			{
				this.add(s);
			}
			else
			{
				continue;
			}
		}
	}
	
	private void setPnlSize()
	{
		Dimension d = new Dimension(300, 400);
		
		this.setSize(d);
		this.setPreferredSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);
						
	}

	public void repaint()
	{
		if(this.getGraphics() != null)
		{
			this.paint(this.getGraphics());
		}
	}

}
