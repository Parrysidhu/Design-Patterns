package asn5.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import asn5.driver.Driver;

public class TopKFreqWordsResults implements Results {

	private String fileName;
	private PrintWriter pw;

	public TopKFreqWordsResults(String output) {
		this.fileName = output;
	}

	@Override
	public void writeToFile() {
		try {
			pw = new PrintWriter(this.fileName);
			pw.write(Driver.mostFrequent.toString());
			pw.flush();
		} catch (FileNotFoundException e) {
			System.err.println("Output file not found.");
			System.err.println("Program exited");
			System.exit(1);
			e.printStackTrace();
		} finally {
		}
	}
}
