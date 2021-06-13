package views;

import java.util.LinkedList;

import javax.swing.JPanel;

public class SelectShipView extends JPanel
{
	private LinkedList<ShipView> selectShipView;
	
	public SelectShipView()
	{
		selectShipView = new LinkedList<>();
	}
	
	public LinkedList<ShipView> getSelectShipView()
	{
		return this.selectShipView;
	}
}
