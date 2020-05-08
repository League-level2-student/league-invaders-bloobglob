import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel gamePanel = new GamePanel();
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	LeagueInvaders(){
		frame = new JFrame();
		frame.addKeyListener(gamePanel);
	}
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
		invaders.setup();
	}
}
