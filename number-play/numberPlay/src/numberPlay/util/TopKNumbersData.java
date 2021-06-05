package numberPlay.util;

import java.util.List;

import numberPlay.observer.ObserverI;

public class TopKNumbersData implements PersisterI, TopKNumbersResultsI, ObserverI {
	@Override
	public void store(List<Double> topK) {}

	@Override
	public void writeToFile() {}
	
	@Override
	public void close() {}

	@Override
	public void update(String no) {
		// TODO Auto-generated method stub
		
	}
}
