package test;

import java.util.Random;

import basic_classes.Board;
import basic_classes.Ship;
import game.Game;
import players.Robot;

public class TestGameConsoleVersion {

	
	public static void main(String[] args) 
	{
		Game g = new Game();
		
		String playerName = g.getPlayer().getName();
		
		if(g.getPlayer().getPoints() > g.getBot().getPoints())
		{
			System.out.println(playerName + " win!");
		}
		else
		{
			System.out.println(playerName + " lose");
		}
		
		System.out.println(g.getBot().getName() + "'s board :");
		g.getBot().getBoard().printBoard();
		
		System.out.println(playerName + "'s board :");
		g.getPlayer().getBoard().printBoard();
		
		
	}

}
