package ney.pi;

public class CalculatePI {
	public static void main(String[] args) {
		double pi = 0;
		double odd = 1;
		for (int i = 0; i < 500000; i++) {
			if (i % 2 == 0) {
				pi += 4 / odd;
			} else {
				pi -= 4 / odd;
			}
			odd += 2;
		}

		System.out.print(pi);
	}
}
