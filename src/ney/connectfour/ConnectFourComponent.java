package ney.connectfour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ConnectFourComponent extends JComponent {
	Character player; // I made it Character b/c I do want it null

	public ConnectFourComponent() {
		player = null;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());

		if (player == null) {
			g.setColor(Color.WHITE);
			g.fillOval(20, 20, 60, 60);
		} else if (player == 'r') {
			g.setColor(Color.RED);
			g.fillOval(20, 20, 60, 60);
		} else {
			g.setColor(Color.BLUE);
			g.fillOval(20, 20, 60, 60);
		}

	}

	public void changeColor(Character player) {
		this.player = player;
		super.repaint();
	}

}
