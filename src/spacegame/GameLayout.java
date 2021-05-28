package spacegame;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

public class GameLayout	extends JFrame {

	public GameLayout(String title) throws HeadlessException {
		super(title);
	}
	
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		
		GameLayout game_interface = new GameLayout("Earth Defense");
		
		game_interface.setResizable(false);
		game_interface.setFocusable(false);
		
		game_interface.setSize(1000,800);
		
		game_interface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel game_panel = new GamePanel();
		
		game_panel.requestFocus();		
		game_panel.addKeyListener(game_panel);		
		game_panel.setFocusable(true);		
		game_panel.setFocusTraversalKeysEnabled(false);
		
		game_interface.add(game_panel);
		game_interface.setVisible(true);
		
		

	}

}
