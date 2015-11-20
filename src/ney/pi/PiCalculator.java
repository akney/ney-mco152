package ney.pi;

public class PiCalculator {
	public double calculate(long iterations) {
		double pi = 0;
		double denominator = 1;
		boolean positive = true;

		for (int i = 1; i < iterations; i++) {
			if (positive) {
				pi += 4.0 / denominator;
			} else {
				pi -= 4.0 / denominator;
			}
			denominator += 2;
			positive = !positive;

		}
		return pi;
	}
}
