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
import game.Game;

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
				/*when clicked, it does one of two things
				 *first, if the ships added are less than ten it goes into "add ship" mode
				 *otherwise it attacks the player ship 
				initiates a player attack on said cell
				and possibly a robot attack as well, so they happen one after the other
				 * */
				
				if(ShipView.getLastSelectedShip().getCounter() < 10) //this checks whether enough
					//ships were added. If not, more ships get added
				{
					SelectShipView s = ShipView.getLastSelectedShip();
					Ship ship = s.getSelectShipView().get(s.getSelectShipView().size() - 1).getShip();
					Game.getInstance().getPlayer().getBoard().addShip(this.cell.getX(), this.cell.getY(), ship);
					ShipView.getLastSelectedShip().setCounter(); //automatically increases value of
					//counter by 1
				}
				else //when all ships have been added and it's attack time
				{
					int x = cell.getX();
					int y = cell.getY();
					Game.getInstance().getPlayer().attack(x, y, Game.getInstance().getBot().getBoard());
					//basically - a cell is clicked, it initiates a player attack on said cell
					this.repaint(); //colours the cell based on the result of the attack
					Game.getInstance().getBot().attack(Game.getInstance().getPlayer().getBoard());
					this.repaint(); //hopefully colours the cell attacked by the robot, but I doubt it
				}
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
