package spacegame;

import java.awt.image.BufferedImage;

public abstract class  Ship {

	protected int hP;
	protected int xCord;
	protected int yCord;
	protected int spaceShip_x_increaser;
	protected int spaceShip_y_increaser;
	protected BufferedImage ship_image;
	protected int ship_image_width;
	protected int ship_image_height;
	
	String image_name;
	
	public Ship() {
		
	}
	
	public abstract void TakingDamage ();

	public int gethP() {
		return hP;
	}

	public void sethP(int hP) {
		this.hP = hP;
	}

	public int getxCord() {
		return xCord;
	}

	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public void setyCord(int yCord) {
		this.yCord = yCord;
	}

	public BufferedImage getShip_image() {
		return ship_image;
	}

	public void setShip_image(BufferedImage ship_image) {
		this.ship_image = ship_image;
	}

	public int getShip_image_width() {
		return ship_image_width;
	}

	public void setShip_image_width(int ship_image_width) {
		this.ship_image_width = ship_image_width;
	}

	public int getShip_image_height() {
		return ship_image_height;
	}

	public void setShip_image_height(int ship_image_height) {
		this.ship_image_height = ship_image_height;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
}


