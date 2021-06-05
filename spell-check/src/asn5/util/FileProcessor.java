package asn5.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class FileProcessor {
	private String line;

	public FileProcessor(String inputFilePath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		if (!Files.exists(Paths.get(inputFilePath))) {
			throw new FileNotFoundException("Invalid input file or input file in incorrect location.");
		}

		line = new String(Files.readAllBytes(Paths.get(inputFilePath)), StandardCharsets.UTF_8);
	}

	public String getLine() {
		return this.line.trim();
	}
}
