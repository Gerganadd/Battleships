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

public class CellView extends JPanel implements MouseListener
{
	private Color baseColor = new Color(0, 150, 255); // when the cell hasn't been selected
	private Color hasntShipColor = new Color(0, 104, 204); // when the cell was selected, but there haven't a ship
	private Color hasShipColor = new Color(102, 51, 0); // when the cell was selected and there has a ship
	
	private Cell cell;
	
	public CellView(Cell cell)
	{
		this.cell = cell;
		
		this.addMouseListener(this);
		
		setCellSize();
		coloredCell();
		
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
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	private void setCellSize()
	{
		this.setSize(Cell.WIDTH, Cell.HEIGHT);
		this.setPreferredSize(new Dimension(Cell.WIDTH, Cell.HEIGHT));
		this.setMinimumSize(new Dimension(Cell.WIDTH, Cell.HEIGHT));
		this.setMaximumSize(new Dimension(Cell.WIDTH, Cell.HEIGHT));
	}
	
	private void coloredCell()
	{
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		if(cell.isSelected())
		{
			if(cell.hasShip())
			{
				this.setBackground(hasShipColor);
			}
			else 
			{
				this.setBackground(hasntShipColor);
			}
		}
		else
		{
			this.setBackground(baseColor);
		}
	}
	
	// to do:
	//check is it player or is robot
	//

}
