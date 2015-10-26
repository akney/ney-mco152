package ney.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileJFrame extends JFrame {

	public SmileJFrame() {
		setTitle("Smile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout b = new BorderLayout();
		Container c = getContentPane();
		c.setLayout(b);
		c.add(new SmileComponent(), BorderLayout.CENTER);

	}
}
