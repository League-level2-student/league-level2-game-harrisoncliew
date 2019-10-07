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

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Timer frameDraw;
	RocketShip ship = new RocketShip(250, 700, 50, 50);
	ObjectManager ob = new ObjectManager(ship);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Timer alienSpawn;

	void startGame() {
		alienSpawn = new Timer(250, ob);
		alienSpawn.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		ob.update();
		if(ship.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Champion Protectors", 150, 200);
		titleFont = new Font("Arial", Font.PLAIN, 24);
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("Press ENTER to start", 250, 400);
		g.drawString("Press SPACE for instructions", 200, 600);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		}

		ob.draw(g);

	}

	void drawEndState(Graphics g) {
		int score = ob.getScore();
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, 150);
		titleFont = new Font("Arial", Font.PLAIN, 24);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("You killed "+score + " enemies", 150, 400);
		g.drawString("Press ENTER to restart", 125, 600);
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

	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
			loadImage("space.png");
		}
	}

	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				ship = new RocketShip(250, 700, 50, 50);
				ob = new ObjectManager(ship);
				currentState = MENU;
				alienSpawn.stop();

			} else if (currentState == MENU) {
				currentState = GAME;
				startGame();
			} else {
				currentState++;

			}
		}

		if (currentState == GAME) {
			ship.update();

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
				if (ship.y > 0) {
					ship.up();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
				if (ship.y < 725) {
					ship.down();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				if (ship.x < 450) {
					ship.right();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				if (ship.x > 0) {
					ship.left();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				ob.addProjectile(ob.r.getProjectile());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
