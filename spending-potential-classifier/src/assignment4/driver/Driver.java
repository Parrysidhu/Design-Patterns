package assignment4.driver;

import assignment4.util.Context;
import assignment4.util.Result;

public class Driver {
	
	public static Integer DrunningAverageWindowSize;
	public static String DinputFile, DavailableItemsFile, DoutputFile;
    public static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) {
		if (4 != args.length) {
            System.err.println("Invalid number of arguments");
            System.err.println("Program exited");
            System.exit(1);
        } else if( 0 >= Integer.parseInt(args[2])) {
        	System.err.println("Average window size cannot be less than or equal to zero");
            System.err.println("Program exited");
            System.exit(1);
        } else {
			DinputFile = args[0];
			DavailableItemsFile = args[1];
			DrunningAverageWindowSize = Integer.parseInt(args[2]);
			DoutputFile = args[3];
			Context cx = new Context();
			Result rs = new Result(DoutputFile);
			cx.setAvailableItems();
			cx.processFile();
			rs.writeToStdout(builder);
			rs.writeToFile(builder);
        }
	}

}
