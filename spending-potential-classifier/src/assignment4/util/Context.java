package assignment4.util;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Arrays;

import assignment4.driver.Driver;

public class Context {

	public static String[][] avalItems;

	stateI basic;
	stateI luxurious;
	stateI extravagant;
	stateI currentState;

	public Context() {
		basic = new Basic(this);
		luxurious = new Luxurious(this);
		extravagant = new Extravagant(this);

		currentState = basic;
	}

	public void setAvailableItems() {
		try {
			FileProcessor fpAvl = new FileProcessor(Driver.DavailableItemsFile);
			String[][] tempItems = new String[100][2];
			String line;
			Integer i = 0;
		
			while ((line = fpAvl.poll()) != null) {
				String splitValue[] = line.split(":");
				tempItems[i][0] = splitValue[0];
				tempItems[i][1] = splitValue[1];
				i++;
			}

			avalItems = Arrays.copyOf(tempItems, i);
		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

	public void processFile() {
		try {
			FileProcessor fp = new FileProcessor(Driver.DinputFile);
			CalculateRunningAvg ca = new CalculateRunningAvg();
			String line;
			while ((line = fp.poll()) != null) {
				if (0 <= line.indexOf(":")) {
					if (0 <= line.indexOf("money")) {
						if(0 < Integer.parseInt(line.split(":")[1])) {
							double runAvg = ca.runningAvg(Integer.parseInt(line.split(":")[1]));
							if (0 <= runAvg && 10000 > runAvg) {
								setState(basic);
							} else if (0 <= runAvg && 50000 > runAvg) {
								setState(luxurious);
							} else if (0 <= runAvg && 50000 <= runAvg) {
								setState(extravagant);
							}
						} else {
							System.err.println("money can not be less than zero.");
						}
					} else {
						giveOutput(line.split(":")[1]);
					}
				}
			}
		} catch (InvalidPathException | SecurityException | IOException e) {
			e.printStackTrace();
			System.err.println("File Not Found at location : " + Driver.DinputFile);
			System.err.println("Program exited");
			System.exit(1);
		} finally {
		}
	}

	public void setState(stateI newState) {
		this.currentState = newState;
	}

	public stateI getState() {
		return currentState;
	}

	public void giveOutput(String item) {
		currentState.giveOutput(item);
	}
}
