package screens;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class Screen extends JPanel
{
	public static final int SCREEN_WIDTH = 500;
	public static final int SCREEN_HEIGHT = 500;
	public static final Color BACKGROUND = new Color(255, 255, 204);
	
	private String name;
	
	public Screen(String name)
	{
		this.name = name;
		this.setBackground(BACKGROUND);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	

}
