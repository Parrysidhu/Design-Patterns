package asn5.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import asn5.util.Element;
import asn5.util.FileProcessor;
import asn5.util.MyArrayList;
import asn5.util.Results;
import asn5.util.SpellCheckAnalyzer;
import asn5.util.SpellCheckResults;
import asn5.util.TopKFreqWordsResults;
import asn5.util.TopKMostFreqAnalyzer;
import asn5.util.Visitor;

public class Driver {
	public static int Dk;
	public static StringBuilder mostFrequent = new StringBuilder();
	public static StringBuilder spellCheck = new StringBuilder();

	private static void runAnalysis(FileProcessor fileProcessor, Visitor... visitors) {
		Element myArrayList = new MyArrayList.Builder().withFileProcessor(fileProcessor).build();

		for (Visitor visitor : visitors) {
			myArrayList.accept(visitor);
		}
	}

	private static void persistResults(Results... analysisResults) {
		for (Results results : analysisResults) {
			results.writeToFile();
		}
	}

	public static void main(String[] args) {
		try {
			if (5 != args.length) {
				System.err.println("Invalid number of arguments");
				System.err.println("Program exited");
				System.exit(1);
			} else if (0 > Integer.parseInt(args[2])) {
				System.err.println("The size of the list containing the most frequent words should be more than zero.");
				System.err.println("Program exited");
				System.exit(1);
			} else {
				FileProcessor fileProcessor = new FileProcessor(args[0]);
				Dk = Integer.parseInt(args[2]);

				Results topKFreqWordsResults = new TopKFreqWordsResults(args[3]);
				Visitor topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(Integer.parseInt(args[2]),
						topKFreqWordsResults);

				Results spellCheckResults = new SpellCheckResults(args[4]);
				Visitor spellCheckAnalyzer = new SpellCheckAnalyzer(args[1], spellCheckResults);

				runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);

				persistResults(topKFreqWordsResults, spellCheckResults);
			}
		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
}
