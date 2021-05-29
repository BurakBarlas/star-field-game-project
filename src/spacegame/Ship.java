package spacegame;

import java.awt.image.BufferedImage;

public abstract class  Ship {

	private int hP;
	private int xCord;
	private int yCord;
	private BufferedImage ship_image;
	public Ship() {
		hP = 0;
		xCord = 0;
		yCord = 0;
		ship_image = null;
		
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
}


