import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	RocketShip rs;
	int score = 0;
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	int getScore() {
		return score;
	}
	ObjectManager(RocketShip rs) {
		this.rs = rs;
	}
	void addAlien() {
		aliens.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	void update() {
		checkCollision();
		purgeObjects();
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if(aliens.get(i).height>LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if(projectiles.get(i).height>LeagueInvaders.HEIGHT) {
				projectiles.get(i).isActive = false;
			}
		}
	}
	void draw(Graphics g) {
		rs.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++)  {
			if(!aliens.get(i).isActive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
	}
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if(rs.collisionBox.intersects(aliens.get(i).collisionBox)) {
				rs.isActive = false;
				aliens.get(i).isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			for (int j = 0; j < aliens.size(); j++) {
				if(projectiles.get(i).collisionBox.intersects(aliens.get(j).collisionBox)) {
					projectiles.get(i).isActive = false;
					aliens.get(j).isActive = false;
					score++;
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			addAlien();
	}
}
