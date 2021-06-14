package screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndingScreen extends Screen
{
	public EndingScreen(String name) 
	{
		super(name);
		
	}

	public static final int LABEL_X = 110;
	public static final int LABEL_Y = 20;
	public static final int LABEL_WIDTH = 80;
	public static final int LABEL_HEIGHT = 20;
	
	public static final Color BUTTON_COLOR = new Color(0, 153, 0);
	
	public static JPanel panel()
	{
		JPanel window = new JPanel();
		window.setBounds(0, 0, 300, 300);
		window.setLayout(null);
		
		JLabel lblBattleShips = new JLabel("BattleShips");
		lblBattleShips.setBounds(LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
		window.add(lblBattleShips);
		
		JLabel lblWinner = new JLabel("Winner: ");
		lblWinner.setBounds(LABEL_X - 50, LABEL_Y + LABEL_HEIGHT + 50, LABEL_WIDTH, LABEL_HEIGHT);
		window.add(lblWinner);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(LABEL_X - 10, LABEL_Y + LABEL_HEIGHT*3 + 50 + 30, LABEL_WIDTH, LABEL_HEIGHT + 10);
		btnNewGame.setBackground(BUTTON_COLOR);
		btnNewGame.setVisible(true);
		window.add(btnNewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(LABEL_X - 10, LABEL_Y + LABEL_HEIGHT*4 + 50 + 50, LABEL_WIDTH, LABEL_HEIGHT + 10);
		btnExit.setBackground(BUTTON_COLOR);
		btnExit.setVisible(true);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
			
		});
		window.add(btnExit);
		
		
		return window;
	}
	
	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 200, 300, 300);
		window.setBackground(BACKGROUND);
		window.setLayout(null);
		window.add(panel());
		
		window.setVisible(true);
		window.repaint();
	}

}
