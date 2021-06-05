package assignment4.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Result {
	private PrintWriter pw;
	List<String> listToAdd;

	/**
	 * Constructor: creates object for PrintWriter
	 * 
	 * @param outputFilePath file path of the output file
	 */
	public Result(String outputFilePath) {
		listToAdd = new ArrayList<>();
		try {
			pw = new PrintWriter(outputFilePath);
		} catch (FileNotFoundException e) {
			System.err.println("Output file not found.");
			System.err.println("Program exited");
			System.exit(1);
			e.printStackTrace();

		} finally {
		}
	}

	/**
	 * Writes to a file
	 * 
	 * @param builder
	 */
	public void writeToFile(StringBuilder builder) {
		pw.write(builder.toString());
		pw.flush();
	
	}

	/**
	 * Writes to standard output
	 * 
	 * @param builder
	 */
	public void writeToStdout(StringBuilder builder) {
		System.out.print(builder.toString());
	}

}
