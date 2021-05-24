package spacegame;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
  
public class GameScreen extends GameMenu {
	
	
	public static void gameScreen() {
		
		titleNamePanel.setVisible(false);
		startMenuButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.blue);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area. This game is going to be great. I'm sure of it!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
//		choiceButtonPanel = new JPanel();
//		choiceButtonPanel.setBounds(250, 350, 300, 150);
//		choiceButtonPanel.setBackground(Color.red);
//		choiceButtonPanel.setLayout(new GridLayout(4,1));
//		con.add(choiceButtonPanel);
		
	}
}
