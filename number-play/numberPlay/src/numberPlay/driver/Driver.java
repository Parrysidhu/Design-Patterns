package numberPlay.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import numberPlay.observer.ObserverI;
import numberPlay.subject.SubjectI;
import numberPlay.util.FileProcessor;
import numberPlay.util.FilterI;
import numberPlay.util.NumberFilter;
import numberPlay.util.NumberPeaksData;
import numberPlay.util.NumberProcessor;
import numberPlay.util.RunningAverageData;
import numberPlay.util.TopKNumbersData;


/**
 * @author John Doe
 * TODO update the author name.
 */
public class Driver {
	public static void main(String[] args) throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 * FIXME Refactor commandline validation using the validation design taught in class.
		 */
//		final int REQUIRED_NUMBER_OF_ARGS = 6;
//		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || 
//				(args[0].equals("${inputNumStream}")) || 
//				(args[1].equals("${runAvgWindowSize}")) || 
//				(args[2].equals("${runAvgOutFile}")) ||
//				(args[3].equals("${k}")) ||
//				(args[4].equals("${topKNumOutFile}")) ||
//				(args[5].equals("${numPeaksOutFile}"))) {
//
//			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_ARGS);
//			System.exit(0);
//		}
//		
		//FileProcessor obj = new FileProcessor("input.txt");
		//for(int i=0;i<12;i++) {
		//String val = obj.poll();
		
		//if(val.contains(".")){
			//System.out.println(val);
		//}
		//}
		
		FilterI f1 = new NumberFilter();
		FilterI f2 = new NumberFilter();
		FilterI f3 = new NumberFilter();
		SubjectI tracker = new NumberProcessor();
		ObserverI NumberPeaksObserver = new NumberPeaksData();
		ObserverI RunningAverageObserver = new RunningAverageData();
		ObserverI TopKNumbersObserver = new TopKNumbersData();
		tracker.register(NumberPeaksObserver, f1);
		tracker.register(RunningAverageObserver, f1);
		tracker.register(TopKNumbersObserver, f1);
		tracker.register(TopKNumbersObserver, f2);
		tracker.register(NumberPeaksObserver, f2);
		tracker.register(NumberPeaksObserver, f3);
		tracker.register(RunningAverageObserver, f3);
		tracker.register(TopKNumbersObserver, f3);
		NumberProcessor a= new NumberProcessor();
		a.getFileData();
		
		//RunningAverageData n = new RunningAverageData();
		//n.avg();
		
		// FIXME Create an instance of each of the classes implementing PersisterI and the 
		// corresponding ResultsI interface.
		// Observers use these objects to dump data to be stored and eventually persisted 
		// to the corresponding output file.
		
		// FIXME Instantiate the subject.

		// FIXME Instantiate the observers, providing the necessary filter and the results object.

		// FIXME Register each observer with the subject for the necessary set of events.

		// FIXME Delegate control to a separate utility class/method that provides numbers one at a time, from the FileProcessor,
		// to the subject.
	}
}
