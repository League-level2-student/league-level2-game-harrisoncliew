import java.awt.Frame;

import javax.swing.*;

public class BlasteroidsRunner {
public static void main(String[] args) {
	BlasteroidsRunner run = new BlasteroidsRunner();
	run.setup();

}
JFrame frame;
BlasteroidsPanel panel;
public static final int WIDTH = 800;
public static final int HEIGHT  = 800;



public BlasteroidsRunner() {
	frame  = new JFrame();
	panel = new BlasteroidsPanel();
	
}
void setup() {
	frame.add(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.addKeyListener(panel);
	
}
}
