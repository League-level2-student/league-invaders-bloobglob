import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font menuTitleFont = new Font("Arial", Font.PLAIN, 48);
	Font menuStartFont = new Font("Arial", Font.PLAIN, 24);
	Font menuInstFont = new Font("Arial", Font.PLAIN, 24);
	Font endTitleFont = new Font("Arial", Font.PLAIN, 48);
	Font endKilledFont = new Font("Arial", Font.PLAIN, 24);
	Font endRestartFont = new Font("Arial", Font.PLAIN, 24);
	RocketShip rocket = new RocketShip(250, 700, 50, 50);
	ObjectManager objMan = new ObjectManager(rocket);
	Timer frameDraw = new Timer(1000/60, this);
	Timer alienSpawn;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	void startGame(int msSpeed, ObjectManager obj) {
	    alienSpawn = new Timer(msSpeed , obj);
	    alienSpawn.start();
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	GamePanel() {
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU) {
			drawMenuState(g);
		}else if(currentState == GAME) {
			drawGameState(g);
		}else if(currentState == END) {
			drawEndState(g);
		}
	}
	void updateMenuState() {
	}
	void updateGameState() {
		objMan.update();
		rocket.update();
	}
	void updateEndState() {
	}
	void drawMenuState(Graphics g) {  
		g.setColor(Color.blue);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(menuTitleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 100);
		g.setFont(menuStartFont);
		g.drawString("Press ENTER to start", 125, 350);
		g.setFont(menuInstFont);
		g.drawString("Press SPACE for instructions", 85, 550);
	}
	void drawGameState(Graphics g) {  
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.black);
			g.fillRect(0,  0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		rocket.draw(g);
	}
	void drawEndState(Graphics g) {  
		g.setColor(Color.red);
		g.fillRect(0,  0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(endTitleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 85, 100);
		g.setFont(endKilledFont);
		g.drawString("You killed " + "" + "enemies", 142, 350);
		g.setFont(endRestartFont);
		g.drawString("Press ENTER to restart", 120, 550);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState == MENU) {
		    	startGame(1000, objMan);
			}
		    if(currentState == GAME) {
		    	alienSpawn.stop();
		    }
		    if (currentState == END) {
		        currentState = MENU;
		    }else {
		        currentState++;
		    }
		}
		if(currentState == GAME) {
			if(e.getKeyChar()==KeyEvent.VK_SPACE) {
				objMan.addProjectile(rocket.getProjectile());
			}
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    rocket.up = true;
			}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				rocket.down = true;
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				rocket.left = true;
			}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				rocket.right = true;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    rocket.up = false;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocket.down = false;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocket.left = false;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocket.right = false;
		}
	}
}
