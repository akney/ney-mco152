package ney.ufo;

import java.io.BufferedReader;
import java.io.FileReader;

public class UFOSightingMain {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));

		Gson gson = new Gson();

		in.close();
	}
}
