import javax.swing.JFrame;

public class LeagueInvaders {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
	GamePanel gamePanel = new GamePanel();
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	LeagueInvaders(){
		frame = new JFrame();
	}
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void updateMenuState() {
		
	}
	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
		invaders.setup();
	}
}
