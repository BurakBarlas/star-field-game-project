package spacegame;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;

class Fire{
	private int x,y;

	public Fire(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}



public class GamePanel extends JPanel implements KeyListener,ActionListener{

	Timer timer = new Timer(5,this);
	
	private int total_time = 0;
	private int total_bullet = 0;
	
	private ArrayList<Fire> BulletFire = new ArrayList<Fire>();
	
	private int fire_y_increaser = 1;
	private int allien_x = 0;
	private int allien_x_increaser = 2;
	private int spaceShip_x = 0;
	private int spaceShip_x_increaser = 30;
	
	private BufferedImage ship_image;
	private BufferedImage space_image;
	private BufferedImage alien_image;
	
	public GamePanel() throws FileNotFoundException, IOException {
		ship_image = ImageIO.read(new FileImageInputStream(new File("Spaceship.png")));
		space_image = ImageIO.read(new FileImageInputStream(new File("Space.png")));
		alien_image = ImageIO.read(new FileImageInputStream(new File("Alien.png")));
		
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(space_image, 0, 0, ship_image.getWidth()*3/2, ship_image.getHeight()*3/2,this);
		
		g.drawImage(alien_image, allien_x, 0, ship_image.getWidth()/10, ship_image.getHeight()/10,this);
		
		g.drawImage(ship_image, spaceShip_x, 670, ship_image.getWidth()/10, ship_image.getHeight()/10,this);
		
		for (Fire fire : BulletFire) {
			if(fire.getY() <= 0) {
				BulletFire.remove(fire);
			}
		}
		g.setColor(Color.blue);
		for (Fire fire : BulletFire) {
			g.fillOval(fire.getX(), fire.getY(), 10, 20);
		}
	}
	

	@Override
	public void repaint() {
		super.repaint();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Fire fire : BulletFire) {
			fire.setY(fire.getY()-fire_y_increaser);
		}
		
		allien_x += allien_x_increaser;
		if(allien_x > 905) {
			allien_x_increaser = -allien_x_increaser;
			
		}
		if(allien_x <= 0) {
			allien_x_increaser = -allien_x_increaser;
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		
		if(c == KeyEvent.VK_LEFT) {
			if (spaceShip_x <= 0) {
				spaceShip_x = 0;
			}
			else {
				for(int i = 0 ; i < 30 ; i++) {
					spaceShip_x -= spaceShip_x_increaser/30;
					
				}
			}
		}
		else if (c == KeyEvent.VK_RIGHT) {
			if(spaceShip_x >= 905) {
				spaceShip_x = 905;
			}
			else {
				for(int i = 0 ; i < 30 ; i++) {
					spaceShip_x += spaceShip_x_increaser/30;
					
				}
				
			}
		}
		else if (c == KeyEvent.VK_SPACE) {
			BulletFire.add(new Fire(spaceShip_x+35,670));
			total_bullet++;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
