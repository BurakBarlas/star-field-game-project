package spacegame;

import java.awt.Color;


import java.util.concurrent.ThreadLocalRandom;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.sql.Time;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Timer timer = new Timer(5,this);
	
//	private int total_time = 0;
//	private int total_bullet = 0;
	
	private ArrayList<Fire> BulletFire = new ArrayList<Fire>();
	
	private int fire_y_increaser = 3;
	private int alien_x = 300;
	private int alien_y = -90;
	private int alien_y_increaser = 2;
//	private int alien_x_increaser = 2;
	private int spaceShip_x = 0;
	private int spaceShip_y = 670;
	private int spaceShip_x_increaser = 30;
	private int spaceShip_y_increaser = 30;
	
	
	private int ship_image_width;
	private int ship_image_height;
	private int alien_image_width;
	private int alien_image_height;
	
	private BufferedImage ship_image;
	private BufferedImage space_image;
	private BufferedImage alien_image;
	private BufferedImage fire_image;
	
	
	public boolean Hit_Check() {
		
		for (Fire fire : BulletFire) {
			
			if ((new Rectangle(fire.getX(),fire.getY(),20,20)).intersects(new Rectangle(alien_x,alien_y,60,60))) {
				BulletFire.remove(fire);
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public GamePanel()  {
		try {
			ship_image = ImageIO.read(new FileImageInputStream(new File("Spaceship.png")));
			ship_image_width = ship_image.getWidth();
			ship_image_height = ship_image.getHeight();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		try {
			space_image = ImageIO.read(new FileImageInputStream(new File("Space_1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			alien_image = ImageIO.read(new FileImageInputStream(new File("Alien.png")));
			alien_image_width = alien_image.getWidth();
			alien_image_height = alien_image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fire_image = ImageIO.read(new FileImageInputStream(new File("fire.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		total_time += 5;
		g.drawImage(space_image, 0, 0, space_image.getWidth()*5/4, space_image.getHeight()*3/2,this);
		
		g.drawImage(alien_image, alien_x, alien_y, alien_image_width/20, alien_image_height/20,this);
		
		g.drawImage(ship_image, spaceShip_x, spaceShip_y, ship_image_width/10, ship_image_height/10,this);
		
		for (Fire fire : BulletFire) {
			if(fire.getY() <= 0) {
				try {
					BulletFire.remove(fire);
				} catch (Exception e) {
				}
			}
		}
		g.setColor(Color.blue);
		for (Fire fire : BulletFire) {
			g.drawImage(fire_image, fire.getX(), fire.getY(), fire_image.getWidth()/5, fire_image.getHeight()/5,this);
			
		}
		
		if(Hit_Check()) {
			alien_image_height = 0;
			alien_image_width = 0;
//			timer.stop();
//			String message = "You Won \n" +
//							 "Time : " + total_time/1000.0 + " seconds" +
//							 "\nTotal Fire : " + total_bullet;
//		
//			JOptionPane.showMessageDialog(this, message);
							
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
		
//		alien_x += alien_x_increaser;
//		if(alien_x > 600) {
//			alien_x_increaser = -alien_x_increaser;
//			
//		}
//		else if(alien_x <= 100) {
//			alien_x_increaser = -alien_x_increaser;
//		}
		alien_y += alien_y_increaser;
		if(alien_y >= 760) {
			alien_y = -90;
			alien_x = ThreadLocalRandom.current().nextInt(50, 750 + 1);
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
				spaceShip_x -= spaceShip_x_increaser;
					
			}
		}
		else if (c == KeyEvent.VK_RIGHT) {
			if(spaceShip_x >= 905) {
				spaceShip_x = 905;
			}
			else {
				spaceShip_x += spaceShip_x_increaser;
					
				
			}
			
		}
		else if(c == KeyEvent.VK_DOWN) {
          if(spaceShip_y >= 670) {
              spaceShip_y = 670;
          }
          else {
                  spaceShip_y += spaceShip_y_increaser;
          }
      }

		else if(c == KeyEvent.VK_UP) {
          if(spaceShip_y <= 500) {
              spaceShip_y = 500;
          }
          else {
                  spaceShip_y -= spaceShip_y_increaser;
          }
      }
        else if (c == KeyEvent.VK_SPACE) {
			BulletFire.add(new Fire(spaceShip_x+30,spaceShip_y-20));
//			total_bullet++;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
