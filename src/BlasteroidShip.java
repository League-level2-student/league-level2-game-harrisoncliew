import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class BlasteroidShip extends BlasteroidsGameObject {
	public static BufferedImage image;
	
	

	public BlasteroidShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 20;
		
	}

	public Projectile getProjectile() {
		return new Projectile(x + width / 2, y, 10, 10);
	}

	void update() {
		super.update();
		
	}
	void draw(Graphics g) {
		
			//g.drawImage(image, x, y, width, height, null);
		
			g.setColor(Color.YELLOW);
			g.fillRect(x, y, width, height);
		}
	

	public void turnRight() {
		
	}

	public void turnLeft() {
		
	}

	public void up() {
		y -= speed;
	}

	

	void loadImage(String imageFile) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			} catch (Exception e) {
			}
	}
}
