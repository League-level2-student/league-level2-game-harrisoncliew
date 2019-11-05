import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Asteroid extends GameObject {
	public static BufferedImage image;
	int Xspeed = 0;
	int Yspeed = 0;

	public Asteroid(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 3;

	}

	void update() {
		super.update();
		y += speed;

	}

	void draw(Graphics g) {

		// g.drawImage(image, x, y, width, height, null);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
	}

	void loadImage(String imageFile) {

		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));

		} catch (Exception e) {

		}

	}
}
