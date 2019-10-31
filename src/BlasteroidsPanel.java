import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BlasteroidsPanel extends JPanel implements ActionListener, KeyListener {
	//Overview: This game is played by shooting the asteroids and getting points. Try to get the most points without getting hit by an asteroid//
	//There should be a KeyListener to control arrow keys and space bar. Space bar shoots, and arrow keys move.//
	//The numbers 1, 2, and 3 are used to choose the character. The letter "i" will be used to find the instructions, and "Enter" will be used to switch states.
	public BlasteroidsPanel() {
		Timer frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}else if(currentState == I) {
			drawInstructState(g);
		}
		
	}
	final int GAME = 1;
	final int MENU = 0;
	final int END = 2;
	final int I = 3;
	int currentState = MENU;
	Font f = new Font("Courier New", Font.PLAIN, 48);
	Timer frameDraw;
	
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
		f = new Font("Courier New", Font.PLAIN, 48);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("Blasteroids", 225, 200);
		f = new Font("Courier New", Font.PLAIN, 24);
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("Press ENTER to start", 250, 400);
		g.drawString("Press i for instructions", 225, 600);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, BlasteroidsRunner.WIDTH, BlasteroidsRunner.HEIGHT);
		f = new Font("Courier New", Font.PLAIN, 48);
		g.setFont(f);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 250, 200);
		f = new Font("Courier New", Font.PLAIN, 24);
		g.setFont(f);
		g.setColor(Color.YELLOW);
		g.drawString("You scored points", 250, 400);
		g.drawString("Press ENTER to restart", 225, 600);
		
	}
	
	void drawInstructState(Graphics g) {
		int n = 30;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, BlasteroidsRunner.WIDTH, BlasteroidsRunner.HEIGHT);
		f = new Font("Courier New", Font.PLAIN, 48);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("Blasteroids Instructions",50, 200);
		f = new Font("Courier New", Font.PLAIN, 24);
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("Choose your character and shoot the asteroids by", n, 300);
		g.drawString("pressing the space bar. Shooting an asteroid can get", n, 350);
		g.drawString("you points. Move the rocket using the arrow keys.", n, 400);
		g.drawString("The left and right keys rotate the character, and the", n, 450);
		g.drawString("up key thrusts your character forward. Don't get", n, 500);
		g.drawString("hit by asteroids and try to get the most points.", n, 550);
		g.drawString("Press i to return to menu", 200, 650);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			System.out.println("currentState"+currentState);
			if (currentState == END) {
			        currentState = MENU;
			    } else {
			        currentState++;
			    }
			
		}
		if(e.getKeyCode()==KeyEvent.VK_I) {
			if(currentState == I) {
				 currentState = MENU;
			 }else {
			currentState = I;
			 }
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("UP");
		} 
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			System.out.println("SPACE");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
