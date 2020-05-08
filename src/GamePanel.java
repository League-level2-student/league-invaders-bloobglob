import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = END;
	Font menuTitleFont = new Font("Arial", Font.PLAIN, 48);
	Font menuStartFont = new Font("Arial", Font.PLAIN, 24);
	Font menuInstFont = new Font("Arial", Font.PLAIN, 24);
	Font endTitleFont = new Font("Arial", Font.PLAIN, 48);
	Font endKilledFont = new Font("Arial", Font.PLAIN, 24);
	Font endRestartFont = new Font("Arial", Font.PLAIN, 24);
	Timer frameDraw = new Timer(1000/60, this);
	GamePanel() {
		frameDraw.start();
	}
	@Override
	public void paintComponent(Graphics g){
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
		g.setColor(Color.black);
		g.fillRect(0,  0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.red);
		g.fillRect(0,  0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(endTitleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 85, 100);
		g.setFont();
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
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    }else {
		        currentState++;
		    }
		}
		if(currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
			}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
