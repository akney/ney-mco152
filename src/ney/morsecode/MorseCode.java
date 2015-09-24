package ney.morsecode;

import java.util.HashMap;

public class MorseCode {
	private StringBuilder bob;
	private HashMap<String, String> map;

	public MorseCode() {
		bob = new StringBuilder();
		map = new HashMap<String, String>();
		map.put("a", ".- ");
		map.put("b", "-... ");
		map.put("c", "-.-. ");
		map.put("d", "-.. ");
		map.put("e", ". ");
		map.put("f", "..-. ");
		map.put("g", "--. ");
		map.put("h", ".... ");
		map.put("i", ".. ");
		map.put("j", ".--- ");
		map.put("k", "-.- ");
		map.put("l", ".-.. ");
		map.put("m", "-- ");
		map.put("n", "-. ");
		map.put("o", "--- ");
		map.put("p", ".--. ");
		map.put("q", "--.- ");
		map.put("r", ".-. ");
		map.put("s", "... ");
		map.put("t", "- ");
		map.put("u", "..- ");
		map.put("v", "...- ");
		map.put("w", ".-- ");
		map.put("x", "-..- ");
		map.put("y", "-.-- ");
		map.put("z", "--.. ");
		map.put(" ", "   ");
		map.put("1", ".---- ");
		map.put("2", "..--- ");
		map.put("3", "...-- ");
		map.put("4", "....- ");
		map.put("5", "..... ");
		map.put("6", "-.... ");
		map.put("7", "--... ");
		map.put("8", "---.. ");
		map.put("9", "----. ");
		map.put("0", "------ ");
		map.put(".-", "a");
		map.put("-...", "b");
		map.put("-.-.", "c");
		map.put("-..", "d");
		map.put(".", "e");
		map.put("..-. ", "f");
		map.put("--.", "g");
		map.put("....", "h");
		map.put("..", "i");
		map.put(".---", "j");
		map.put("-.-", "k");
		map.put(".-..", "l");
		map.put("--", "m");
		map.put("-.", "n");
		map.put("---", "o");
		map.put(".--.", "p");
		map.put("--.-", "q");
		map.put(".-.", "r");
		map.put("...", "s");
		map.put("-", "t");
		map.put("..-", "u");
		map.put("...-", "v");
		map.put(".--", "w");
		map.put("-..-", "x");
		map.put("-.--", "y");
		map.put("--..", "z");
		map.put("", " ");
		map.put(".----", "1");
		map.put("..---", "2");
		map.put("...--", "3");
		map.put("....-", "4");
		map.put(".....", "5");
		map.put("-....", "6");
		map.put("--...", "7");
		map.put("---..", "8");
		map.put("----.", "9");
		map.put("-----", "0");
	}

	public String encode(String message) {
		message = message.toLowerCase();
		String[] s = message.split("");

		for (int i = 0; i < s.length; i++) {
			bob.append(map.get(s[i]));
		} // end for

		return bob.toString();

	}

	public String decode(String code) {

		String[] s = code.split(" ");

		for (int i = 0; i < s.length; i++) {
			boolean b = true;
			if(s[i].equals("")){
				if(s[i-1].equals("")){
					b = false;
				}
			}
			if(b== true)
			{			bob.append(map.get(s[i]));}
		} // end for

		return bob.toString();
	}
}
