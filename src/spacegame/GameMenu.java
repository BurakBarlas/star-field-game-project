package spacegame;
import java.awt.Color; 
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import spacegame.ClickEvents.*;

public class GameMenu {
	
	JFrame window;
	static Container con;
	static JPanel titleNamePanel, startMenuButtonPanel, mainTextPanel;
	JLabel titleNameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
	static Font normalFont = new Font("Times New Roman",Font.PLAIN, 30);
	JButton startButton, multiplayerButton, creditsButton, quitButton;
	static JTextArea mainTextArea;
	

	
	public GameMenu() {
		TitleScreenHandler tsHandler = new TitleScreenHandler();
		StartMenuQuit smQuit = new StartMenuQuit();
		StartMenuMultiplayer mScreen = new StartMenuMultiplayer();
		StartMenuCredits smCredits = new StartMenuCredits();

		window = new JFrame("Star Field");
		window.setSize(800,700);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		window.setSize(800,701);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Star Field");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startMenuButtonPanel = new JPanel();
//		startMenuButtonPanel.setBounds(300, 400, 130, 50);
		startMenuButtonPanel.setBounds(300, 300, 207, 300);
		startMenuButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setBorder(BorderFactory.createLineBorder(Color.black));
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		
		multiplayerButton = new JButton("MULTIPLAYER");
		multiplayerButton.setBackground(Color.black);
		multiplayerButton.setForeground(Color.white);
		multiplayerButton.setBorder(BorderFactory.createLineBorder(Color.black));
		multiplayerButton.setFont(normalFont);
		multiplayerButton.addActionListener(mScreen);
		
		creditsButton = new JButton("CREDITS");
		creditsButton.setBackground(Color.black);
		creditsButton.setForeground(Color.white);
		creditsButton.setBorder(BorderFactory.createLineBorder(Color.black));
		creditsButton.setFont(normalFont);
		creditsButton.addActionListener(smCredits);
		
		quitButton = new JButton("QUIT");
		quitButton.setBackground(Color.black);
		quitButton.setForeground(Color.white);
		quitButton.setBorder(BorderFactory.createLineBorder(Color.black));
		quitButton.setFont(normalFont);
		quitButton.addActionListener(smQuit);
		
		titleNamePanel.add(titleNameLabel);
		startMenuButtonPanel.add(startButton);
		startMenuButtonPanel.add(multiplayerButton);
		startMenuButtonPanel.add(creditsButton);
		startMenuButtonPanel.add(quitButton);
		
		con.add(titleNamePanel);
		con.add(startMenuButtonPanel);
	}	
	
}


