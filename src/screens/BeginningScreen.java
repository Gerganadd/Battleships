package screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.Game;

public class BeginningScreen extends Screen
{
	public static final int FONT_SIZE = 20;
	public static final int MAX_NAME_LENGTH = 20;
	
	public static final int LABEL_X = 110;
	public static final int LABEL_Y = 20;
	public static final int LABEL_WIDTH = 80;
	public static final int LABEL_HEIGHT = 20;
	
	public static final String DEFAULT_NAME = "Player";
	
	public static final Color BUTTON_COLOR = new Color(0, 153, 0);
	
	private static JTextField txtPlayerName = new JTextField();
	
	private String info;
	
	public BeginningScreen(String name) 
	{
		super(name);	
	}
	
	public void setTxtPlayerName(String name)
	{
		if(name.chars().count() > MAX_NAME_LENGTH)
		{
			throw new IllegalArgumentException("Character limit exceeded. Enter a new name");
		}
		else
		{
			this.info = name;
		}
	}
	
	public static JPanel panel()
	{
		JPanel window = new JPanel();
		window.setBounds(0, 0, 300, 300);
		window.setLayout(null);
		
		JLabel lblBattleShips = new JLabel("BattleShips");
		lblBattleShips.setBounds(LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
		window.add(lblBattleShips);
		
		JLabel lblPlayerName = new JLabel("Player Name: ");
		lblPlayerName.setBounds(LABEL_X - 50, LABEL_Y + LABEL_HEIGHT + 50, LABEL_WIDTH, LABEL_HEIGHT);
		window.add(lblPlayerName);
		
		
		txtPlayerName.setBounds(LABEL_X - 50, LABEL_Y + LABEL_HEIGHT*2 + 50 + 10, LABEL_WIDTH + 80, LABEL_HEIGHT + 10);
		String name = txtPlayerName.getText();
		
		window.add(txtPlayerName);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(LABEL_X - 10, LABEL_Y + LABEL_HEIGHT*3 + 50 + 50, LABEL_WIDTH, LABEL_HEIGHT + 10);
		btnStart.setBackground(BUTTON_COLOR);
		btnStart.setVisible(true);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				//Game.getInstance();
				System.out.println(Game.getInstance().getPlayer().getName());
			}
			
		});
		window.add(btnStart);
		
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
