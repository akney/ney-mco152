package ney.pi;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiFrame extends JFrame {
	public PiFrame() {
		setTitle("PI!");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel l = new JLabel("Pi calculation in process....");

		Container cp = getContentPane();
		cp.add(l);

		PiCalculationThread thread = new PiCalculationThread(l);

		thread.start();

	}
}
