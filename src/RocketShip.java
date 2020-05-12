import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	int speed = 7;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
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
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
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
}
