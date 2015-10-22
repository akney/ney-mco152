package ney.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.HashMap;
import java.util.TreeMap;

import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));

		Gson gson = new Gson();

		UFOList list = gson.fromJson(in, UFOList.class);

		in.close();

		System.out.println(list.size());
		System.out.println(list.get(5));

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();

		for (UFOSighting ufo : list) {
			if (map.containsKey(ufo.getLocation())) {
				map.put(ufo.getLocation(), map.get(ufo.getLocation()) + 1);
			} else {
				map.put(ufo.getLocation(), 1);
			}
		}
	}
}
