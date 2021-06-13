package test;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;
import players.Player;
import views.GameView;
import views.PlayerView;
import views.RobotView;
import views.SelectShipView;

public class TestPlayerView {

	public static void main(String[] args) 
	{
		JFrame f = new JFrame();
		f.setBounds(10, 10, 800, 800);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
		
		Game g = new Game();
		GameView gv = new GameView(g);
		
		f.add(gv);
		
		f.setLocationRelativeTo(null);
		f.pack();
		f.repaint();

	}

}
