package ney.scrabble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {
	private HashSet<String> set;

	public static ScrabbleDictionary getInstance() {
		if (singleton == null) {
			singleton = new ScrabbleDictionary();
		}
		return singleton;
	}

	private static ScrabbleDictionary singleton;

	public ScrabbleDictionary() {
		try {
			BufferedReader input = new BufferedReader(new FileReader("US.dic"));
			set = new HashSet<String>();
			String line;
			while ((line = input.readLine()) != null) {
				set.add(input.readLine());
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean contains(String word) {
		return set.contains(word);

	}

}
