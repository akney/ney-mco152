package ney.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));

		Gson gson = new Gson();

		UFOList list = gson.fromJson(in, UFOList.class);

		in.close();

		System.out.println(list.size());

	}

}
