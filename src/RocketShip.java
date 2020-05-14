import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RocketShip extends GameObject {
	int speed = 5;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
		    loadImage ("rocket.png");
		}
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
	void update() {
		super.update();
		if(up) {
			up();
		}
		if(down) {
			down();
		}
		if(left) {
			left();
		}
		if(right) {
			right();
		}
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	void up() {
		if(y>=50) {
			y -= speed;
		}
	}
	void down() {
		if(y<=750) {
			y += speed;
		}
	}
	void left() {
		if(x>=50) {
			x -= speed;
		}
	}
	void right() {
		if(x<=450) {
			x += speed;
		}
	}
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
	} 
}
