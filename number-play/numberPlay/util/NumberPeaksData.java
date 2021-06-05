package numberPlay.util;

import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.text.DecimalFormat;

import numberPlay.driver.Driver;
import numberPlay.observer.ObserverI;

public class NumberPeaksData implements PersisterI, NumberPeaksResultsI, ObserverI {

	@Override
	public void update(String num) {
		if (num != null) {
			NumberProcessor.peakNums.add(num);

			if (NumberProcessor.peakNums.size() > 2) {
				NumberProcessor.peakNums.remove(0);
			}

			NumberProcessor.peakNums.trimToSize();

			if (NumberProcessor.peakNums.size() == 2) {
				BigDecimal val;
				BigDecimal nextval;
				BigDecimal[] peaks = new BigDecimal[100];

				val = new BigDecimal(NumberProcessor.peakNums.get(0));
				nextval = new BigDecimal(NumberProcessor.peakNums.get(1));
				int res = val.compareTo(nextval);

				if (res == 1) {
					for (int j = 0; j < peaks.length; j++) {
						peaks[j] = val;
					}
				}
				if (peaks[0] != null) {
					store(peaks[0].doubleValue());
				}
			}
		} else {
			this.writeToFile();
		}
	}

	@Override
	public void store(Double d) {
		NumberProcessor.finalPeaks.add(d);
	}

	@Override
	public void writeToFile() {
		DecimalFormat df = new DecimalFormat("####0.00");
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(Driver.numPeaksOutFile);
			for (Double arrValue : NumberProcessor.finalPeaks) {
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
