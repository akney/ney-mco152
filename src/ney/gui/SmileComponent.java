package ney.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {
	private int y = 100;
	private int x = 100;
	private int x2 = 250;
	private int x3 = 150;
	private int h = 0;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		// g.drawLine(0, 300, 600, 50);
		g.setColor(Color.YELLOW);
		g.fillOval(x, 50, 500, 500);
		g.setColor(Color.WHITE);
		g.fillOval(150, 100, 100, 100);
		g.fillOval(350, 100, 100, 100);
		g.setColor(Color.BLUE);
		// g.fillOval(180, y, 50, 50);
		// g.fillOval(380, 100, 50, 50);
		g.setColor(Color.RED);
		g.fillArc(x3, 350, 350, 150, 180, 180);
		g.setColor(Color.MAGENTA);
		g.fillArc(x2, 350, 100, 200, 200, -200);
		g.setColor(Color.BLACK);

		g.setColor(Color.BLUE);
		g.fillOval(180, y, 50, h);
		g.fillOval(380, y, 50, h);
		y++;
		if (y == 150) {
			y = 100;
		}
		x--;
		if (x == 50) {
			x = 100;
		}
		x2--;
		if (x2 == 200) {
			x2 = 250;
		}
		h++;
		if (h == 50) {
			h = 0;
		}
		x3--;
		if (x3 == 100) {
			x3 = 150;
		}

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.repaint();

	}

}
