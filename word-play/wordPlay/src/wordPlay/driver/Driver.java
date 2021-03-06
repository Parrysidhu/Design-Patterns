package wordPlay.driver;

import wordPlay.util.FileProcessor;

/**
 * @author Parneet LNU
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${arg0}")) || (args[1].equals("${arg1}")) || (args[2].equals("${arg2}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");
		try {
			FileProcessor fp = new FileProcessor();
			fp.processFile(args[0]);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		} finally {
		}

	}
}
