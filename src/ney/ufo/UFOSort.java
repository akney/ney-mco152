package ney.ufo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class UFOSort {
	HashMap<String, Integer> sortedMap;

	public UFOSort(HashMap<String, Integer> map) {
		// turn hashMap into list so that we can sort it
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());

		// Create a comparator which can compare the entries based on value so
		// they can sort them, and then sorts them
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> item1, Entry<String, Integer> item2) {
				return item2.getValue().compareTo(item1.getValue());

			}
		});

		// Now transfer all of the sorted list elements back into a hashMap
		// ? for Professor Schwimmer, how come when I put it into a regular
		// HashMap it doesn't keep it sorted, why did they have to create a
		// LinkedHashMap
		sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

	}

	public HashMap<String, Integer> getSortedMap() {
		return sortedMap;
	}

}
