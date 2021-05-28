package spacegame;
import java.awt.Color;
import spacegame.GameLayout;
import spacegame.GamePanel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
  
public class GameScreen extends GameMenu {
	
	private BufferedImage space_png;
	static JPanel testpanel;
	
	
	
	
	public static void gameScreen() throws FileNotFoundException, IOException{
		
//		titleNamePanel.setVisible(false);
//		startMenuButtonPanel.setVisible(false);
//		con.setVisible(false);
		
		GameLayout game_interface = new GameLayout("Star Field");
		
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
		
	    
		
		window.setVisible(false);
//		JPanel choiceButtonPanel = new JPanel();
//		choiceButtonPanel.setBounds(250, 350, 300, 150);
//		choiceButtonPanel.setBackground(Color.red);
//		con.add(choiceButtonPanel);
//		choiceButtonPanel.setLayout(new GridLayout(4,1));
		
	}
}
