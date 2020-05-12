import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Alien extends GameObject {
	int speed = 1;
	boolean isActive = true;
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	void update() {
		y += speed;
	}
	void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}
}
