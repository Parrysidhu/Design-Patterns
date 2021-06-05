package numberPlay.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import numberPlay.driver.Driver;
import numberPlay.observer.ObserverI;

public class RunningAverageData implements PersisterI, RunningAverageResultsI, ObserverI {

	@Override
	public void update(String num) {
		if (num != null) {
			NumberProcessor.avgNums.add(num);
			if (NumberProcessor.avgNums.size() > Driver.runAvgWindowSize) {
				NumberProcessor.avgNums.remove(0);
			}

			NumberProcessor.avgNums.trimToSize();

			double sum = 0;
			for (String number : NumberProcessor.avgNums) {
				sum += Integer.parseInt(number);
			}

			double average = sum / NumberProcessor.avgNums.size();
			store(average);
		} else {
			this.writeToFile();
		}
	}

	@Override
	public void store(Double d) {
		NumberProcessor.finalAvg.add(d);
	}

	@Override
	public void writeToFile() {
		DecimalFormat df = new DecimalFormat("####0.00");
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(Driver.runAvgOutFile);
			for (Double arrValue : NumberProcessor.finalAvg) {
				myWriter.write(String.valueOf(df.format(arrValue)));
				myWriter.write('\n');
			}

			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} finally {
			try {
				myWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void close() {
	}

}
