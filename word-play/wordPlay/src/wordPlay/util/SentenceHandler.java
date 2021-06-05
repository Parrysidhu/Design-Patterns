package wordPlay.util;

public class SentenceHandler extends FileProcessor {
	/**
	 * @param sentence
	 * @throws Exception
	 */

	protected String validateSentence(String sentence) throws Exception {
		SentenceUtility su = new SentenceUtility();

		try {
			String temp = "";
			String[] words = sentence.split(" ");
			for (int i = 0; i < words.length; i++) {
				if(i == words.length-1)
					temp += su.reverseWords(words[i]);
				else
					temp += su.reverseWords(words[i]) + " ";
			}

			return temp+'.';
		} catch (Exception e) {
			throw new Exception("Words cannot be reversed.");
		}
	}
}
