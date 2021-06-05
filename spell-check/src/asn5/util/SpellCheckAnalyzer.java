package asn5.util;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.List;

import asn5.driver.Driver;

public class SpellCheckAnalyzer implements Visitor {
	private String[] acceptableWords;

	public SpellCheckAnalyzer(String file, Results results) {
		try {
			String acceptableWords = new FileProcessor(file).getLine();
			this.acceptableWords = acceptableWords.split("\n");
		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(MyArrayList myArrayList) {
		List<MyElement> elements = myArrayList.getMyList();
		List<String> listOfWords;
		for (MyElement element : elements) {
			listOfWords = element.getListOfStrings();
			spellCheck(listOfWords);
		}
	}

	private void spellCheck(List<String> listOfWords) {

		for (String word : listOfWords) {
			for (int count = 0; count < this.acceptableWords.length; count++) {
				if (calculateDifference(word, this.acceptableWords[count])) {
					Driver.spellCheck.append(word.trim() + "::[" + this.acceptableWords[count].trim() + "]\n");
				}
			}
		}
	}

	private boolean calculateDifference(String str1, String str2) {
		int l1 = str1.trim().length();
		int l2 = str2.trim().length();
		int lmin = Math.min(l1, l2);
		int diff = 0;

		if (l1 != l2) {
			return false;
		}

		for (int i = 0; i < lmin; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				diff++;
			}
		}

		if (diff == 1)
			return true;
		else
			return false;
	}
}
