package spacegame;
//import java.awt.Color;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
import java.io.IOException;

//import javax.swing.JPanel;
//import javax.swing.JTextArea;


public class ClickEvents extends GameMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
				try {
					GameScreen.gameScreen();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
