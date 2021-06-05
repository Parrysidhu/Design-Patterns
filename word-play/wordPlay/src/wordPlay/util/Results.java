package wordPlay.util;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	public void showOutputOnConsole(SentenceUtility su) {
		System.out.println(su.toString());
	}

	public void writeOutputToFile(SentenceUtility su) {
		System.out.println(su);
	}
}
