package screens;

import java.awt.Color;

public class BeginningScreen extends Screen
{
	public static final int FONT_SIZE = 20;
	public static final int MAX_NAME_LENGTH = 20;
	
	public static final String DEFAULT_NAME = "Player";
	
	public static final Color BUTTON_COLOR = new Color(0, 153, 0);
	

	public BeginningScreen(String name) 
	{
		super(name);
		
	}
	

}
