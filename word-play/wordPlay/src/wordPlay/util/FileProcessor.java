package wordPlay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	// Initializing totalWords to 1 to include last word as well
	static long totalWords = 1, totalSentences = 0;
	private int c;
	private char character;
	
	/**
	 * @param path
	 * @throws Exception
	 */
	public void processFile(String path) throws Exception {
		BufferedReader br = null;
		String singleSentence = "";
		SentenceUtility su = new SentenceUtility();
		Results res = new Results();
		try {
			File file = new File(".\\" + path);
			br = new BufferedReader(new FileReader(file));
			SentenceHandler sh = new SentenceHandler();
			while ((c = br.read()) != -1) {
				character = (char) c;
				if (character == ' ') {
//					sentence += character;
					singleSentence += character;
					++totalWords;
				} else if (character == '.') {
//					++totalWords;
					++totalSentences;
//					System.out.println(singleSentence);
					SentenceUtility.reversedString += sh.validateSentence(singleSentence);
					su = su.calculateMetrics(singleSentence);
//					System.out.println(su);
					singleSentence = "";
				} else {
//					sentence += character;
					singleSentence += character;
				}
			}

//			System.out.println(su.LONGEST_WORD);
//			System.out.println(totalWords);
//			System.out.println(totalSentences);
			res.showOutputOnConsole(su);

		} catch (IOException e) {
			throw new IOException("The file not found: " + path);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (br != null)
				br.close();
		}
	}
}
