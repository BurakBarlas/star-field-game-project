package spacegame;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CreditsScreen extends GameMenu{
	
	public static void creditsScreen() {
		titleNamePanel.setVisible(false);
		startMenuButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(200, 300, 800, 600);
		mainTextPanel.setBackground(Color.blue);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("BURAK BARLAS DENIZ ERK BARUT");
		mainTextArea.setBounds(100, 100, 230, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
	}
}
