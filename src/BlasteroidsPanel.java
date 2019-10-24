import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BlasteroidsPanel extends JPanel {
	//Overview: This game is played by shooting the asteroids and getting points. Try to get the most points without getting hit by an asteroid//
	//There should be a KeyListener to control arrow keys and space bar. Space bar shoots, and arrow keys move.//
	//The numbers 1, 2, and 3 are used to choose the character. The letter "i" will be used to find the instructions, and "Enter" will be used to switch states.
	
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	final int GAME = 1;
	final int MENU = 0;
	final int END = 2;
	int currentState = MENU;
	Font f = new Font("Arial", Font.PLAIN, 48);
	
	void updateGameState() {
		
	}
	
	void updateMenuState() {
		
	}
	void updateEndState() {
		
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, BlasteroidsRunner.WIDTH, BlasteroidsRunner.HEIGHT);
		
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0,0, BlasteroidsRunner.WIDTH, BlasteroidsRunner.HEIGHT);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("Blasteroids", 250, 200);
		f = new Font("Arial", Font.PLAIN, 24);
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("Press ENTER to start", 250, 400);
		g.drawString("Press i for instructions", 200, 600);
	}
	
	void drawEndState(Graphics g) {
		
	}

}
