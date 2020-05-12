import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Projectile extends GameObject {
	int speed = 10;
	boolean isActive = true;
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	void update() {
		y -= speed;
	}
	void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}
}
