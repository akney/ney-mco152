package ney.physics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Projectile p = new Projectile(31, 20, 0);

		for (double time = 0; time <= 10; time = time + .5) {
			int x1 = (int) (p.getLocationX() + .05); // the .05 is
														// for
														// rounding
														// issues
			int y1 = (int) (p.getLocationY() + .05);
			p.setTime(time + .5);
			int x2 = (int) (p.getLocationX() + .05);
			int y2 = (int) (p.getLocationY() + .05);

			g.setColor(Color.RED);
			g.drawLine(x1, 600 - y1, x2, 600 - y2);

		}
		// g.drawLine(0, 500, 800, 500);
	}
}
