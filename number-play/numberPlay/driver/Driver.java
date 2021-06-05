package numberPlay.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import numberPlay.observer.ObserverI;
import numberPlay.subject.SubjectI;
import numberPlay.util.Events;
import numberPlay.util.FilterI;
import numberPlay.util.NumberExtractor;
import numberPlay.util.NumberFilter;
import numberPlay.util.NumberPeaksData;
import numberPlay.util.NumberProcessor;
import numberPlay.util.RunningAverageData;
import numberPlay.util.TopKNumbersData;


/**
 * @author Parneet LNU
 */
public class Driver {

	public static int k;
	public static String inputNumStream;
	public static int runAvgWindowSize;
	public static String runAvgOutFile;
	public static String topKNumOutFile;
	public static String numPeaksOutFile;
	
	public static void main(String[] args) throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 * FIXME Refactor commandline validation using the validation design taught in class.
		 */
		final int REQUIRED_NUMBER_OF_ARGS = 6;
		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || 
				(args[0].equals("${inputNumStream}")) || 
				(args[1].equals("${runAvgWindowSize}")) || 
				(args[2].equals("${runAvgOutFile}")) ||
				(args[3].equals("${k}")) ||
				(args[4].equals("${topKNumOutFile}")) ||
				(args[5].equals("${numPeaksOutFile}"))) {

			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_ARGS);
			System.exit(0);
		}

		Driver.inputNumStream = args[0];
		Driver.runAvgWindowSize = Integer.parseInt(args[1]);
		Driver.runAvgOutFile = args[2];
		Driver.k = Integer.parseInt(args[3]);
		Driver.topKNumOutFile = args[4];
		Driver.numPeaksOutFile = args[5];
		
		FilterI f1 = new NumberFilter(Events.INTEGER_EVENT);
		FilterI f2 = new NumberFilter(Events.FLOATING_POINT_EVENT);
		FilterI f3 = new NumberFilter(Events.PROCESSING_COMPLETE);
		
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
		
		NumberExtractor a = new NumberExtractor();
		a.getFileData(tracker);
	}
}
