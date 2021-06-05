package numberPlay.util;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import numberPlay.driver.Driver;
import numberPlay.observer.ObserverI;

public class TopKNumbersData implements PersisterI, TopKNumbersResultsI, ObserverI {

	@Override
	public void update(String num) {
		if (num != null) {
			BigDecimal bigNum = new BigDecimal(num);
			List<BigDecimal> finalTopK = new ArrayList<BigDecimal>();
			NumberProcessor.topKNums.add(bigNum);

			Collections.sort(NumberProcessor.topKNums, Collections.reverseOrder());

			int loopSize = (NumberProcessor.topKNums.size() < Driver.k) ? NumberProcessor.topKNums.size() : Driver.k;
			for (int i = 0; i < loopSize; i++) {
				finalTopK.add(NumberProcessor.topKNums.get(i));
				store(finalTopK.get(i).doubleValue());
			}
		} else {
			this.writeToFile();
		}
	}

	@Override
	public void store(Double d) {
		NumberProcessor.finalTopK.add(d);
	}

	@Override
	public void writeToFile() {
		DecimalFormat df = new DecimalFormat("####0.00");
		
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(Driver.topKNumOutFile);
			for (Double arrValue : NumberProcessor.finalPeaks) {
				myWriter.write(String.valueOf(df.format(arrValue)));
				myWriter.write('\n');
			}

			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred in accessing the output file." + e.getMessage());
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
