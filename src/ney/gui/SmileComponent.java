package ney.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		// g.drawLine(0, 300, 600, 50);
		g.setColor(Color.YELLOW);
		g.fillOval(100, 50, 500, 500);
		g.setColor(Color.WHITE);
		g.fillOval(150, 100, 100, 100);
		g.fillOval(350, 100, 100, 100);
		g.setColor(Color.BLUE);
		g.fillOval(180, 100, 50, 50);
		g.fillOval(380, 100, 50, 50);
		g.setColor(Color.RED);
		g.fillArc(150, 350, 350, 150, 180, 180);
		g.setColor(Color.MAGENTA);
		g.fillArc(250, 350, 100, 200, 200, -200);
		// g.setColor(Color.BLACK);
		// int[] xpoints = { 300, 360, 400 };
		// int[] yPoints = { 350, 370, 390 };

		// g.drawPolygon(xpoints, yPoints, 3);

	}

}
