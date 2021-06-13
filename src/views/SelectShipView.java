package views;

import java.util.LinkedList;

import javax.swing.JPanel;

public class SelectShipView extends JPanel
{
	private LinkedList<ShipView> selectShipView;
	private int counter; //counts how many ships there are
	
	public SelectShipView()
	{
		selectShipView = new LinkedList<>();
		counter = 0;
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
}
