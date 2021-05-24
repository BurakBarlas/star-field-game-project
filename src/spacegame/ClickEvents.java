package spacegame;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ClickEvents extends GameMenu {
	
	public static class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			GameScreen.gameScreen();
		}
	}
	
	public static class StartMenuMultiplayer implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			MultiplayerScreen.multiplayerScreen();
		}
	}
	
	public static class StartMenuCredits implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			CreditsScreen.creditsScreen();
		}
	}
	
	public static class StartMenuQuit implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
}
