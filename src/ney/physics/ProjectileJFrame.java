package ney.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProjectileJFrame() {
		setTitle("Projectile Path");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout b = new BorderLayout();
		Container c = getContentPane();
		c.setLayout(b);
		c.add(new ProjectileComponent(), BorderLayout.CENTER);

	}

}
