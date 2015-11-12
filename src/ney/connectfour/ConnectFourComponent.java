package ney.connectfour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ConnectFourComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		g.fillOval(20, 20, 70, 70);

	}
}
