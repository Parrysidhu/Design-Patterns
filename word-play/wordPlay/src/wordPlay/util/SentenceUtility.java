package wordPlay.util;

import java.util.*;

public class SentenceUtility {
	static long maxCount = 0, totalSentences = 0, totalWords = 0, totalCharacters = 0, longestWordLength = 1;
	static double AVG_NUM_WORDS_PER_SENTENCE, AVG_NUM_CHARS_PER_SENTENCE, MAX_FREQ_WORD;
	static String LONGEST_WORD, reversedString = "";

	/**
	 * @param word This method accepts a String which returns reversed String
	 */
	public String reverseWords(String word) {
		char[] try1 = word.toCharArray();
		String try2 = "";

		for (int i = try1.length - 1; i >= 0; i--)
			try2 += try1[i];

		return try2;
	}

	@Override
	public String toString() {
		return reversedString + "\n\nAVG_NUM_WORDS_PER_SENTENCE=" + AVG_NUM_WORDS_PER_SENTENCE
				+ ", AVG_NUM_CHARS_PER_SENTENCE=" + AVG_NUM_CHARS_PER_SENTENCE + ", MAX_FREQ_WORD=" + MAX_FREQ_WORD
				+ ", LONGEST_WORD=" + LONGEST_WORD;
	}

	/**
	 * @param sentences This method accepts array of String and calculate generic
	 *                  metrics
	 */
	public SentenceUtility calculateMetrics(String sentence) {
		SentenceUtility su = new SentenceUtility();
		// 1 AVG_NUM_WORDS_PER_SENTENCE
		totalSentences++;
		int count = 0;
		String word = "";
		ArrayList<String> words = new ArrayList<String>();

		// Reads each word
		String string[] = sentence.toLowerCase().split(" ");
		// Adding all words generated in previous step into words
		for (String s : string) {
			if (!s.isEmpty())
				words.add(s);
		}

		totalWords += words.size();
//		totalWords += sentence.split(" ").length;

		AVG_NUM_WORDS_PER_SENTENCE = (double) totalWords / totalSentences;
		AVG_NUM_WORDS_PER_SENTENCE = (double) Math.round(((double) totalWords / totalSentences) * 100) / 100;

		// 2 AVG_NUM_CHARS_PER_SENTENCE
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) != ' ')
				totalCharacters++;
		}

		AVG_NUM_CHARS_PER_SENTENCE = (double) totalCharacters / totalSentences;
		AVG_NUM_CHARS_PER_SENTENCE = (double) Math.round(((double) totalCharacters / totalSentences) * 100) / 100;

		// 3 MAX_FREQ_WORD
		// Determine the most repeated word in a file
		for (int i = 0; i < words.size(); i++) {
			count = 1;
			// Count each word in the file and store it in variable count
			for (int j = i + 1; j < words.size(); j++) {
				if (words.get(i).equals(words.get(j))) {
					count++;
					word = words.get(j);
				}
			}
			// If maxCount is less than count then store value of count in maxCount
			if (count > maxCount) {
				maxCount = count;
			}
		}

		MAX_FREQ_WORD = (double) maxCount;

		// 4 LONGEST_WORD
		for (int i = 0; i < words.size(); i++) {
			if(longestWordLength < words.get(i).length()) {
				longestWordLength = words.get(i).length();
				LONGEST_WORD = words.get(i);
//				System.out.println(su.LONGEST_WORD);
			}
		}
		

		return su;
	}
}
