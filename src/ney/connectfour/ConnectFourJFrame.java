package ney.connectfour;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class ConnectFourJFrame extends JFrame {
	public ConnectFourJFrame() {
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout g = new GridLayout(6, 7);
		Container c = getContentPane();
		c.setLayout(g);
		// c.setBackground(Color.GREEN);
		for (int i = 0; i < 42; i++) {
			c.add(new ConnectFourComponent());
		}

	}
}
