package frozen00000;

import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			char[] data = in.nextLine().toCharArray();
			revers(data);
			System.out.println(data);
		};
	}

	private static void revers(char[] data) {
		// first reverse whole string
		reverse(data, 0, data.length);
		// after that revers back words separately
		boolean word = false;
		int begin = 0;
		for (int i = 0; i < data.length; i++) {
			if (!word && data[i] != ' ') { // first character of word
				word = true;
				begin = i;
			} else if (word && data[i] == ' ') { // word is finished, let's reverse it
				reverse(data, begin, i - begin);
				word = false;
			}
		}
		if (word) { // revere remaining word
			reverse(data, begin, data.length - begin);
		}

	}

	private static void reverse(char[] data, int begin, int length) {
		for (int i = 0; i < length / 2; i++) {
			switchCharacters(data, begin + i, begin + length - 1 - i);
		}
	}

	private static void switchCharacters(char[] data, Integer first, Integer second) {
		char temp = data[first];
		data[first] = data[second];
		data[second] = temp;
	}

}
