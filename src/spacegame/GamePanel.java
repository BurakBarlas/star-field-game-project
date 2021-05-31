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
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.sql.Time;

class Fire{
	private int x,y;
	private int fire_y_increaser = 3;

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
	
	public int getIncreaser() {
		return fire_y_increaser;
	}
	
}




public class GamePanel extends JPanel implements KeyListener,ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Timer timer = new Timer(5,this);
	
	private int CurrentLevel = 1;
//	private int totalKill = 0;
//	private int total_time = 0;
//	private int total_bullet = 0;
	
	private ArrayList<Fire> BulletFire = new ArrayList<Fire>();
	private ArrayList<AlienShip> AlienClubLevel_1 = new ArrayList<AlienShip>();
	private ArrayList<AlienShip> AlienClubLevel_2 = new ArrayList<AlienShip>();
	private ArrayList<AlienShip> AlienClubLevel_3 = new ArrayList<AlienShip>();
	
	
	SpaceShip SpaceShip;
	AlienShip testAlienShip;
	
	private BufferedImage fire_image;
	private BufferedImage Level_1_Space_image;
	private BufferedImage Level_2_Space_image;
	private BufferedImage Level_3_Space_image;
	private BufferedImage End_Screen_image;
	
	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
	
	public boolean Hit_Check(AlienShip Alien) {
		
		for (Fire fire : BulletFire) {
			if ((new Rectangle(fire.getX(),fire.getY(),20,20)).intersects(new Rectangle(Alien.getxCord(),Alien.getyCord(),60,60))) {
				BulletFire.remove(fire);
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public GamePanel() throws FileNotFoundException, IOException  {

		SpaceShip = new SpaceShip(100,0,670,"Spaceship.png");
		
		//LEVEL 1
		for (int i = 1;i <= 1; i++) {
			AlienClubLevel_1.add(new AlienShip(50,ThreadLocalRandom.current().nextInt(50, 750 + 1),-90-i*1000,"Alien.png"));
			
		}
		//LEVEL 2
		for (int i = 1;i <= 1; i++) {
			AlienClubLevel_2.add(new AlienShip(50,ThreadLocalRandom.current().nextInt(50, 750 + 1),-90-i*1000,"Alien.png"));
		}
		//LEVEL 3
		for (int i = 1;i <= 1; i++) {
			AlienClubLevel_3.add(new AlienShip(50,ThreadLocalRandom.current().nextInt(50, 750 + 1),-90-i*1000,"Alien.png"));
		}
		
		
		
		try {
			fire_image = ImageIO.read(new FileImageInputStream(new File("fire.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Level_1_Space_image = ImageIO.read(new FileImageInputStream(new File("Level_1_Space.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Level_2_Space_image = ImageIO.read(new FileImageInputStream(new File("Level_2_Space.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Level_3_Space_image = ImageIO.read(new FileImageInputStream(new File("Level_3_Space.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			End_Screen_image = ImageIO.read(new FileImageInputStream(new File("EndScreen.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		total_time += 5;
		if (CurrentLevel == 1) {
			g.drawImage(Level_1_Space_image, 0, 0, Level_1_Space_image.getWidth(), Level_1_Space_image.getHeight(),this);
		}
		else if (CurrentLevel == 2) {
			g.drawImage(Level_2_Space_image, 0, 0, Level_2_Space_image.getWidth(), Level_2_Space_image.getHeight(),this);
		}
		else if (CurrentLevel == 3) {
			g.drawImage(Level_3_Space_image, 0, 0, Level_3_Space_image.getWidth(), Level_3_Space_image.getHeight(),this);
		}
		else if (CurrentLevel == 4) {
			g.drawImage(End_Screen_image, 0, 0, End_Screen_image.getWidth(), End_Screen_image.getHeight(),this);
		}
		
		if (AlienClubLevel_1.size() == 0) {
			CurrentLevel = 2;
			AlienClubLevel_1.add(testAlienShip);
			System.out.println("Level 1 is Complated!");
			
			
//			g.drawImage(space_image, 0, 0, space_image.getWidth()*5/4, space_image.getHeight()*3/2,this);
		}
		if (AlienClubLevel_2.size() == 0) {
			CurrentLevel = 3;
			AlienClubLevel_2.add(testAlienShip);
			System.out.println("Level 2 is Complated!");
		}
		if (AlienClubLevel_3.size() == 0) {
			CurrentLevel = 4;
			AlienClubLevel_3.add(testAlienShip);
			System.out.println("All Levels Are Complated!");
		}
		if (CurrentLevel == 1) {
			g.drawImage(SpaceShip.getShip_image(), SpaceShip.getxCord(), SpaceShip.getyCord(), SpaceShip.getShip_image_width()/10, SpaceShip.getShip_image_height()/10,this);
			for (AlienShip Alien : AlienClubLevel_1) {
				g.drawImage(Alien.getShip_image(), Alien.getxCord(), Alien.getyCord(),
						Alien.getShip_image_width()/20, Alien.getShip_image_height()/20,this);
				
			}
			
			for (AlienShip Alien : AlienClubLevel_1) {
				if(Hit_Check(Alien)) {
					Alien.TakingDamage();
					if(Alien.gethP() <= 0) {
						Alien.setShip_image_height(0);
						Alien.setShip_image_width(0);
						AlienClubLevel_1.remove(Alien);
					}
//					timer.stop();
//					String message = "You Won \n" +
//									 "Time : " + total_time/1000.0 + " seconds" +
//									 "\nTotal Fire : " + total_bullet;
//				
//					JOptionPane.showMessageDialog(this, message);
									
				}
			}
		}
		else if (CurrentLevel == 2) {
			g.drawImage(SpaceShip.getShip_image(), SpaceShip.getxCord(), SpaceShip.getyCord(), SpaceShip.getShip_image_width()/10, SpaceShip.getShip_image_height()/10,this);
			for (AlienShip Alien : AlienClubLevel_2) {
				g.drawImage(Alien.getShip_image(), Alien.getxCord(), Alien.getyCord(),
						Alien.getShip_image_width()/20, Alien.getShip_image_height()/20,this);
				
			}
			for (AlienShip Alien : AlienClubLevel_2) {
				if(Hit_Check(Alien)) {
					Alien.sethP(Alien.gethP()-25);
					if(Alien.gethP() <= 0) {
						Alien.setShip_image_height(0);
						Alien.setShip_image_width(0);
						AlienClubLevel_2.remove(Alien);
					}
//					timer.stop();
//					String message = "You Won \n" +
//									 "Time : " + total_time/1000.0 + " seconds" +
//									 "\nTotal Fire : " + total_bullet;
//				
//					JOptionPane.showMessageDialog(this, message);
									
				}
			}
		}
		else if (CurrentLevel == 3) {
			g.drawImage(SpaceShip.getShip_image(), SpaceShip.getxCord(), SpaceShip.getyCord(), SpaceShip.getShip_image_width()/10, SpaceShip.getShip_image_height()/10,this);
			for (AlienShip Alien : AlienClubLevel_3) {
				g.drawImage(Alien.getShip_image(), Alien.getxCord(), Alien.getyCord(),
						Alien.getShip_image_width()/20, Alien.getShip_image_height()/20,this);
				
			}
			for (AlienShip Alien : AlienClubLevel_3) {
				
				if(Hit_Check(Alien)) {
					Alien.sethP(Alien.gethP()-25);
					if(Alien.gethP() <= 0) {
//						Alien.setShip_image_height(0);
//						Alien.setShip_image_width(0);
						AlienClubLevel_3.remove(Alien);
					}
//					timer.stop();
//					String message = "You Won \n" +
//									 "Time : " + total_time/1000.0 + " seconds" +
//									 "\nTotal Fire : " + total_bullet;
//				
//					JOptionPane.showMessageDialog(this, message);
									
				}
			}
		}
		
		
		
		
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
		
		
		
		
	}
	

	@Override
	public void repaint() {
		super.repaint();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Fire fire : BulletFire) {
			fire.setY(fire.getY()-fire.getIncreaser());
		}
		
//		alien_x += alien_x_increaser;
//		if(alien_x > 600) {
//			alien_x_increaser = -alien_x_increaser;
//			
//		}
//		else if(alien_x <= 100) {
//			alien_x_increaser = -alien_x_increaser;
//		}
		
		if (CurrentLevel == 1) {
			for (AlienShip Alien : AlienClubLevel_1) {
				Alien.setyCord(Alien.getyCord() + Alien.getAlien_y_increaser());
				if(Alien.getyCord() >= 760) {
					Alien.setyCord(-90);
					Alien.setxCord(ThreadLocalRandom.current().nextInt(50, 750 + 1));
				}
			}
		}
		else if (CurrentLevel == 2) {
			for (AlienShip Alien : AlienClubLevel_2) {
				Alien.setyCord(Alien.getyCord() + Alien.getAlien_y_increaser());
				if(Alien.getyCord() >= 760) {
					Alien.setyCord(-90);
					Alien.setxCord(ThreadLocalRandom.current().nextInt(50, 750 + 1));
				}
			}
		}
		else if (CurrentLevel == 3) {
			for (AlienShip Alien : AlienClubLevel_3) {
				Alien.setyCord(Alien.getyCord() + Alien.getAlien_y_increaser());
				if(Alien.getyCord() >= 760) {
					Alien.setyCord(-90);
					Alien.setxCord(ThreadLocalRandom.current().nextInt(50, 750 + 1));
				}
			}
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
			if (SpaceShip.getxCord() <= 0) {
				SpaceShip.setxCord(0);
			}
			else {
				SpaceShip.setxCord(SpaceShip.getxCord()-SpaceShip.getSpaceShip_x_increaser());	
			}
		}
		else if (c == KeyEvent.VK_RIGHT) {
			if(SpaceShip.getxCord() >= 905) {
				SpaceShip.setxCord(905);
			}
			else {
				SpaceShip.setxCord(SpaceShip.getxCord()+SpaceShip.getSpaceShip_x_increaser());
					
			}
			
		}
		else if(c == KeyEvent.VK_DOWN) {
          if(SpaceShip.getyCord() >= 670) {
        	  SpaceShip.setyCord(670);
          }
          else {
        	  SpaceShip.setyCord(SpaceShip.getyCord()+SpaceShip.getSpaceShip_y_increaser());
          }
      }

		else if(c == KeyEvent.VK_UP) {
          if(SpaceShip.getyCord() <= 500) {
        	  SpaceShip.setyCord(500);
          }
          else {
        	  SpaceShip.setyCord(SpaceShip.getyCord()-SpaceShip.getSpaceShip_y_increaser());
          }
      }
        else if (c == KeyEvent.VK_SPACE) {
			BulletFire.add(new Fire(SpaceShip.getxCord()+30,SpaceShip.getyCord()-20));
//			total_bullet++;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
