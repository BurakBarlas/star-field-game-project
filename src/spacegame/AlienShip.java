package spacegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class AlienShip extends Ship{
	
	private int alien_y_increaser = 4;
	private int alien_x_increaser = 2;
	
	public AlienShip () {
		super();
	}
	
	public AlienShip(int hP,int xCord,int yCord,String image_name) throws FileNotFoundException, IOException {
		this.hP = hP;
		this.xCord = xCord;
		this.yCord = yCord;
		this.image_name = image_name;
		this.ship_image = ImageIO.read(new FileImageInputStream(new File(image_name)));
		this.ship_image_width = ship_image.getWidth();
		this.ship_image_height = ship_image.getHeight();
	}
	
	
	public void TakingDamage () {
		hP -= 25;
	}

	public int getAlien_y_increaser() {
		return alien_y_increaser;
	}

	public void setAlien_y_increaser(int alien_y_increaser) {
		this.alien_y_increaser = alien_y_increaser;
	}

	public int getAlien_x_increaser() {
		return alien_x_increaser;
	}

	public void setAlien_x_increaser(int alien_x_increaser) {
		this.alien_x_increaser = alien_x_increaser;
	}
	
}
