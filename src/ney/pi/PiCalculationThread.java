package ney.pi;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread {
	private JLabel label;

	public PiCalculationThread(JLabel label) {
		this.label = label;
	}

	@Override
	public void run() {
		PiCalculator pc = new PiCalculator();
		double pi = pc.calculate(1000000000);
		label.setText(String.valueOf(pi));
	}
}
