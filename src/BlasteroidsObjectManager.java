import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BlasteroidsObjectManager implements ActionListener{
	int score = 0;

	Random random = new Random();
	BlasteroidShip r;
	ArrayList<Projectile> projectiles = new ArrayList();
	ArrayList<Asteroid> asteroids = new ArrayList();

	public BlasteroidsObjectManager(BlasteroidShip r) {

		this.r = r;
	}
	
	 int getScore() {
		return score;
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAsteroid() {
		asteroids.add(new Asteroid(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < asteroids.size(); i++) {
			Asteroid temp = asteroids.get(i);
			temp.update();
		
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile temp = projectiles.get(i);
			temp.update();
			
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		r.draw(g);
		for (int i = 0; i < asteroids.size(); i++) {
			Asteroid temp = asteroids.get(i);
			temp.draw(g);

		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile temp = projectiles.get(i);
			temp.draw(g);

		}
	}
	void purgeObjects() {
		for (int i = 0; i < asteroids.size(); i++) {
			Asteroid temp = asteroids.get(i);
			if(temp.isActive==false) {
				asteroids.remove(i);
			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile temp = projectiles.get(i);
			if(temp.isActive==false) {
				projectiles.remove(i);
			}

		}
	}
	void checkCollision() {
		for (int i = 0; i < asteroids.size(); i++) {
			if(r.collisionBox.intersects(asteroids.get(i).collisionBox)) {
				asteroids.get(i).isActive = false;
				r.isActive = false;
			}
		for(int j = 0; j < projectiles.size(); j++) {
			if(asteroids.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
				asteroids.get(i).isActive = false;
				projectiles.get(j).isActive = false;
				score++;
			}
			
			
		}
	}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAsteroid();
		
	}
}
