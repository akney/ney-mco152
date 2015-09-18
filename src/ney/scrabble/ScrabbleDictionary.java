package ney.scrabble;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {
	private HashSet<String> set;

	public ScrabbleDictionary() {
		try {
			Scanner input = new Scanner(new File("US.dic"));
			set = new HashSet<String>();
			while (input.hasNext()) {
				set.add(input.next());
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean contains(String word) {
		return set.contains(word);
			
	}
}
