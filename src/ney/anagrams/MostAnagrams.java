package ney.anagrams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostAnagrams {
	public static void main(String args[]) {
		try {
			BufferedReader input = new BufferedReader(new FileReader("US.dic"));
			// makes a HashMap for a word group
			HashMap<Character, Integer> wordGroup = new HashMap<Character, Integer>();

			// Makes a Hash Map of the word group and an Array of the words that
			// belong to that word group
			HashMap<HashMap<Character, Integer>, ArrayList<String>> anagrams = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();

			// making the first hash group
			String word = input.readLine();
			ArrayList<String> words = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				if (!wordGroup.containsKey(word.charAt(i))) {
					wordGroup.put(word.charAt(i), 1);
				} else {
					wordGroup.put(word.charAt(i), wordGroup.get(word.charAt(i)) + 1);
				}
			}
			words.add(word);
			anagrams.put(wordGroup, words);

			String line;

			while ((line = input.readLine()) != null) {
				wordGroup = new HashMap<Character, Integer>();
				words = new ArrayList<>();

				word = input.readLine(); // get next word

				for (int i = 0; i < word.length(); i++) { // figure out the
															// word's word group
															// by making a hash
															// map
					if (!wordGroup.containsKey(word.charAt(i))) {
						wordGroup.put(word.charAt(i), 1);
					} else {
						wordGroup.put(word.charAt(i), wordGroup.get(word.charAt(i)) + 1);
					}
				} // end for

				if (anagrams.containsKey(wordGroup)) { // if the word group
														// already exists add
														// the word to that
														// anagram arrayList
					anagrams.get(wordGroup).add(word);
				} else { // if the word group does not exist add it to the
							// anagrams HashMap along with the word
					words.add(word);
					anagrams.put(wordGroup, words);
				}
			} // end while

			input.close();

			int k, highest = 0;
			HashMap<Character, Integer> holder = new HashMap<Character, Integer>();
			HashMap<Character, Integer> holder2 = new HashMap<Character, Integer>();

			for (Map.Entry<HashMap<Character, Integer>, ArrayList<String>> entry : anagrams.entrySet()) {
				k = entry.getValue().size();
				if (k > highest) {
					highest = k;
					holder = entry.getKey();
				}
				if (k == highest) {
					holder2 = entry.getKey();
				}
			}

			System.out.println(anagrams.get(holder));

			if (holder2 != null) {
				System.out.print("Another most anagrams set: " + anagrams.get(holder2));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
