package ney.morsecode;

public class MorseCode {
	private StringBuilder bob;

	public MorseCode() {
		bob = new StringBuilder();
	}

	public String encode(String message) {
		message = message.toLowerCase();

		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			switch (c) {
			case 'a':
				bob.append(".- ");
				break;
			case 'b':
				bob.append("-... ");
				break;
			case 'c':
				bob.append("-.-. ");
				break;
			case 'd':
				bob.append("-.. ");
				break;
			case 'e':
				bob.append(". ");
				break;
			case 'f':
				bob.append("..-. ");
				break;
			case 'g':
				bob.append("--. ");
				break;
			case 'h':
				bob.append(".... ");
				break;
			case 'i':
				bob.append(".. ");
				break;
			case 'j':
				bob.append(".--- ");
				break;
			case 'k':
				bob.append("-.- ");
				break;
			case 'l':
				bob.append(".-.. ");
				break;
			case 'm':
				bob.append("-- ");
				break;
			case 'n':
				bob.append("-. ");
				break;
			case 'o':
				bob.append("--- ");
				break;
			case 'p':
				bob.append(".--. ");
				break;
			case 'q':
				bob.append("--.- ");
				break;
			case 'r':
				bob.append(".-. ");
				break;
			case 's':
				bob.append("... ");
				break;
			case 't':
				bob.append("- ");
				break;
			case 'u':
				bob.append("..- ");
			case 'v':
				bob.append("...- ");
				break;
			case 'w':
				bob.append(".-- ");
				break;
			case 'x':
				bob.append("-..- ");
				break;
			case 'y':
				bob.append("-.-- ");
				break;
			case 'z':
				bob.append("--.. ");
			case ' ':
				bob.append("   ");
				break;
			case '1':
				bob.append(".---- ");
				break;
			case '2':
				bob.append("..--- ");
				break;
			case '3':
				bob.append("...-- ");
				break;
			case '4':
				bob.append("....- ");
				break;
			case '5':
				bob.append("..... ");
				break;
			case '6':
				bob.append("-.... ");
				break;
			case '7':
				bob.append("--... ");
				break;
			case '8':
				bob.append("---.. ");
				break;
			case '9':
				bob.append("----. ");
				break;
			case '0':
				bob.append("------ ");
				break;
			}// end switch
		} // end for

		return bob.toString();
	}

	public String decode(String code) {

		String[] s = code.split(" ");
		String str;
		for (int i = 0; i < s.length; i++) {
			str = s[i];
			switch (str) {
			case ".-":
				bob.append("a");
				break;
			case "-...":
				bob.append("b");
				break;
			case "-.-.":
				bob.append("c");
				break;
			case "-..":
				bob.append("d");
				break;
			case ".":
				bob.append("e");
				break;
			case "..-. ":
				bob.append("f");
				break;
			case "--. ":
				bob.append("g");
				break;
			case "....":
				bob.append("h");
				break;
			case "..":
				bob.append("i");
				break;
			case ".---":
				bob.append("j");
				break;
			case "-.-":
				bob.append("k");
				break;
			case ".-..":
				bob.append("l");
				break;
			case "--":
				bob.append("m");
				break;
			case "-.":
				bob.append("n");
				break;
			case "---":
				bob.append("o");
				break;
			case ".--.":
				bob.append("p");
				break;
			case "--.-":
				bob.append("q");
				break;
			case ".-.":
				bob.append("r");
				break;
			case "...":
				bob.append("s");
				break;
			case "-":
				bob.append("t");
				break;
			case "..-":
				bob.append("u");
				break;
			case "...-":
				bob.append("v");
				break;
			case ".--":
				bob.append("w");
				break;
			case "-..-":
				bob.append("x");
				break;
			case "-.--":
				bob.append("y");
				break;
			case "--..":
				bob.append("z");
			case "":
				if (s[i - 1].equals("")) {
					break;
				} else {
					bob.append(" ");
					break;
				}
			case ".----":
				bob.append("1");
				break;
			case "..---":
				bob.append("2");
				break;
			case "...--":
				bob.append("3");
				break;
			case "....-":
				bob.append("4");
				break;
			case ".....":
				bob.append("5");
				break;
			case "-....":
				bob.append("6");
				break;
			case "--...":
				bob.append("7");
				break;
			case "---..":
				bob.append("8");
				break;
			case "----.":
				bob.append("9");
				break;
			case "-----":
				bob.append("0");
				break;
			}// end switch
		} // end for

		return bob.toString();
	}
}
