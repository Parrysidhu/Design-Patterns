package numberPlay.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import numberPlay.driver.Driver;
import numberPlay.subject.SubjectI;

public class NumberExtractor {
	
	public void getFileData(SubjectI subjectI) throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		FileProcessor obj = new FileProcessor(Driver.inputNumStream);
		NumberProcessor numProc = new NumberProcessor();
		String num;
		while ((num = obj.poll()) != null) {
			subjectI.process(numProc.generateEvent(num), num);
		}
		
		subjectI.process(Events.PROCESSING_COMPLETE, num);
	}
}
