package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import basic_classes.Cell;

import players.BasePlayer;
import players.Player;
import players.Robot;
//import views.BoardView;
import views.CellView;
import views.SelectShipView;

public class TestView // go to GameViewScreen
{
	public static int pnlInformation_WIDTH = 10 * Cell.WIDTH;
	public static int pnlInformation_HEIGHT = Cell.HEIGHT; // may be 30 or 40
	
	public static void main(String[] args) 
	{
		JFrame f = new JFrame();
		f.setBounds(10, 10, 800, 800);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel playerBoard = drawBasePlayerPnl(new Player("Pesho"));
		//JPanel robotBoard = drawBasePlayerPnl(new Robot("Gosho"));
		
		JPanel spacePnl = new JPanel();
		spacePnl.setSize(new Dimension(50,50));
		
		JPanel shipsChoise = new SelectShipView();
		
		f.add(shipsChoise);

		f.add(playerBoard);
		//f.add(spacePnl);
		//f.add(robotBoard);
		
		f.setLocationRelativeTo(null);
		f.pack();
		f.repaint();
		
	}
	
	private static JPanel drawBasePlayerPnl(BasePlayer person)
	{
		JPanel toReturn = new JPanel();
		toReturn.setLayout(new BoxLayout(toReturn, BoxLayout.Y_AXIS));
		
		JPanel personalInformation = drawPnlOfPersonalInformation(person);
		JPanel board = drawBoardOf(person);
		
		toReturn.add(personalInformation);
		toReturn.add(board);
		
		return toReturn;
	}
	

	private static JPanel drawPnlOfPersonalInformation(BasePlayer person)
	{
		JPanel personalInformation = new JPanel();
		
		personalInformation.setSize(pnlInformation_WIDTH, pnlInformation_HEIGHT);
		personalInformation.setPreferredSize(new Dimension(pnlInformation_WIDTH, pnlInformation_HEIGHT));
		
		personalInformation.setLayout(new BoxLayout(personalInformation, BoxLayout.Y_AXIS));
		
		Label name = new Label(person.getName());
		name.setFont(new Font("Serif", Font.PLAIN, 17));
		
		Label points = new Label(String.valueOf(person.getPoints()));
		points.setFont(new Font("Serif", Font.PLAIN, 17));
		
		personalInformation.add(name);
		personalInformation.add(points);
		
		return personalInformation;
	}
	
	private static JPanel drawBoardOf(BasePlayer person)
	{
		Cell[][] tableOfCells = person.getBoard().getPlayerBoard();
		
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
