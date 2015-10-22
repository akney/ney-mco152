package ney.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class UFOTop10Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));

		Gson gson = new Gson();

		UFOList list = gson.fromJson(in, UFOList.class);

		in.close();

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// put locations and the num times into a hashmap
		for (UFOSighting ufo : list) {
			if (map.containsKey(ufo.getLocation())) {
				map.put(ufo.getLocation(), map.get(ufo.getLocation()) + 1);
			} else {
				map.put(ufo.getLocation(), 1);
			}
		}

		UFOSort sortedMap = new UFOSort(map);
		map = sortedMap.getSortedMap();
		int count = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			count++;
			if (count < 11) {
				System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
			} else {
				break;
			}
		}

	}

}
